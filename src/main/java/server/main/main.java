package server.main;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2016/3/8.
 */
public class main
{
    public static void main(String args[])
    {
        // Server服务启动器
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory()
        {
                //@Override
                public ChannelPipeline getPipeline() throws Exception
                {
                    return Channels.pipeline(new server.Handler.EventHandler());
                }
         });

        bootstrap.bind(new InetSocketAddress(8000));
    }
}
