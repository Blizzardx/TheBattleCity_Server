package server.Moudle.World;

import server.Handler.EventHandler;
import server.Message.MessageObject;
import server.Moudle.Room.RoomLogic;
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
            RoomInfo elem = new RoomInfo();
            elem.name = val.GetRoomName();
            elem.mapName = val.GetMapName();
            server.roomList.add(elem);
            ++ count;
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

        if(m_ClientRoomMap.containsKey(client.name))
        {
            RoomLogic val = m_ClientRoomMap.get(client.name);
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
        if(m_ClientRoomMap.containsKey(client.roomInformation.name))
        {
            server.isSucceed = false;
            server.errorInfo = "name content";

            //return result
            EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,server);
            return;
        }

        // create room
        RoomLogic room = new RoomLogic();
        room.CreateRoom(client.roomInformation.name,2,client.roomInformation.mapName);
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

    }
    public void OnReady(MessageObject obj)
    {

    }
    public void OnHandler(MessageObject obj)
    {
        CSHandler client = (CSHandler)(obj.m_MessageBody);
        SCHandler handler = new SCHandler();
        handler.playerUid = client.playerUid;
        handler.moveDirection = client.moveDirection;
        handler.currentPosition = client.currentPosition;
        EventHandler.GetInstance().BoradCastMessageToClient(handler);
    }
    public void OnFire(MessageObject obj)
    {
        CSFire client = (CSFire)(obj.m_MessageBody);
        SCFire server = new SCFire();
        server.playerUid = client.playerUid;
        server.currentPosition = client.currentPosition;
        server.fireDirection = client.fireDirection;
        server.bulletName = client.bulletName;
        EventHandler.GetInstance().BoradCastMessageToClient(server);
    }
}
