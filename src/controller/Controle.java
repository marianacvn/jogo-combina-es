package controller;

import view.Container;
import view.Mensagem;
import view.Menu;
import view.TelaInstrucao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.JOptionPane;


import model.Camada;
import model.Personagem;
import model.PersonagemBebe;
import model.TiposSanguineos;

public class Controle extends KeyAdapter implements ActionListener {
	
	Camada camadaPiso, camadaColisao, camadaTopo;
	Container container;
	Menu menu;
	TelaInstrucao instrucao;
	boolean ativado, demitida;
	boolean cima, baixo, direita, esquerda;
	int up, down, left, right;
	public static ArrayList<Rectangle> colisao;
	Personagem personagem;
	int contador = 0;
	ArrayList<String> respostas;

	public Controle(Camada camadaPiso, Camada camadaColisao, Camada camadaTopo, Personagem personagem) {
		super();
		this.camadaPiso = camadaPiso;
		this.camadaColisao = camadaColisao;
		this.camadaTopo = camadaTopo;
		this.personagem = personagem;
		
		menu = new Menu();
		
		ativado = true;
		menu.ativarSom();
		
		instrucao = new TelaInstrucao();
		
		menu.getStartButton().addActionListener(this);
		menu.getSairButton().addActionListener(this);
		menu.getSomButton().addActionListener(this);
		menu.getInstrucaoButton().addActionListener(this);
		
		instrucao.getVoltarButton().addActionListener(this);
		
		colisao = camadaColisao.montarColisao();
		
		try {
			container = new Container(personagem, camadaPiso, camadaColisao, camadaTopo);
		} catch (IOException e) {
			Mensagem.mensagem("Imagem n�o encontrada!");
		}
		
		container.addKeyListener(this);
		
		respostas =	TiposSanguineos.verificarCombinacao(personagem.getCasal().getPrimeiro(), personagem.getCasal().getSegundo());
		
		run();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getStartButton()) {
			menu.setVisible(false);
			container.setVisible(true);
		}
		if (e.getSource() == menu.getSairButton()) {
			System.exit(0);
		}
		if (e.getSource() == menu.getSomButton()) {
			if(ativado) {
				menu.desativarSom();
				ativado = false;
			} else {
				menu.ativarSom();
				ativado = true;
			}
		}
		if (e.getSource() == menu.getInstrucaoButton()) {
			menu.setVisible(false);
			instrucao.setVisible(true);
			
		}
		if (e.getSource() == instrucao.getVoltarButton()) {
			instrucao.setVisible(false);
			menu.setVisible(true);
		} 
		
	}
	
	public void montarMapa() {
		camadaPiso.montarMapa();
		camadaColisao.montarMapa();
		camadaTopo.montarMapa();
		
	}

	
	public void run() {
		while (true) {
			montarMapa();
			container.getPainel().repaint();
		
			try { 
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void reiniciaJogo() {
		personagem.setPosX(68);
		personagem.setPosY(72);
		personagem.setBebes(new ArrayList<PersonagemBebe>());
		try {
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 4, 10, 25, 35,"A+"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 133, 10, 25, 35, "A-"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 260, 10, 25, 35, "B+"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 389, 10, 25, 35,"B-"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 4, 170, 25, 35, "O+"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 133, 170, 25, 35,"O-"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 260, 170, 25, 35,"AB+"));
			personagem.getBebes().add(new PersonagemBebe(personagem.localBebe, 389, 170, 25, 35,"AB-"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personagem.getCasal().gerarTipoAleatorio();
		TiposSanguineos.setCombinacoes(new ArrayList<String>());
		respostas =	TiposSanguineos.verificarCombinacao(personagem.getCasal().getPrimeiro(), personagem.getCasal().getSegundo());
		demitida = false;
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			int op = Mensagem.mensagemJogarNovamente("Deseja encerrar o game?");
			if(op == 0) {
				System.exit(0);
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(personagem.verificarBebe()) {
				if(personagem.getTemporario() != null) {					
					personagem.getBebes().remove(personagem.getIndexRemocao());
					Mensagem.mensagem("Pegou o beb�!!");
				}
				
			}
			if(personagem.verificarCasal()) {
			
				if(personagem.getPontuacao() == 15) {
					int op = Mensagem.mensagemJogarNovamente("Parab�ns, voc� ganhou! Deseja jogar novamente, tentar a sorte?");
					if(op == 0) {
						reiniciaJogo();
						personagem.setPontuacao(0);
						contador = 0;
						return;
					} else {
						System.exit(0);
					}
				}
				
				if(contador == respostas.size()) {
					reiniciaJogo();
					contador = 0;
					return; 
				}
				for (String r : respostas) {
					if(r.equals(personagem.getTemporario().getTipoSanguineo())) {
						personagem.setPontuacao(personagem.getPontuacao()+1);
						contador++;
						demitida = false;
						int quant = (respostas.size()-contador);
						String mensagem = "";
						if(quant != 0) {
							mensagem = "B�be entregue, faltam " + (respostas.size()-contador);
						} else {
							mensagem = "Todos os beb�s foram entregues, aperte Enter para ir para outra combina��o";
						}
						Mensagem.mensagem(mensagem);
						return; 
					} else {
						demitida = true;
					}
				}
				if(demitida) {
					int op = Mensagem.mensagemJogarNovamente("Voc� foi demitida, deseja tentar novamente?");
					if(op == 0) {
						reiniciaJogo();
						personagem.setPontuacao(0);
					} else {
						System.exit(0);
					}
				}
			}
		}
	
		
		if (e.getKeyCode()==KeyEvent.VK_W)  cima = true;
		if (e.getKeyCode()==KeyEvent.VK_S) baixo = true;
		if (e.getKeyCode()==KeyEvent.VK_A) esquerda = true;
		if (e.getKeyCode()==KeyEvent.VK_D) direita = true;
		
		movimento();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_W)  cima = false;
		if (e.getKeyCode()==KeyEvent.VK_S) baixo = false;
		if (e.getKeyCode()==KeyEvent.VK_A) esquerda = false;
		if (e.getKeyCode()==KeyEvent.VK_D) direita = false;
	}
	
	public void movimento() {
		if (esquerda == true) {
			int xL = personagem.getPosX();
			int yL = personagem.getPosY();
				if(xL > 0 ) {
					personagem.setPosX(xL-2);
					personagem.setPosY(yL);
					switch(left) {
						case 0:
							personagem.setAparencia(1);
							break;
						case 1:
							personagem.setAparencia(5);
							break;
						case 2:
							personagem.setAparencia(9);
							break;
						case 3:
							personagem.setAparencia(13);
							break;
						
					}
					if(left == 3) {
						left = 0;
					} else {
						left++;
					}
				
				}
		}
		if (cima == true) {
			int xL = personagem.getPosX();
			int yL = personagem.getPosY();
				if (yL > 0) {
					personagem.setPosX(xL);
					personagem.setPosY(yL-2);
					switch(up) {
						case 0:
							personagem.setAparencia(3);
							break;
						case 1:
							personagem.setAparencia(7);
							break;
						case 2:
							personagem.setAparencia(11);
							break;
						case 3:
							personagem.setAparencia(15);
							break;
					}
					if(up == 3) {
						up = 0;
					} else {
						up++;
					}
				}
			
		}
		if (direita == true) {
			int xL = personagem.getPosX();
			int yL = personagem.getPosY();
				if (xL < 956) {
					personagem.setPosX(xL+2);
					personagem.setPosY(yL);
					switch(right) {
						case 0:
							personagem.setAparencia(2);
							break;
						case 1:
							personagem.setAparencia(6);
							break;
						case 2:
							personagem.setAparencia(10);
							break;
						case 3:
							personagem.setAparencia(14);
							break;
						
					}
					if(right == 3) {
						right = 0;
					} else {
						right++;
					}
				}
		}
		if (baixo == true) {
			int xL = personagem.getPosX();
			int yL = personagem.getPosY();
				if ( yL < 632 ) {
					personagem.setPosX(xL);
					personagem.setPosY(yL+2);
					switch(down) {
						case 0:
							personagem.setAparencia(0);
						case 1:
							personagem.setAparencia(4);
							break;
						case 2:
							personagem.setAparencia(8);
							break;
						case 3:
							personagem.setAparencia(12);
							break;
						
					}
					if(down == 3) {
						down = 0;
					} else {
						down++;
					}
				
				}
		}
	}
}
