package server.Message;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MessageQueue
{
    private Queue<MessageObject> m_Queue = new LinkedBlockingQueue();

    public MessageObject Dequeue()
    {
        synchronized(m_Queue)
        {
            if(m_Queue.isEmpty())
            {
                return null;
            }
            return m_Queue.peek();
        }
    }
    public void Enqueue(MessageObject msgObj)
    {
        synchronized(m_Queue)
        {
            m_Queue.offer(msgObj);
        }
    }
}
