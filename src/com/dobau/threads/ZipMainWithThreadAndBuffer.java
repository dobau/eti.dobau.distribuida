package com.dobau.threads;


public class ZipMainWithThreadAndBuffer {

	String fileNames[] = {
			"C:/Users/dobau/Downloads/DTLite4356-0091.exe",
			"C:/Users/dobau/Downloads/hamachi.msi",
			"C:/Users/dobau/Downloads/sp45216.exe",
			"C:/Users/dobau/Downloads/sp45501.exe",
			"C:/Users/dobau/Downloads/BF2_Patch_1.50.exe",
			"C:/Users/dobau/Downloads/bf2_patch_1.41.exe",
			"C:/Users/dobau/Downloads/BF1942_2.mdx",
			"C:/Users/dobau/Downloads/netbeans-6.9.1-ml-windows.exe",
			"C:/Users/dobau/Downloads/win32_11gR1_database_1013.zip"
	};

	public void run() {
		BufferFileNames buffer = new BufferFileNames();

		// Inicia threads
		for (int i = 0; i < BufferFileNames.SIZE; i++) {
			new Thread(new BufferZipThread(buffer)).start();
		}

		// Adiciona arquivos no buffer
		for (String fileName : fileNames) {
			buffer.push(fileName);
		}

//		Scanner scanner = new Scanner(System.in);
//		String fileName = "";
//		while (!"exit".equalsIgnoreCase(fileName)) {
//			fileName = scanner.nextLine();
//			buffer.push(fileName);
//		}
	}

	public static void main(String[] args) {
		new ZipMainWithThreadAndBuffer().run();
	}

}
