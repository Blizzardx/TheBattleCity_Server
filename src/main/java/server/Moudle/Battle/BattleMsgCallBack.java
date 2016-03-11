package server.Moudle.Battle;

import server.Handler.EventHandler;
import server.Message.MessageCallBack;
import server.Message.MessageObject;
import server.msg.auto.CSPongMsg;

/**
 * Created by Administrator on 2016/3/11.
 */
public class BattleMsgCallBack implements MessageCallBack
{
    public void MessageHandler(MessageObject obj)
    {
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,new CSPongMsg());
    }
}
