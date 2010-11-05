package com.dobau;

import java.io.IOException;
import java.io.InputStream;

public class InvertInputStream extends InputStream {

	private InputStream in;

	public InvertInputStream(InputStream in) {
		this.in = in;
	}

	@Override
	public int read() throws IOException {
		return in.read();
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (b == null) {
		    throw new NullPointerException();
		} else if (off < 0 || len < 0 || len > b.length - off) {
		    throw new IndexOutOfBoundsException();
		} else if (len == 0) {
		    return 0;
		}

		int start = 0;

		if (len + off > b.length) {
			start = b.length - 1;
		} else {
			start = len + off - 1;
		}

		int count = 0;
		for (int i = start; i >= off; i--) {
			int c = read();

			if (c == -1) {
				break;
			}

			b[i] = (byte) c;
			count++;
		}

		return count;
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

}
