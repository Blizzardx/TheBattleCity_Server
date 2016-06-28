package server.Moudle.Room;

import org.apache.thrift.TBase;
import server.Handler.EventHandler;
import server.Moudle.Item.GenItemManager;
import server.Moudle.Item.ItemInfo;
import server.Moudle.World.WorldLogic;
import server.msg.auto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/12.
 */
public class RoomLogic implements BattleFrameUpdate.Callback
{
    private ArrayList<PlayerInfo> m_PlayerInfo = new ArrayList<PlayerInfo>();
    private ArrayList<Integer> m_ClientList = new ArrayList<Integer>();
    private ArrayList<Integer> m_ReadyClientList = new ArrayList<Integer>();
    private HashMap<Integer,Integer> m_PlayerClientIdToUid = new HashMap<Integer, Integer>();
    private String m_strRoomName;
    private RoomStatus m_RoomStatus;
    private int m_MapPlayerCount;
    private String m_strMapName;
    private GenItemManager m_ItemMgr;

    public ArrayList<Integer> GetClientIdList()
    {
        return m_ClientList;
    }
    public void CreateRoom(String name,int playerCount,String mapName)
    {
        // init room
        m_strRoomName = name;
        m_RoomStatus = RoomStatus.Wait;
        m_MapPlayerCount = playerCount;
        m_strMapName = mapName;
    }
    public void AddPlayer(int clientid, PlayerInfo player)
    {
        if(m_RoomStatus != RoomStatus.Wait)
        {
            return;
        }
        //check room status

        //check is content client id
        for(int i=0;i<m_ClientList.size();++i)
        {
            if(m_ClientList.get(i) == clientid)
            {
                return;
            }
        }

        //add to store
        m_ClientList.add(clientid);
        m_PlayerInfo.add(player);

        m_PlayerClientIdToUid.put(clientid,player.uid);

        //sync add player
        SyncAddPlayer(player);

        //check can start battle
        CheckCanLoadBattle();
    }
    public void RemovePlayer(int clientid)
    {
        if(!m_PlayerClientIdToUid.containsKey(clientid))
        {
            return;
        }
        int playerUid = m_PlayerClientIdToUid.get(clientid);
        if(m_RoomStatus != RoomStatus.Wait)
        {
            return;
        }

        boolean isExe = false;

        //check is content client id
        for(int i=0;i<m_ClientList.size();++i)
        {
            if(m_ClientList.get(i) == clientid)
            {
                m_ClientList.remove(i);
                break;
            }
        }

        //check
        for(int i=0;i<m_PlayerInfo.size();++i)
        {
            if(m_PlayerInfo.get(i).uid == playerUid)
            {
                isExe = true;
                m_PlayerInfo.remove(i);
                break;
            }
        }

        if(isExe)
        {
            SyncRemovePlayer(playerUid);
        }

    }
    public void LosePlayer(int clientid)
    {
        if(m_RoomStatus == RoomStatus.Wait)
        {
            RemovePlayer(clientid);
            return;
        }

        //check is content client id
        for(int i=0;i<m_ClientList.size();++i)
        {
            if(m_ClientList.get(i) == clientid)
            {
                m_ClientList.remove(i);
                break;
            }
        }

        //test code
        // to do
        SCBattleEnd server = new SCBattleEnd();
        server.isWin = true;

        Iterator iter = m_PlayerClientIdToUid.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer)(entry.getKey());

