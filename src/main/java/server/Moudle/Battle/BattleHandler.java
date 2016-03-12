package server.Moudle.Battle;

import server.Message.MessageDispatcher;
import server.Moudle.LogicHander;
import server.msg.auto.MessageIdConstants;

/**
 * Created by Administrator on 2016/3/11.
 */
public class BattleHandler implements LogicHander
{
    private BattleMsgCallBack m_CallBack = new BattleMsgCallBack();
    public void RegisterEvent()
    {
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_FIRE,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_HANDLER,m_CallBack);
    }
}
