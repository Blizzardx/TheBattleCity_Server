package server.Handler;

import org.apache.thrift.TBase;
import server.msg.auto.CSHandler;
import server.msg.auto.CSPingMsg;
import server.msg.auto.CSPongMsg;
import server.msg.auto.MessageIdConstants;

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
        REQ_ID_MSG.put(MessageIdConstants.CS_PONG, new CSPongMsg().getClass());
        REQ_ID_MSG.put(MessageIdConstants.CS_HANDLER, new CSHandler().getClass());

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
}
