package com.my.app.socket.pool;

import java.nio.ByteBuffer;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

public class ByteBufferPoolFactory extends BasePooledObjectFactory<ByteBuffer> {

	@Override
	public ByteBuffer create() throws Exception {
		return null;
	}

	@Override
	public PooledObject<ByteBuffer> wrap(ByteBuffer arg0) {
		return null;
	}

}
