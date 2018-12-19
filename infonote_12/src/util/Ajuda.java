package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ajuda {

	private String texto;

	public Ajuda(String nomeArquivo) {

		try {
			// Abre o arquivo
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
			// Vari�vel para armazenar as linhas de texto do arquivo
			String linha = "";
			do {
				// Faz a leitura da linha do arquivo
				linha = in.readLine();
				// Caso n�o tenha terminado as linhas vai armazenando
				if (linha != null) {
					texto += linha + "\n";
				}
			} while (linha != null);
		} catch (IOException ioe) {
			System.out.println(
					"Arquivo Ajuda.txt n�o encontrado. " + "Consulte o site http://www.infonote.net/ajuda.html ");
		}
	}

	public String getTexto() {
		return texto;
	}
}
