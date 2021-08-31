package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Camada;
import model.Personagem;
import model.PersonagemBebe;

public class Container extends JFrame{
	Camada camadaPiso, camadaColisao, camadaTopo;
	Personagem personagem;
	Painel painel;
	BufferedImage imagemHud;

	public Container(Personagem personagem, Camada camadaPiso, Camada camadaColisao, Camada camadaTopo) throws IOException {
		this.personagem = personagem;
		this.camadaPiso = camadaPiso;
		this.camadaColisao = camadaColisao;
		this.camadaTopo = camadaTopo;
		
		imagemHud = ImageIO.read(new File("images/hud.png"));
		
		setTitle("Jogo/Mari");
		setSize(1024,734);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setUndecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		painel = new Painel(personagem, camadaPiso, camadaColisao, camadaTopo);
		
		add(painel);
		
		setVisible(false);
	}


	public Painel getPainel() {
		return painel;
	}
	
	public class Painel extends JPanel {

		
		public Painel(Personagem personagem, Camada camadaPiso, Camada camadaColisao, Camada camadaTopo) {
			setLocation(0, 0);
			setSize(1024,734);
			
			setVisible(true);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(Color.red);
			g.drawImage(camadaPiso.camada, 0, 0, null);
			g.drawImage(camadaColisao.camada, 0, 0, null);
			g.drawImage(personagem.getCasal().getImagemPais(), personagem.getCasal().getPosx(), personagem.getCasal().getPosy(), null);
			for(PersonagemBebe bebe : personagem.getBebes()) {
				g.drawImage(bebe.getImagemBebe(), bebe.getPosx(), bebe.getPosy(), null);
				g.drawString(bebe.getTipoSanguineo(), bebe.getPosx(), bebe.getPosy()+60);
			}
			g.drawImage(personagem.getSprites()[personagem.getAparencia()], personagem.getPosX(), personagem.getPosY(), null);
			g.drawImage(camadaTopo.camada, 0, 0, null);
			g.drawImage(getImagemHud(), 192, 650, null);
			g.drawString(personagem.getCasal().getPrimeiro(),270 , 580);
			g.drawString(personagem.getCasal().getSegundo(),350 , 580);
			g.drawString(personagem.getPontuacao() +"", 275, 685);
		}

		
	}

	public BufferedImage getImagemHud() {
		return imagemHud;
	}
	
}
