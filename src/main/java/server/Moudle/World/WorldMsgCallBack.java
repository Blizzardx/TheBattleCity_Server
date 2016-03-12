package server.Moudle.World;

import server.Handler.EventHandler;
import server.Message.MessageCallBack;
import server.Message.MessageObject;
import server.msg.auto.MessageIdConstants;
import server.msg.auto.SCPongMsg;

/**
 * Created by Administrator on 2016/3/12.
 */
public class WorldMsgCallBack implements MessageCallBack
{
    public void MessageHandler(MessageObject obj)
    {
        switch(obj.m_iMessageId)
        {
            case MessageIdConstants.CS_PING:
                OnPing(obj);
                break;
        }
    }
    private void OnPing(MessageObject obj)
    {
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,new SCPongMsg());
    }
}
