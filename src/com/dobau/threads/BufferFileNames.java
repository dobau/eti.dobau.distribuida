package com.dobau.threads;

import java.util.List;
import java.util.Vector;

public class BufferFileNames implements BufferFinito<String> {

	public static final Integer SIZE = 5;

	public Boolean isClose = Boolean.FALSE;

	private List<String> fileNames = new Vector<String>(SIZE, 0);

	public synchronized String pull() {
		while (isEmpty()) {
			try { wait();
			} catch (InterruptedException e) {}
		}

		String fileName = fileNames.remove(fileNames.size() - 1);
		System.out.printf("Arquivo saindo da fila: %s\n", fileName);
		notifyAll();
		return fileName;
	}

	public synchronized void push(String fileName) {
		while (isFull()) {
			try { wait();
			} catch (InterruptedException e) {}
		}

		System.out.printf("Arquivo adicionando na fila: %s\n", fileName);
		fileNames.add(fileName);
		notifyAll();
	}

	public synchronized Boolean isFull() {
		return fileNames.size() >= (SIZE - 1);
	}

	public synchronized Boolean isEmpty() {
		return fileNames.isEmpty();
	}

}
