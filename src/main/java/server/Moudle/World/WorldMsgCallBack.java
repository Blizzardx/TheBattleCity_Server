package server.Moudle.World;

import server.Message.MessageCallBack;
import server.Message.MessageObject;
import server.msg.auto.MessageIdConstants;

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
            case MessageIdConstants.CS_BattleLoadEnd:
                WorldLogic.GetInstance().OnBattleLoadEnd(obj);
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
