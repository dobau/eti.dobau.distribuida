package com.dobau;

import java.io.IOException;
import java.io.OutputStream;

public class InvertOutputStream extends OutputStream {

	private OutputStream out;

	public InvertOutputStream(OutputStream out) {
		this.out = out;
	}

	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		int start = 0;

		if (len + off > b.length) {
			start = b.length - 1;
		} else {
			start = len + off - 1;
		}

		for (int i = start; i >= off; i--) {
			write(b[i]);
		}
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void close() throws IOException {
		out.close();
	}

}
