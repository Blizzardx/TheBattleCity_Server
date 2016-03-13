package server.Moudle.Room;

import org.apache.thrift.TBase;
import server.Handler.EventHandler;
import server.msg.auto.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/12.
 */
public class RoomLogic
{
    private ArrayList<PlayerInfo> m_PlayerInfo = new ArrayList<PlayerInfo>();
    private ArrayList<Integer> m_ClientList = new ArrayList<Integer>();
    private ArrayList<Integer> m_ReadyClientList = new ArrayList<Integer>();
    private String m_strRoomName;
    private RoomStatus m_RoomStatus;
    private int m_MapPlayerCount;
    private String m_strMapName;

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

        //sync add player
        SyncAddPlayer(player);

        //check can start battle
        CheckCanLoadBattle();
    }
    public void RemovePlayer(int clientid,int playerUid)
    {
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
    public void LosePlayer(int clientid,int playerUid)
    {
        if(m_RoomStatus == RoomStatus.Wait)
        {
            RemovePlayer(clientid,playerUid);
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
    }
    public void Fire(CSFire client)
    {
        SCFire server = new SCFire();
        server.playerUid = client.playerUid;
        server.currentPosition = client.currentPosition;
        server.fireDirection = client.fireDirection;
        server.bulletName = client.bulletName;
        BoradCastMsgToRoom(server);
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
    }
    private void BeginLoadBattle()
    {
        SCBeginLoadBattle server = new SCBeginLoadBattle();

        BoradCastMsgToRoom(server);
        m_RoomStatus = RoomStatus.Ready;
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
        SCSyncPlayerInfo server = new SCSyncPlayerInfo();
        server.playerInfomation = player;
        BoradCastMsgToRoom(server);
    }
    private void SyncRemovePlayer(int playerUid)
    {
        // to do
    }
}
