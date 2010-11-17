package com.dobau.threads;


public class BufferZipThread extends ZipThread implements Runnable {

	private BufferFileNames buffer;

	public BufferZipThread(BufferFileNames buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			setFileName(buffer.pull());
			super.run();
		}
	}

	public BufferFileNames getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferFileNames buffer) {
		this.buffer = buffer;
	}

}
