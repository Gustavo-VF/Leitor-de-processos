package View;

import controller.KillController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String[] opcoes = { "listarProcessos", "Matar por PID", "matar por NOME", "finalizar" };

		int opc = JOptionPane.showOptionDialog(null, "escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		if (opc == 0 || opc == 1 || opc == 2) {
			KillController killcon = new KillController();
			if (opc == 0) {
				killcon.listaProcessos();
			} else if (opc == 1) {
				String pid = killcon.texto("PID");
				killcon.mataPid(pid);
			} else if (opc == 2) {
				String nome = killcon.texto("NOME");
				killcon.mataNome(nome);
			} else {
				System.out.println("Sistema finalizado");
			}

		}

	}
}