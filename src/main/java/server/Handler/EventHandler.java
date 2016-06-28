package server.Handler;

import org.apache.thrift.TBase;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import server.Message.MessageDispatcher;
import server.Message.MessageObject;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * Created by Administrator on 2016/3/8.
 */
public class EventHandler extends  SimpleChannelHandler
{
    private static EventHandler m_Instance;
    public static EventHandler GetInstance()
    {
        if(null == m_Instance)
        {
            m_Instance = new EventHandler();
        }
        return m_Instance;
    }
    private EventHandler()
    {
        m_ClientList = new HashMap();
    }
    private HashMap m_ClientList;
    public void SendMessageToClient(int clientId,TBase MessageBody)
    {
        if(m_ClientList.containsKey(clientId))
        {
            Channel incoming = (Channel)(m_ClientList.get(clientId));
            byte[] msgBody = EncodeMsg(MessageBody);
            ChannelBuffer buffer = ChannelBuffers.buffer(msgBody.length);
            buffer.clear();
            buffer.writeBytes(msgBody);
            incoming.write(buffer);
            System.out.println("send msg to cilent " + MessageBody.toString() + " client id " + incoming.getRemoteAddress());
        }
    }
    public void BoradCastMessageToClient(TBase MessageBody)
    {
        if(m_ClientList.isEmpty())
        {
            return;
        }

        byte[] msgBody = EncodeMsg(MessageBody);
        ChannelBuffer buffer = ChannelBuffers.buffer(msgBody.length);
        buffer.clear();
        buffer.writeBytes(msgBody);

        Iterator iter = m_ClientList.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Channel val = (Channel)(entry.getValue());
            val.write(buffer);
            System.out.println("send msg to cilent " + MessageBody.toString() + " client id " + val.getRemoteAddress());
        }
    }
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
    {
        Channel incoming = ctx.getChannel();

        m_ClientList.put(incoming.getId(),incoming);

        System.out.println("client connected " + incoming.getRemoteAddress());
    }
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
    {
        try
        {
            Channel incoming = ctx.getChannel();
            ChannelBuffer buf = (ChannelBuffer) e.getMessage();

            MessageObject message = DecodeMsg(buf);
            message.m_iClientId = incoming.getId();

            //broad cast message
            MessageDispatcher.GetInstance().AddToMessageQueue(message);
        }
        catch(Exception exp)
        {
            System.out.println("message error");
        }
    }
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception
    {
        Channel incoming = ctx.getChannel();

        if(m_ClientList.containsKey(incoming.getId()))
        {
            // do remove
            m_ClientList.remove(incoming.getId());

            //send msg to server
            MessageObject message = new MessageObject();
            message.m_iClientId = incoming.getId();
            message.m_iMessageId = CustomServerMessageId.S_LOSE_CLIENT;
            //broad cast message
            MessageDispatcher.GetInstance().AddToMessageQueue(message);
        }
        System.out.println("channelDisconnected " + " client id " + incoming.getRemoteAddress());
    }
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception
    {
        Channel incoming = ctx.getChannel();

        if(m_ClientList.containsKey(incoming.getId()))
        {
            // do remove
            m_ClientList.remove(incoming.getId());

            //send msg to server
            MessageObject message = new MessageObject();
            message.m_iClientId = incoming.getId();
            message.m_iMessageId = CustomServerMessageId.S_LOSE_CLIENT;

            //broad cast message
            MessageDispatcher.GetInstance().AddToMessageQueue(message);
        }
        System.out.println("channelClosed " + " client id " + incoming.getRemoteAddress());
    }
    private byte[] EncodeMsg(TBase message)
    {
        byte[] msgBody = ThriftSerialize.serialize(message);

        short headerLength = 0;

        byte[] bytes = new byte[4+4+2+headerLength+4+msgBody.length];


        // Wrap a byte array into a buffer
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        int index = 0;
        //get message id
        int messageId = ThriftHelper.GetInstance().GetIdbyMessage(message);
        if(messageId == -1)
        {
            return null;
        }
        buf.putInt(index,messageId);
        index += 4;

        //get pre fix
        index += 4;

        //get header length default = 0
        buf.putShort(index,headerLength);
        index += 2;

        //get header body default = 0
        index += headerLength;

        //get msg length
        buf.putInt(index,msgBody.length);
        index += 4;

        //get msg body
        for(int i=0;i<msgBody.length;++i)
        {
            buf.put(index,msgBody[i]);
            ++ index;
        }

        return bytes;
    }
    private MessageObject DecodeMsg(ChannelBuffer buf)
    {
        try
        {
            int index = 0;
            int messageId = buf.getInt(index);
            index += 4;

            //skip per
            index += 4;

            //header
            short headerLen = buf.getShort(index);
            index += 2;

            //read header body
            byte[] headerBody = new byte[headerLen];
            buf.getBytes(index,headerBody);
            index += headerLen;

            //read message body length
            int msgBodyLength = buf.getInt(index);
            index += 4;

            //read message body
            byte[] msgBody = new byte[msgBodyLength];
            buf.getBytes(index,msgBody);

            //decode message
            TBase message = ThriftHelper.GetInstance().GetMessageById(messageId);
            ThriftSerialize.deSerialize(message,msgBody);

            System.out.println("rec message body : " + message.toString());

            return new MessageObject(messageId,message,0);
        }
        catch(Exception exp)
        {
            System.out.println("message error");
            return null;
        }
    }
}
