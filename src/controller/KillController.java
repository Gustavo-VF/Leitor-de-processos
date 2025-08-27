package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
public class KillController {
	
	
	public String texto(String txt) {
		String texto = JOptionPane.showInputDialog("digite o "+ txt + " do processo que deseja matar");
		return texto;
	}
	private String so() {
		String os = System.getProperty("os.name");

		return os;
	}

	public void listaProcessos() {
		String so = so();
		String comando = "";
		if (so.contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		} else if (so.contains("Linux")) {
			comando = ("ps -ef");
		} else {
			System.out.println("Sistema não suportado");

		}
		try {
			String[] procArr = comando.split(" ");
			Process proc = Runtime.getRuntime().exec(procArr);
			BufferedReader ler = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String linha;

			while ((linha = ler.readLine()) != null) {
				if (so.contains("Windows")) {
					linha = linha.trim();

					System.out.println(linha);

				} else {
					linha = linha.trim();

					System.out.println(linha);

				}

			}

		} catch (

		Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}

	}

	public void mataPid(String pid) {
		String so = so();
		String comando = "";
		if (so.contains("Windows")) {
			comando = "TASKKILL /PID " + pid;
		} else if (so.contains("Linux")) {
			comando = "kill -9 "+ pid;
		} else {
			System.out.println("Sistema não suportado");

		}
		
		String[] procarr = (comando.split(" "));
		try {
		Process proc = Runtime.getRuntime().exec(procarr);


		} catch (Exception e) {

		}
	}
	
	
	public void mataNome(String Nome) {
		String so = so();
		String comando = "";
		if (so.contains("Windows")) {
			comando = "TASKKILL /IM " + Nome;
		} else if (so.contains("Linux")) {
			comando = "pkill -f "+ Nome;
		} else {
			System.out.println("Sistema não suportado");

		}
		
		String[] procarr = (comando.split(" "));
		try {
		Process proc = Runtime.getRuntime().exec(procarr);


		} catch (Exception e) {

		}
	}
}
