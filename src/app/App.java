package app;



import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Controle;
import model.Camada;
import model.Personagem;
import view.Mensagem;

public class App {
	public static void main(String[] args) {
		Camada camadaPiso = new Camada(32, 32, 32, 32, "images/componentesJogo.png", "piso.txt");
		Camada camadaColisao = new Camada(32, 32, 32, 32,"images/componentesJogo.png" , "colisao.txt");
		Camada camadaTopo = new Camada(32, 32, 32, 32,"images/componentesJogo.png" , "topo.txt");
		Personagem personagem = null;
		try {
			personagem = new Personagem("images/enfermeira_sprite.png", 0, 4, 4, 68, 72);
		} catch (IOException e) {
			Mensagem.mensagem("Imagem do personagem não encontrada!");
		}
		
		new Controle(camadaPiso, camadaColisao, camadaTopo, personagem);
		
	}

}
