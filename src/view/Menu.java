package view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {
	private JButton startButton, sairButton, somButton, instrucaoButton;
	private ImageIcon backIcon, startIcon, sairIcon, somIcon, instruIcon;
	private JLabel backJLabel;
	private Clip clip;
	
	
	public Menu() {
		
		setTitle("Menu");
		
		setSize(700,394);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setUndecorated(true);
		
		backIcon = new ImageIcon("images/combinacao.png");
		backJLabel = new JLabel(backIcon);
		backJLabel.setBounds(0,0,700,394);
		startIcon = new ImageIcon("images/start.png");
		startButton = new JButton(startIcon);
		sairIcon = new ImageIcon("images/sair.png");
		startButton.setBounds(300,90,100,40);
		sairButton = new JButton(sairIcon);
		sairButton.setBounds(300,140,100,40);
		somIcon = new ImageIcon("images/som.png");
		somButton  = new JButton(somIcon);
		somButton.setBounds(300,190,100,40);
		instruIcon = new ImageIcon("images/instrução.png");
		instrucaoButton = new JButton(instruIcon);
		instrucaoButton.setBounds(300,240,100, 40);
		

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.createImage("images/seringa.png");
		Point point = new Point(16, 16);
		String nameCursor = "Image Cursor";
		Cursor cursor = kit.createCustomCursor(image, point, nameCursor);
		setCursor(cursor);
		
		add(backJLabel);
		add(startButton);
		add(sairButton);
		add(somButton);
		add(instrucaoButton);
		add(backJLabel);
		
		setVisible(true);
		
	}
	
	public void ativarSom() {
		File file = new File("./"+"arquivos/abertura.wav");
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void desativarSom() {
		clip.stop();
	}
	

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public JButton getSomButton() {
		return somButton;
	}

	public JButton getInstrucaoButton() {
		return instrucaoButton;
	}

	
	
	

	
}
