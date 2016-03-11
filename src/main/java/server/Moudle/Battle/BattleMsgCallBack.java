package server.Moudle.Battle;

import server.Handler.EventHandler;
import server.Handler.ThriftHelper;
import server.Message.MessageCallBack;
import server.Message.MessageObject;
import server.msg.auto.*;

/**
 * Created by Administrator on 2016/3/11.
 */
public class BattleMsgCallBack implements MessageCallBack
{
    public void MessageHandler(MessageObject obj)
    {
        switch(obj.m_iMessageId)
        {
            case MessageIdConstants.CS_PING:
                OnPing(obj);
                break;
            case MessageIdConstants.CS_FIRE:
                OnFire(obj);
                break;
            case MessageIdConstants.CS_HANDLER:
                OnHandler(obj);
                break;
        }
    }
    private void OnPing(MessageObject obj)
    {
        EventHandler.GetInstance().SendMessageToClient(obj.m_iClientId,new SCPongMsg());
    }
    private void OnHandler(MessageObject obj)
    {
        CSHandler client = (CSHandler)(obj.m_MessageBody);
        SCHandler handler = new SCHandler();
        handler.playerUid = client.playerUid;
        handler.moveDirection = client.moveDirection;
        handler.currentPosition = client.currentPosition;
        EventHandler.GetInstance().BoradCastMessageToClient(handler);
    }
    private void OnFire(MessageObject obj)
    {
        CSFire client = (CSFire)(obj.m_MessageBody);
        SCFire server = new SCFire();
        server.playerUid = client.playerUid;
        server.currentPosition = client.currentPosition;
        server.fireDirection = client.fireDirection;
        EventHandler.GetInstance().BoradCastMessageToClient(server);
    }
}
