package com.dobau;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CipherWriter extends Writer {

	private OutputStreamWriter out;

	public CipherWriter(OutputStreamWriter out) {
		this.out = out;
	}

	@Override
	public void close() throws IOException {
		out.close();
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void write(char[] b, int off, int len) throws IOException {
		int size = 0;

		if (len + off > b.length) {
			size = b.length;
		} else {
			size = len + off;
		}

		for (int i = off; i < size; i++) {
			byte ultimoChar = -1;
			byte primeiroChar = -1;

			if (b[i] >= 'A' && b[i] <= 'Z') {
				ultimoChar = (byte) 'Z';
				primeiroChar = (byte) 'A';
			} else if (b[i] >= 'a' && b[i] <= 'z') {
				ultimoChar = (byte) 'z';
				primeiroChar = (byte) 'a';
			}

			if (ultimoChar != -1 && primeiroChar != -1) {
				out.write((char)((b[i] - primeiroChar + 1)%(ultimoChar - primeiroChar + 1) + primeiroChar));
			} else {
				out.write(b[i]);
			}
		}
	}

}
