package server.Moudle.World;

import server.Moudle.Room.RoomLogic;

import java.util.HashMap;

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
}
