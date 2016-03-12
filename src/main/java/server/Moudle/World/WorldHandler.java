package server.Moudle.World;

import server.Message.MessageDispatcher;
import server.Moudle.LogicHander;
import server.msg.auto.MessageIdConstants;

/**
 * Created by Administrator on 2016/3/12.
 */
public class WorldHandler implements LogicHander
{
    private WorldMsgCallBack m_CallBack = new WorldMsgCallBack();

    public void RegisterEvent()
    {
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_PING,m_CallBack);
    }
}
