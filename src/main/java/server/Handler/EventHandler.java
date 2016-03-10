package server.Handler;

import org.apache.thrift.TBase;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.*;

import java.nio.ByteBuffer;
import java.util.Vector;

/**
 * Created by Administrator on 2016/3/8.
 */
public class EventHandler extends  SimpleChannelHandler
{
    private Vector<Channel> m_ClientList = new Vector<Channel>();

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
    {
        boolean needAdd = true;
        Channel incoming = ctx.getChannel();
        for (Channel channel : m_ClientList)
        {
            if(channel.getRemoteAddress() == incoming.getRemoteAddress())
            {
                needAdd = false;
                break;
            }
        }
        if(needAdd)
        {
            m_ClientList.add(incoming);
        }
        System.out.println("client connected " + incoming.getRemoteAddress());
    }
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
    {
        try
        {
            ChannelBuffer buf = (ChannelBuffer) e.getMessage();

            TBase message = EncodeMsg(buf);

            //test code
           //byte[] writeBuf = DecodeMsg(message);
            //for (Channel channel : m_ClientList)
            //{
            //    channel.write(buf);
            //}
        }
        catch(Exception exp)
        {
            System.out.println("message error");
        }
    }
    private byte[] DecodeMsg(TBase message)
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
        buf.put(msgBody,0,msgBody.length);
        index += msgBody.length;

        return bytes;
    }
    private TBase EncodeMsg(ChannelBuffer buf)
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

            return message;
        }
        catch(Exception exp)
        {
            System.out.println("message error");
            return null;
        }
    }
}
