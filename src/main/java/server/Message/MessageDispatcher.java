package server.Message;

import org.apache.thrift.TBase;
import server.Handler.CustomServerMessageId;
import server.Handler.EventHandler;
import server.Handler.ThriftHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/11.
 */

public class MessageDispatcher
{
    private HashMap m_MessageListener;
    private HashMap m_RemovingMessageListener;
    private boolean m_bIsBusy;
    private int m_iBusyMessageId;

    private static MessageDispatcher m_Instance;
    public static MessageDispatcher GetInstance()
    {
        if(null == m_Instance)
        {
            m_Instance = new MessageDispatcher();
        }
        return m_Instance;
    }
    private MessageDispatcher()
    {
        m_MessageListener = new HashMap();
        m_RemovingMessageListener = new HashMap();
    }

    public void SendMessageToClient(TBase MessageBody,ArrayList<Integer> clientIdStore)
    {
        for(int i=0;i<clientIdStore.size();++i)
        {
            SendMessageToClient(MessageBody,clientIdStore.get(i));
        }
    }
    public void SendMessageToClient(TBase MessageBody,int clientId)
    {
        EventHandler.GetInstance().SendMessageToClient(clientId,MessageBody);
    }
    public void RegisterMessage(int messageId,MessageCallBack callBack)
    {
        //check message id
        if(!ThriftHelper.GetInstance().IsSupportMessage(messageId) && !CustomServerMessageId.IsSupportMessage(messageId))
        {
            System.out.println("Can't supprot message id " + messageId);
            return;
        }
        HashMap map = null;
        //check is busy
        if(m_bIsBusy && m_iBusyMessageId == messageId)
        {
            //add to removing store
            map = m_RemovingMessageListener;
        }
        else
        {
            map = m_MessageListener;
        }
        //add to listener list
        Object tmpList = map.get(messageId);
        ArrayList<MessageCallBack> list = null;

        if(tmpList != null)
        {
            list = (ArrayList<MessageCallBack>)(tmpList);
        }
        else
        {
            list = new ArrayList<MessageCallBack>();
            map.put(messageId,list);
        }
        boolean needAdd = true;
        for(int i=0;i<list.size();++i)
        {
            if(list.get(i) == callBack)
            {
                needAdd = false;
                break;
            }
        }
        if(needAdd)
        {
            list.add(callBack);
        }
    }
    public void BroadCastMessage(MessageObject msgObj)
    {
        m_bIsBusy = true;
        m_iBusyMessageId = msgObj.m_iMessageId;
        if(m_MessageListener.containsKey(msgObj.m_iMessageId))
        {
            ArrayList<MessageCallBack> list = (ArrayList<MessageCallBack>)(m_MessageListener.get(msgObj.m_iMessageId));
            for(int i=0;i<list.size();++i)
            {
                list.get(i).MessageHandler(msgObj);
            }
        }
        m_bIsBusy = false;
        HandlerRemove();
    }
    public void BroadCastMessage(int messageId,TBase messageBody,int clientId)
    {
        BroadCastMessage(new MessageObject(messageId,messageBody,clientId));
    }
    private void HandlerRemove()
    {
        if(m_RemovingMessageListener.containsKey(m_iBusyMessageId))
        {
            Iterator iter = m_RemovingMessageListener.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry) iter.next();
                Integer key = (Integer)(entry.getKey());
                ArrayList<Integer> val = (ArrayList<Integer>)(entry.getValue());

                if(m_MessageListener.containsKey(key))
                {
                    ArrayList<Integer> tmpList = (ArrayList<Integer>)(m_MessageListener.get(key));
                    for(int i=0;i<val.size();++i)
                    {
                        tmpList.remove(val.get(i));
                    }
                }
            }
        }
        m_RemovingMessageListener.clear();
    }
}
