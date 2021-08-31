package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import controller.Controle;

public class Personagem extends Sprite{
	Rectangle rectangle;
	PersonagemPais casal;
	ArrayList<PersonagemBebe> bebes;
	PersonagemBebe temporario;
	int indexRemocao;
	int pontuacao;
	public String localBebe;
	
	public Personagem(String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		casal = new PersonagemPais("images/casal.png", 280, 580, 72, 75);
		localBebe = "images/bebe.png";
		
		bebes = new ArrayList<>();
		bebes.add(new PersonagemBebe(localBebe, 4, 10, 25, 35,"A+"));
		bebes.add(new PersonagemBebe(localBebe, 133, 10, 25, 35, "A-"));
		bebes.add(new PersonagemBebe(localBebe, 260, 10, 25, 35, "B+"));
		bebes.add(new PersonagemBebe(localBebe, 389, 10, 25, 35,"B-"));
		bebes.add(new PersonagemBebe(localBebe, 4, 170, 25, 35, "O+"));
		bebes.add(new PersonagemBebe(localBebe, 133, 170, 25, 35,"O-"));
		bebes.add(new PersonagemBebe(localBebe, 260, 170, 25, 35,"AB+"));
		bebes.add(new PersonagemBebe(localBebe, 389, 170, 25, 35,"AB-"));
		
		
		
	}
	
	public boolean colisao(ArrayList<Rectangle> tmp, int x,int y) {

		rectangle = new Rectangle(getPosX()+x, getPosY()+y, width-20, height-5);
		for(Rectangle r : tmp) {
				if(r.intersects(rectangle) || rectangle.intersects(casal.getRectanglePais())){
					return true;
				}
		}
		return false;
	}
	
	
	public boolean verificarBebe() {
		rectangle = new Rectangle(getPosX(), getPosY(), width-20, height-5);
			for(PersonagemBebe bebe : bebes) {
				if(bebe.rectangleBebe.intersects(rectangle)){
					indexRemocao = bebes.indexOf(bebe); 
					temporario = bebe;
					return true;
				}
	
		}
		return false;
	}
	
	public boolean verificarCasal() {
		rectangle = new Rectangle(getPosX(), getPosY(), width-20, height);
			if(rectangle.intersects(casal.getRectanglePais())) {
				return true;
			}
		return false;
	}
	
	@Override
	public void setPosX(int posX) {
		if(!colisao(Controle.colisao, posX-getPosX(), 0))
			super.setPosX(posX);

	}

	@Override
	public void setPosY(int posY) {
		if(!colisao(Controle.colisao, 0, posY-getPosY()))
			super.setPosY(posY);
	}

	public PersonagemPais getCasal() {
		return casal;
	}

	public ArrayList<PersonagemBebe> getBebes() {
		return bebes;
	}

	public PersonagemBebe getTemporario() {
		return temporario;
	}

	public void setTemporario(PersonagemBebe temporario) {
		this.temporario = temporario;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getIndexRemocao() {
		return indexRemocao;
	}

	public void setCasal(PersonagemPais casal) {
		this.casal = casal;
	}

	public void setBebes(ArrayList<PersonagemBebe> bebes) {
		this.bebes = bebes;
	}
	
}
