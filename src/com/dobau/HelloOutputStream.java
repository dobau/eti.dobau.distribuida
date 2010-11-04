package com.dobau;

import java.io.IOException;


public class HelloOutputStream {

	public static void main(String[] args) {

		String s = "Hello World\r\n";

		try {
			System.out.write(s.getBytes());
			System.out.flush();
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}

	}

}
