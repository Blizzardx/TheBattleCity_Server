package server.Handler;

import java.util.Arrays;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;

/**
 * 
 * thrift对象序列化工具
 * 
 */
public class ThriftSerialize {
	/**
	 * 将对象序列化成二进制
	 * 
	 * @param base
	 * @return
	 */
	public static byte[] serialize(TBase<?, ?> base) {
		if (base == null) {
			return null;
		}
		
		return serialize(base, null);
	}
	
	/**
	 * 将对象序列化成二进制
	 * 
	 * @param base
	 * @param serializer
	 * 
	 * @return
	 */
	public static byte[] serialize(TBase<?, ?> base, ThriftMsgSerializer serializer) {
		if (base == null) {
			return null;
		}
		
		try {
			if(serializer == null) {
				serializer = new ThriftMsgSerializer(new TCompactProtocol.Factory());
			}
			return serializer.serialize(base);
		} catch (TException e) {
			throw new RuntimeException("thrift serialize error. base=" + base);
		}
	}
	
	/**
	 * 从二进制数据反序列化成对象
	 * 
	 * @param base
	 * @param bytes
	 */
	public static void deSerialize(TBase<?, ?> base, byte[] bytes) {
		if (base == null || bytes == null) {
			return;
		}
		
		deSerialize(base, bytes, null);
	}

	/**
	 * 从二进制数据反序列化成对对象
	 * 
	 * @param base
	 * @param bytes
	 * @param deserializer
	 * 
	 */
	public static void deSerialize(TBase<?, ?> base, byte[] bytes, TDeserializer deserializer) {
		if (base == null || bytes == null) {
			return;
		}
		try {
			if(deserializer == null) {
				deserializer = new TDeserializer(new TCompactProtocol.Factory());
			}
			deserializer.deserialize(base, bytes);
		} catch (TException e) {
			throw new RuntimeException("thrift deSerialize error. base=" + base + " bytes=" + Arrays.toString(bytes), e);
		}
	}
}
