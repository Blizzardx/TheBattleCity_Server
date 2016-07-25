package server.Moudle.World;

import server.Handler.CustomServerMessageId;
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
            case CustomServerMessageId.S_LOSE_CLIENT:
                WorldLogic.GetInstance().OnLoseClient(obj);
                break;
            case MessageIdConstants.CS_Hurt:
                WorldLogic.GetInstance().OnHurt(obj);
                break;
            case MessageIdConstants.CS_BattleEnd:
                WorldLogic.GetInstance().OnBattleEnd(obj);
                break;
            case MessageIdConstants.CS_ItemGenFundamental:
                WorldLogic.GetInstance().OnItemGenFundamental(obj);
                break;
            case MessageIdConstants.CS_UseItem:
                WorldLogic.GetInstance().OnUseItem(obj);
                break;
            case MessageIdConstants.CS_BattleLogicFrame:
                WorldLogic.GetInstance().OnBattleLogicCmd(obj);
                break;
        }
    }

}
