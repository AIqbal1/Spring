package com.test.socket.secure;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.springframework.stereotype.Component;

//@Component
public class WebSocketSslServer2 {

	@PostConstruct
    public void run() {
        // Configure the server.
		ClientBootstrap bootstrap = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        // Set up the event pipeline factory.
        bootstrap.setPipelineFactory(new WebSocketSslServerPipelineFactory2());

        // Bind and start to accept incoming connections.
        ChannelFuture future =  bootstrap.connect(new InetSocketAddress("172.23.224.138",4001));
        Channel channel;
		future.awaitUninterruptibly();
		if(future.isSuccess()){
			channel = future.getChannel();
			channel.setInterestOps(SocketChannel.OP_READ_WRITE);	
			System.out.println("Client connected to socket 222");
		}
        
        System.out.println("Client connected to socket");
    }
	
}
