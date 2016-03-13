package server.Moudle;

import server.Moudle.World.WorldHandler;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MoudleHandler
{
    WorldHandler m_Workdhandler = new WorldHandler();

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
        m_Workdhandler.RegisterEvent();
    }
}
