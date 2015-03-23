package com.test.socket.secure;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;


public class SerialMessageDecoder extends FrameDecoder{
	
	private Set<Byte> startBytes;
	private Set<Byte> endBytes;
	
	public SerialMessageDecoder(Set<Byte> startBytes, Set<Byte> endBytes) {
		super();
		this.startBytes = startBytes;
		this.endBytes = endBytes;
	}
	
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
		List<Byte> bytesSoFar = (List<Byte>) ctx.getAttachment();
		if(bytesSoFar == null){
			while(buffer.readable()){
				Byte startByte = buffer.readByte();
				//throw away bytes until we get a start byte...
				if(startBytes.contains(startByte)){
					bytesSoFar = new LinkedList<Byte>();
					bytesSoFar.add(startByte);
					if(endBytes.contains(startByte)){
						return createMessage(bytesSoFar);
					}
					break;
				}
			}
		}
		if(bytesSoFar == null){
			return null;
		}
		while(buffer.readable()){
			Byte nextByte = buffer.readByte();
			bytesSoFar.add(nextByte);
			if(endBytes.contains(nextByte)){
				ctx.setAttachment(null);
				return createMessage(bytesSoFar);
			}
		}
		ctx.setAttachment(bytesSoFar);
		return null;
		
	}
	
	private SerialMessage createMessage(List<Byte> bytesSoFar) {
		byte[] array = new byte[bytesSoFar.size()];
		for(int i = 0; i<bytesSoFar.size(); i++){
			//unbox to primitive 
			array[i] = bytesSoFar.get(i);
		}
		return new SerialMessage(array);
	}	
	
}