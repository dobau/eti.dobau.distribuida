package com.dobau;

import java.io.IOException;

import junit.framework.TestCase;

public class InvertInputStreamTest extends TestCase {

	public static void main(String[] args) {

		try {
			InvertInputStream in = new InvertInputStream(System.in);

			byte texto[] = new byte[256];
			in.read(texto, 0, 6);
			System.out.println(new String(texto));
			in.read(texto, 6, 4);
			System.out.println(new String(texto));

//			BufferedInputStream input = new BufferedInputStream(System.in);
//			input.read(texto);
//			System.out.println(new String(texto));

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
