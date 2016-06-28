package server.Moudle;

import server.Moudle.World.WorldHandler;
import server.Moudle.World.WorldLogic;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MoudleHandler
{
    WorldHandler m_WorldHandler = new WorldHandler();

    private static MoudleHandler m_Instance;
    public static MoudleHandler GetInstance()
    {
        if(null == m_Instance)
        {
            m_Instance = new MoudleHandler();
        }
        return m_Instance;
    }
    private MoudleHandler()
    {

    }
    public void RegisterEvent()
    {
        m_WorldHandler.RegisterEvent();
    }

    public void Tick()
    {
        WorldLogic.GetInstance().Tick();
    }
}
