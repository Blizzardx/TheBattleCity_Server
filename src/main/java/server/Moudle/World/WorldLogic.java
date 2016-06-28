package server.Moudle.World;

import server.Handler.EventHandler;
import server.Message.MessageObject;
import server.Moudle.Room.RoomLogic;
import server.Moudle.Room.RoomStatus;
import server.msg.auto.*;

import java.util.*;

/**
 * Created by Administrator on 2016/3/12.
 */
public class WorldLogic
{
    private static WorldLogic m_Instance;
    public static WorldLogic GetInstance()
    {
        if(null == m_Instance)
        {
            m_Instance = new WorldLogic();
        }
        return m_Instance;
    }
    private WorldLogic()
    {

    }

    private HashMap<String,RoomLogic> m_RoomMap = new HashMap<String, RoomLogic>();
    private HashMap<Integer,RoomLogic> m_ClientRoomMap = new HashMap<Integer, RoomLogic>();
    private ArrayList<RoomLogic> m_RoomTickList = new ArrayList<RoomLogic>();

    // message
    public void OnPing(MessageObject obj)
    {
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,new SCPongMsg());
    }
    public void OnRoomList(MessageObject obj)
    {
        CSRoomList client = (CSRoomList)(obj.m_MessageBody);
        if(null == client || client.requestCount <= 0)
        {
            // do noting
            return;
        }

        SCRoomList server = new SCRoomList();
        server.roomList = new ArrayList<RoomInfo>(client.requestCount);

        int count = 0;
        // return room list
        Iterator iter = m_RoomMap.entrySet().iterator();
        while (iter.hasNext() && count < client.requestCount)
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            RoomLogic val = (RoomLogic)(entry.getValue());
            if(val.GetRoomStatus()== RoomStatus.Wait)
            {
                RoomInfo elem = new RoomInfo();
                elem.name = val.GetRoomName();
                elem.mapName = val.GetMapName();
                server.roomList.add(elem);
                ++ count;
            }
        }
        //return result
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
    }
    public void OnSearchRoom(MessageObject obj)
    {
        CSSearchRoom client = (CSSearchRoom)(obj.m_MessageBody);
        if(null == client )
        {
            // do noting
            return;
        }

        SCSearchRoom server = new SCSearchRoom();

        if(m_RoomMap.containsKey(client.name))
        {
            RoomLogic val = m_RoomMap.get(client.name);
            server.roomInformation = new RoomInfo();
            server.roomInformation.name = val.GetRoomName();
            server.roomInformation.mapName = val.GetMapName();
        }

        //return result
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
    }
    public void OnCreateRoom(MessageObject obj)
    {
        CSCreateRoom client = (CSCreateRoom)(obj.m_MessageBody);
        if(null == client || null == client.roomInformation )
        {
            // do noting
            return;
        }

        SCCreateRoom server = new SCCreateRoom();

        // check name
        if(m_RoomMap.containsKey(client.roomInformation.name))
        {
            server.isSucceed = false;
            server.errorInfo = "name content";

            //return result
            EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
            return;
        }

        // create room
        RoomLogic room = new RoomLogic();
        room.CreateRoom(client.roomInformation.name,client.roomInformation.roomMemberCount,client.roomInformation.mapName);
        server.isSucceed = true;
        PlayerInfo player = room.GenPlayer(client.playerName);
        server.playerUid = player.uid;

        //add to store
        m_RoomMap.put(client.roomInformation.name,room);
        m_ClientRoomMap.put(obj.m_iClientId,room);

        //return result
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);

        //sync player info to other client
        room.AddPlayer(obj.m_iClientId,player);
    }
    public void OnEnterRoom(MessageObject obj)
    {
        CSEnterRoom client = (CSEnterRoom)(obj.m_MessageBody);
        if(null == client )
        {
            // do noting
            return;
        }

        SCEnterRoom server = new SCEnterRoom();

        //get room
        if(!m_RoomMap.containsKey(client.roomName))
        {
            server.isSucceed = false;
            server.errorInfo = "no exit room";

            //return result
            EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
            return;
        }

        RoomLogic room = m_RoomMap.get(client.roomName);
        //check room is ready
        if(room.GetRoomStatus() != RoomStatus.Wait)
        {
            server.isSucceed = false;
            server.errorInfo = "room is on battle";

            //return result
            EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
            return;
        }
        PlayerInfo player = room.GenPlayer(client.playerName);
        server.playerUid = player.uid;
        server.isSucceed = true;

        //add to store
        m_RoomMap.put(room.GetRoomName(),room);
        m_ClientRoomMap.put(obj.m_iClientId,room);

        //return result
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);

        //sync player info to other client
        room.AddPlayer(obj.m_iClientId,player);
    }
    public void OnBattleLoadEnd(MessageObject obj)
    {
        CSBattleLoadEnd client = (CSBattleLoadEnd)(obj.m_MessageBody);
        if(null == client )
        {
            // do noting
            return;
        }

        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.OnBattleLoadEnd(obj.m_iClientId);
        }
    }
    public void OnHandler(MessageObject obj)
    {
        CSHandler client = (CSHandler)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.Handler(client);
        }
    }
    public void OnFire(MessageObject obj)
    {
        CSFire client = (CSFire)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.Fire(client);
        }
    }

    public void OnLoseClient(MessageObject obj)
    {
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.LosePlayer(obj.m_iClientId);

            //check empty
            if(room.IsEmpty())
            {
                // remove room
                m_RoomMap.remove(room.GetRoomName());
                m_ClientRoomMap.remove(obj.m_iClientId);
            }
        }
    }
    public void OnHurt(MessageObject obj)
    {
        CSHurt client = (CSHurt)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.Hurt(client);
        }
    }
    public void OnBattleEnd(MessageObject obj)
    {
        CSBattleEnd client = (CSBattleEnd)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.BattleEnd(client);
            ClearRoom(room);
        }
    }
    private void ClearRoom(RoomLogic room)
    {
        ArrayList<Integer> clientList = room.GetClientIdList();
        for(int i=0;i<clientList.size();++i)
        {
            m_ClientRoomMap.remove(clientList.get(i));
        }
        m_RoomMap.remove(room.GetRoomName());
    }
    public void OnItemGenFundamental(MessageObject obj)
    {
        CSItemGenFundamental client = (CSItemGenFundamental)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.ItemGenFundamental(client);
        }
    }
    public void OnUseItem(MessageObject obj)
    {
        CSUseItem client = (CSUseItem)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.UseItem(client);
        }
    }
    public void OnBattleLogicCmd(MessageObject obj)
    {
        CSBattleLogicFrame msg = (CSBattleLogicFrame)(obj.m_MessageBody);
        //find room by client id
        if(m_ClientRoomMap.containsKey(obj.m_iClientId))
        {
            RoomLogic room = m_ClientRoomMap.get(obj.m_iClientId);
            room.OnClientCmd(obj.m_iClientId,msg);
        }
    }
    public void RegisterToTicklist(RoomLogic room)
    {
        if(m_RoomTickList.contains(room))
        {
            return;
        }
        m_RoomTickList.add(room);
    }
    public void UnregisterFromTicklist(RoomLogic room)
    {
        for(int i=0;i<m_RoomTickList.size();++i)
        {
            if( room == m_RoomTickList.get(i))
            {
                m_RoomTickList.remove(i);
                break;
            }
        }
    }
    public void Tick()
    {
        for(int i=0;i<m_RoomTickList.size();++i)
        {
            m_RoomTickList.get(i).Tick();
        }
    }
}
