package server.Moudle.World;

import server.Handler.CustomServerMessageId;
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
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_CreateRoom,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_RoomList,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_SearchRoom,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_EnterRoom,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_BattleLoadEnd,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_FIRE,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(MessageIdConstants.CS_HANDLER,m_CallBack);
        MessageDispatcher.GetInstance().RegisterMessage(CustomServerMessageId.S_LOSE_CLIENT,m_CallBack);
    }
}
