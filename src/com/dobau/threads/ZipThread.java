package com.dobau.threads;

import java.io.IOException;

public class ZipThread implements Runnable {

	private String fileName;

	public ZipThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		CompactaArquivo zip = new CompactaArquivo(this.fileName);
		try {
			zip.compacta();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
