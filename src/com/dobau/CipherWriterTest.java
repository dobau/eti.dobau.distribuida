package com.dobau;

import java.io.IOException;
import java.io.OutputStreamWriter;

import junit.framework.TestCase;

public class CipherWriterTest extends TestCase {

	public static void main(String[] args) throws IOException {
		CipherWriter writer = new CipherWriter(new OutputStreamWriter(System.out));
		writer.write("abcdefghijklmnopqrstuvwxyz");
		writer.flush();
	}

}
