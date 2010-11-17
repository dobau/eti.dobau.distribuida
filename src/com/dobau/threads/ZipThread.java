package com.dobau.threads;

import java.io.IOException;

public class ZipThread implements Runnable {

	private static Integer COUNT = 0;
	private Integer num;

	private String fileName;

	public ZipThread() {
		this.num = COUNT++;
	}

	public ZipThread(String fileName) {
		this();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.printf("(%d) Compactando arquivo: %s\n", this.num, this.fileName);
		CompactaArquivo zip = new CompactaArquivo(this.fileName);
		try {
			zip.compacta();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
