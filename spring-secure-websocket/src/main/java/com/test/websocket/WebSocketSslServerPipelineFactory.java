package com.test.websocket;

import javax.net.ssl.SSLEngine;
import org.jboss.netty.channel.ChannelPipeline;

import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.ssl.SslHandler;

public class WebSocketSslServerPipelineFactory  implements ChannelPipelineFactory {
	
    public ChannelPipeline getPipeline() throws Exception {
        // Create a default pipeline implementation.
        ChannelPipeline pipeline = Channels.pipeline();
//
        SSLEngine engine = WebSocketSslServerSslContext.getInstance().getServerContext().createSSLEngine();
        engine.setUseClientMode(false);    
        engine.beginHandshake();
        pipeline.addLast("ssl", new SslHandler(engine));        

        pipeline.addLast("decoder", new HttpRequestDecoder());
        pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
        pipeline.addLast("encoder", new HttpResponseEncoder());
        pipeline.addLast("handler", new WebSocketSslServerHandler());
        
//        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8585, Delimiters.lineDelimiter()));
//        pipeline.addLast("decoder", new StringDecoder());
//        pipeline.addLast("encoder", new StringEncoder());        
        
        return pipeline;
    }

}
