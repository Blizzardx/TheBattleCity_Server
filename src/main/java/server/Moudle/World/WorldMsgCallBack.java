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
                WorldLogic.GetInstance().OnPing(obj);
                break;
            case MessageIdConstants.CS_RoomList:
                WorldLogic.GetInstance().OnRoomList(obj);
                break;
            case MessageIdConstants.CS_SearchRoom:
                WorldLogic.GetInstance().OnSearchRoom(obj);
                break;
            case MessageIdConstants.CS_CreateRoom:
                WorldLogic.GetInstance().OnCreateRoom(obj);
                break;
            case MessageIdConstants.CS_EnterRoom:
                WorldLogic.GetInstance().OnEnterRoom(obj);
                break;
            case MessageIdConstants.CS_Ready:
                WorldLogic.GetInstance().OnReady(obj);
                break;
            case MessageIdConstants.CS_FIRE:
                WorldLogic.GetInstance().OnFire(obj);
            break;
            case MessageIdConstants.CS_HANDLER:
                WorldLogic.GetInstance().OnHandler(obj);
                break;
        }
    }

}
