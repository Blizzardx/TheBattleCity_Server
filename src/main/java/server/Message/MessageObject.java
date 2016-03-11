package server.Message;

import org.apache.thrift.TBase;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MessageObject
{
    public MessageObject(){}
    public MessageObject(int msgId,TBase msgBody,int clientId)
    {
        m_iMessageId = msgId;
        m_MessageBody = msgBody;
        m_iClientId = clientId;
    }
    public int m_iMessageId;
    public TBase m_MessageBody;
    public int m_iClientId;
}
