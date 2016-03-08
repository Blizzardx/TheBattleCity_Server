package server.Handler;

import java.io.UnsupportedEncodingException;

import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.transport.TTransport;

/**
 * 可重用的buffer
 * @author sunchong
 *
 */
public class ThriftMemoryBufferTransport extends TTransport {
	 // The contents of the buffer
	  private TByteArrayOutputStream arr_;

	  // Position to read next byte from
	  private int pos_;
	  
	  public ThriftMemoryBufferTransport(int size) {
	    arr_ = new TByteArrayOutputStream(size);
	  }

	  @Override
	  public boolean isOpen() {
	    return true;
	  }

	  @Override
	  public void open() {
	    /* Do nothing */
	  }

	  @Override
	  public void close() {
	    /* Do nothing */
	  }

	  public void reset() {
		 arr_.reset();
		 pos_ = 0;
	  }
	  
	  @Override
	  public int read(byte[] buf, int off, int len) {
	    byte[] src = arr_.get();
	    int amtToRead = (len > arr_.len() - pos_ ? arr_.len() - pos_ : len);
	    if (amtToRead > 0) {
	      System.arraycopy(src, pos_, buf, off, amtToRead);
	      pos_ += amtToRead;
	    }
	    return amtToRead;
	  }

	  @Override
	  public void write(byte[] buf, int off, int len) {
	    arr_.write(buf, off, len);
	  }

	  /**
	   * Output the contents of the memory buffer as a String, using the supplied
	   * encoding
	   * @param enc  the encoding to use
	   * @return the contents of the memory buffer as a String
	   */
	  public String toString(String enc) throws UnsupportedEncodingException {
	    return arr_.toString(enc);
	  }

	  public String inspect() {
	    String buf = "";
	    byte[] bytes = arr_.toByteArray();
	    for (int i = 0; i < bytes.length; i++) {
	      buf += (pos_ == i ? "==>" : "" ) + Integer.toHexString(bytes[i] & 0xff) + " ";
	    }
	    return buf;
	  }

	  public int length() {
	    return arr_.size();
	  }

	  public byte[] getArray() {
	    return arr_.get();
	  }
	}
