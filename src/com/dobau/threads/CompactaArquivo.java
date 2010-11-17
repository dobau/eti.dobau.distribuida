package com.dobau.threads;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactaArquivo {

	private String nomeArquivo;

	public CompactaArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void compacta() throws IOException {
		String nomeDestino = nomeArquivo + ".zip";
		byte[] buf = new byte[1024];
		FileInputStream in = new FileInputStream(nomeArquivo);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(nomeDestino));
		out.putNextEntry(new ZipEntry(nomeArquivo));
		int tamanho;
		while((tamanho = in.read(buf)) >0){
			out.write(buf, 0, tamanho);
		}
		out.closeEntry();
		in.close();
		out.close();
	}

	public static void main(String[] args) {
		CompactaArquivo compactador = new CompactaArquivo("c:/temp/Aldeota.pdf");
		try {
			compactador.compacta();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
