package com.dobau.threads;


public class ZipMainWithThread {

	public static void main(String[] args) {
		Thread t[] = {
			new Thread(new ZipThread("C:/Users/dobau/Downloads/bf2_patch_1.41.exe")),
			new Thread(new ZipThread("C:/Users/dobau/Downloads/hamachi.msi")),
			new Thread(new ZipThread("C:/Users/dobau/Downloads/sp45216.exe")),
			new Thread(new ZipThread("C:/Users/dobau/Downloads/sp45501.exe"))
		};

		long l1 = System.currentTimeMillis();

		// inicia as threads
		for (Thread thread: t) {
			thread.start();
		}

		// wait MANUAL
		for (int i = 0; i < t.length; i++) {
			while(t[i].isAlive()){
			}
		}

		long l2 = System.currentTimeMillis();
		System.out.println(String.format("%2d segundos", (l2 - l1) / 1000));
	}

}
