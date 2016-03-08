package server.Handler;

import org.apache.thrift.TBase;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by Administrator on 2016/3/8.
 */
public class EventHandler extends  SimpleChannelHandler
{
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
    {
        System.out.println("client connected");
    }
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
    {
        try
        {
            ChannelBuffer buf = (ChannelBuffer) e.getMessage();

            TBase message = EncodeMsg(buf);
        }
        catch(Exception exp)
        {
            System.out.println("message error");
        }
    }

    private void DecodeMsg(TBase message)
    {
        //get message id
        
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

            System.out.println("message id : " + messageId);
            System.out.println("message header length : " + headerLen);
            System.out.println("message body length : " + msgBodyLength);

            return message;
        }
        catch(Exception exp)
        {
            System.out.println("message error");
            return null;
        }
    }
}
