package server.Moudle;

import server.Moudle.Battle.BattleHandler;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MoudleHandler
{
    BattleHandler tmpHandler = new BattleHandler();
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
        tmpHandler.RegisterEvent();
    }
}
