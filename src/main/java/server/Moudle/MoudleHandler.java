package server.Moudle;

import server.Moudle.Battle.BattleHandler;
import server.Moudle.World.WorldHandler;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MoudleHandler
{
    BattleHandler m_BattleHandler = new BattleHandler();
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
        m_BattleHandler.RegisterEvent();
    }
}
