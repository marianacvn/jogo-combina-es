package view;

import javax.swing.JOptionPane;

public class Mensagem {

	
	public static void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	
	public static int mensagemJogarNovamente(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, "", 0);
	}
}
