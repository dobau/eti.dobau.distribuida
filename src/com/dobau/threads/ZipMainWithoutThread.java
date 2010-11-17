package com.dobau.threads;


public class ZipMainWithoutThread {

	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();

		new ZipThread("C:/Users/dobau/Downloads/bf2_patch_1.41.exe").run();
		new ZipThread("C:/Users/dobau/Downloads/hamachi.msi").run();
		new ZipThread("C:/Users/dobau/Downloads/sp45216.exe").run();
		new ZipThread("C:/Users/dobau/Downloads/sp45501.exe").run();

		long l2 = System.currentTimeMillis();
		System.out.println(String.format("%2d segundos", (l2 - l1) / 1000));
	}

}
