package com.dobau;

import java.io.IOException;

import junit.framework.TestCase;

public class InvertOutputStreamTest extends TestCase {

	public static void main(String[] args) {

		try {
			InvertOutputStream out = new InvertOutputStream(System.out);

			out.write("Rafael".getBytes());
			out.flush(); // leafaR
			System.out.println();
			out.write("Rafael".getBytes(), 0, 6);
			out.flush(); // leafaR
			System.out.println();
			out.write("Rafael".getBytes(), 3, 6);
			out.flush(); // lea
			System.out.println();
			out.write("Rafael".getBytes(), 0, 100);
			out.flush(); // leafaR
			System.out.println();
			out.write("Rafael".getBytes(), 3, 100);
			out.flush(); // lea
			System.out.println();
			out.write("Rafael".getBytes(), 1,4);
			out.flush(); // eafa
			System.out.println();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