            EventHandler.GetInstance().SendMessageToClient(key,server);
        }
        m_RoomStatus = RoomStatus.Ready;
        ClearRoom();
    }
    public String GetRoomName()
    {
        return m_strRoomName;
    }
    public String GetMapName()
    {
        return m_strMapName;
    }
    public void OnBattleLoadEnd(int clientId)
    {
        for(int i=0;i<m_ReadyClientList.size();++i)
        {
            if(m_ReadyClientList.get(i) == clientId)
            {
                return;
            }
        }
        m_ReadyClientList.add(clientId);
        CheckCanBeginBattle();
    }
    public void Handler( CSHandler client)
    {
        SCHandler server = new SCHandler();
        server.playerUid = client.playerUid;
        server.moveDirection = client.moveDirection;
        server.currentPosition = client.currentPosition;
        BoradCastMsgToRoom(server);

        //trigger update
        UpdateRoomInfo();
    }
    public void Fire(CSFire client)
    {
        SCFire server = new SCFire();
        server.playerUid = client.playerUid;
        server.fireInfoList = client.fireInfoList;
        BoradCastMsgToRoom(server);
    }
    public void Hurt(CSHurt client)
    {
        SCHurt server = new SCHurt();
        server.playerUid = client.playerUid;
        server.hurtValue = client.hurtValue;
        BoradCastMsgToRoom(server);
    }
    public RoomStatus GetRoomStatus()
    {
        return m_RoomStatus;
    }
    public boolean IsEmpty()
    {
        return m_ClientList.size() == 0;
    }
    public PlayerInfo GenPlayer(String name)
    {
        PlayerInfo res = new PlayerInfo();
        res.uid = GenUid();
        res.name = name;
        res.meshName = "Tank_0";
        res.positionId = GenPositionId();
        res.hp = 100;

        return res;
    }
    public void BattleEnd(CSBattleEnd client)
    {
        if(m_RoomStatus != RoomStatus.Battle)
        {
            return;
        }
        // to do
        SCBattleEnd server = new SCBattleEnd();

        Iterator iter = m_PlayerClientIdToUid.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer)(entry.getKey());
            Integer val = (Integer)(entry.getValue());

            if(val == client.playerUid)
            {
                server.isWin = client.isWin;
            }
            else
            {
                server.isWin = !client.isWin;
            }
            EventHandler.GetInstance().SendMessageToClient(key,server);
        }
        m_RoomStatus = RoomStatus.Ready;
    }
    public void UseItem(CSUseItem client)
    {
        if(null == m_ItemMgr)
        {
            return;
        }
        if(m_ItemMgr.TryUseItem(client.itemId,client.positionId))
        {
            SCUsedItem server = new SCUsedItem();
            server.itemId = client.itemId;
            server.positionId = client.positionId;
            server.playerUid = client.playerUid;
            BoradCastMsgToRoom(server);
        }
    }
    public void ItemGenFundamental(CSItemGenFundamental client)
    {
        m_ItemMgr = new GenItemManager();
        m_ItemMgr.Initialize(client.genFundamental);

        //sync init item
        SyncInitItemInfo();
    }
    private void CheckCanLoadBattle()
    {
        if(m_ClientList.size() == m_MapPlayerCount)
        {
            // trigger to begin battle
            BeginLoadBattle();
        }
    }
    private void CheckCanBeginBattle()
    {
        if(m_ReadyClientList.size() == m_MapPlayerCount)
        {
            BeginBattle();
        }
    }
    private void BeginBattle()
    {
        SCBattleBegin server = new SCBattleBegin();
        server.cd = 1000;

        BoradCastMsgToRoom(server);
        m_RoomStatus = RoomStatus.Battle;

        BeginSendLogicFrame();
    }
    private void BeginLoadBattle()
    {
        SCBeginLoadBattle server = new SCBeginLoadBattle();

        BoradCastMsgToRoom(server);
        m_RoomStatus = RoomStatus.Ready;
    }
    private void ClearRoom()
    {
        m_PlayerClientIdToUid.clear();
        m_ClientList.clear();

        EndSendLogicFrame();
    }
    private int GenUid()
    {
        for(int i=0;i<m_MapPlayerCount;++i)
        {
            //check is content
            boolean has = false;
            for(int j=0;j<m_PlayerInfo.size();++j)
            {
                if(m_PlayerInfo.get(j).uid == i)
                {
                    has = true;
                    break;
                }
            }

            if(!has)
            {
                return i;
            }
        }
        return m_MapPlayerCount;
    }
    private int GenPositionId()
    {
        for(int i=0;i<m_MapPlayerCount;++i)
        {
            //check is content
            boolean has = false;
            for(int j=0;j<m_PlayerInfo.size();++j)
            {
                if(m_PlayerInfo.get(j).positionId == i)
                {
                    has = true;
                    break;
                }
            }

            if(!has)
            {
                return i;
            }
        }
        return m_MapPlayerCount;
    }
    private void BoradCastMsgToRoom(TBase msg)
    {
        for(int i=0;i<m_ClientList.size();++i)
        {
            EventHandler.GetInstance().SendMessageToClient(m_ClientList.get(i),msg);
        }
    }
    private void SyncAddPlayer(PlayerInfo player)
    {
        for(int i=0;i<m_PlayerInfo.size();++i)
        {
            SCSyncPlayerInfo server = new SCSyncPlayerInfo();
            server.playerInfomation = m_PlayerInfo.get(i);
            BoradCastMsgToRoom(server);
        }
    }
    private void SyncRemovePlayer(int playerUid)
    {
        // to do
    }
    private void SyncInitItemInfo()
    {
        // random item info
        ArrayList<ItemInfo> res = m_ItemMgr.GetInitItem();
        for(int i=0;i<res.size();++i)
        {
            ItemInfo elem = res.get(i);
            SCCreateItem server = new SCCreateItem();
            server.itemId = elem.m_iItemId;
            server.positionId = elem.m_iPositionId;
            BoradCastMsgToRoom(server);
        }
    }
    private void UpdateRoomInfo()
    {
        if(null == m_ItemMgr)
        {
            return;
        }
        if(m_ItemMgr.Update())
        {
            // random item info
            ArrayList<ItemInfo> res = m_ItemMgr.RandomGen();
            for(int i=0;i<res.size();++i)
            {
                ItemInfo elem = res.get(i);
                SCCreateItem server = new SCCreateItem();
                server.itemId = elem.m_iItemId;
                server.positionId = elem.m_iPositionId;
                BoradCastMsgToRoom(server);
            }
        }
    }
    public void OnClientFrame()
    {

    }
    private void BeginSendLogicFrame()
    {
        // add to tick list
        WorldLogic.GetInstance().RegisterToTicklist(this);
    }
    private void EndSendLogicFrame()
    {
        // remove from tick list
        WorldLogic.GetInstance().UnregisterFromTicklist(this);
    }
    public void Tick()
    {
    }

    public void BroadcastCmd(SCBattleLogicFrame msg)
    {
        BoradCastMsgToRoom(msg);
    }
}
