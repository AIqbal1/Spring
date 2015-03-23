package com.test.socket.secure;

public class SerialMessage {

	private final byte[] array;

	public SerialMessage(byte[] array) {
		this.array = array;
	}

	public byte[] getBytes() {
		return array;
	}

}
