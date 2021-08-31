package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInstrucao extends JFrame {
	JButton voltarButton;
	JLabel instrJLabel;
	ImageIcon instrIcon, voltarIcon;
	
	public TelaInstrucao() {
		super("Instruções");
		
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,394);
		setLayout(null);
		setLocationRelativeTo(null);
		
		instrIcon = new ImageIcon("images/instruções.png");
		instrJLabel = new JLabel(instrIcon);
		instrJLabel.setBounds(0,0,700,394);
		voltarIcon = new ImageIcon("images/voltar.png");
		voltarButton = new JButton(voltarIcon);
		voltarButton.setBounds(290,300,100, 40);
		
		add(voltarButton);
		add(instrJLabel);
		setVisible(false);
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}

	
	
}
