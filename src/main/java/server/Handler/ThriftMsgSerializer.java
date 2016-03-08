package server.Handler;

import java.io.UnsupportedEncodingException;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;

/**
 * thrift序列化工具
 * @author sunchong
 *
 */
public class ThriftMsgSerializer {

	/**
	 * This transport wraps that byte array
	 */
	private final ThriftMemoryBufferTransport transport_ = new ThriftMemoryBufferTransport(64);

	/**
	 * Internal protocol used for serializing objects.
	 */
	private TProtocol protocol_;

	/**
	 * Create a new TSerializer. It will use the TProtocol specified by the
	 * factory that is passed in.
	 * 
	 * @param protocolFactory
	 *            Factory to create a protocol
	 */
	public ThriftMsgSerializer(TProtocolFactory protocolFactory) {
		protocol_ = protocolFactory.getProtocol(transport_);
	}

	/**
	 * Serialize the Thrift object into a byte array. The process is simple,
	 * just clear the byte array output, write the object into it, and grab the
	 * raw bytes.
	 * 
	 * @param base
	 *            The object to serialize
	 * @return Serialized object in byte[] format
	 */
	public byte[] serialize(TBase base) throws TException {
		transport_.reset();
		base.write(protocol_);

		byte[] bytes = new byte[transport_.length()];
		transport_.read(bytes, 0, bytes.length);
		return bytes;
	}

	/**
	 * Serialize the Thrift object into a Java string, using a specified
	 * character set for encoding.
	 * 
	 * @param base
	 *            The object to serialize
	 * @param charset
	 *            Valid JVM charset
	 * @return Serialized object as a String
	 */
	public String toString(TBase base, String charset) throws TException {
		try {
			return new String(serialize(base), charset);
		} catch (UnsupportedEncodingException uex) {
			throw new TException("JVM DOES NOT SUPPORT ENCODING: " + charset);
		}
	}

	/**
	 * Serialize the Thrift object into a Java string, using the default JVM
	 * charset encoding.
	 * 
	 * @param base
	 *            The object to serialize
	 * @return Serialized object as a String
	 */
	public String toString(TBase base) throws TException {
		return new String(serialize(base));
	}
}
