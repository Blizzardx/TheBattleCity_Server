package server.Handler;

import org.apache.thrift.TBase;
import server.msg.auto.*;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/8.
 */
public class ThriftHelper
{
    private static ThriftHelper m_Instance = new ThriftHelper();
    private HashMap REQ_ID_MSG = new HashMap();
    private HashMap REQ_MSG_ID = new HashMap();

    public static ThriftHelper GetInstance()
    {
        return m_Instance;
    }
    private  ThriftHelper()
    {
        REQ_ID_MSG.put(MessageIdConstants.CS_PING, new CSPingMsg().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_PONG, new SCPongMsg().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_HANDLER, new CSHandler().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_HANDLER, new SCHandler().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_FIRE, new CSFire().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_FIRE, new SCFire().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_RoomList, new CSRoomList().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_RoomList, new SCRoomList().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_SearchRoom, new CSSearchRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_SearchRoom, new SCSearchRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_CreateRoom, new CSCreateRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_CreateRoom, new SCCreateRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_EnterRoom, new CSEnterRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_EnterRoom, new SCEnterRoom().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_SyncPlayerInfo, new SCSyncPlayerInfo().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_BattleLoadEnd, new CSBattleLoadEnd().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_BeginLoadBattle, new SCBeginLoadBattle().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_BattleBegin, new SCBattleBegin().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_BattleEnd, new SCBattleEnd().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_Hurt, new CSHurt().getClass());
        REQ_ID_MSG.put(MessageIdConstants.SC_Hurt, new SCHurt().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_BattleEnd, new CSBattleEnd().getClass());

        Iterator iter = REQ_ID_MSG.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();

            REQ_MSG_ID.put(val,key);
        }
    }

    //public interface
    public TBase GetMessageById(int messageId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!REQ_ID_MSG.containsKey(messageId))
        {
            return null;
        }

        Class classname = (Class)(REQ_ID_MSG.get(messageId));

        TBase instance = (TBase)(classname.newInstance());

        return instance;
    }
    public int GetIdbyMessage(TBase classtype)
    {
        Class key = classtype.getClass();

        if (!REQ_MSG_ID.containsKey(key))
        {
            return -1;
        }

        Integer id = (Integer)(REQ_MSG_ID.get(key));
        return id;
    }
    public boolean IsSupportMessage(int messageId)
    {
        if (!REQ_ID_MSG.containsKey(messageId))
        {
            return false;
        }
        return true;
    }
}
