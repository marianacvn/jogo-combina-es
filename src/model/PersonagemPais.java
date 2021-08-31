package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class PersonagemPais  {

	BufferedImage imagemPais; 
	int posx;
	int posy;
	int largura;
	int altura;
	String primeiro;
	String segundo;
	ArrayList<String> listaSangues;
	Rectangle rectanglePais;
	ArrayList<PersonagemBebe> bebes;
	
	public PersonagemPais( String file, int posx, int posy, int largura, int altura) throws IOException {
		imagemPais = ImageIO.read(new File(file));
		this.posx = posx;
		this.posy = posy;
		this.largura = largura;
		this.altura = altura;
		rectanglePais = new Rectangle(posx, posy, largura, altura);
		bebes = new ArrayList<>();
		listaSangues = new ArrayList<>();
		inicializar();
		gerarTipoAleatorio();
	}
	
	public void gerarTipoAleatorio() {
		Random r = new Random();
		primeiro = listaSangues.get(r.nextInt(8));
		segundo = listaSangues.get(r.nextInt(8));
	}
	
	private void inicializar() {
		listaSangues.add("A+");
		listaSangues.add("A-");
		listaSangues.add("B+");
		listaSangues.add("B-");
		listaSangues.add("O+");
		listaSangues.add("O-");
		listaSangues.add("AB+");
		listaSangues.add("AB-");
	}
	
	

	public BufferedImage getImagemPais() {
		return imagemPais;
	}

	public void setImagemPais(BufferedImage imagemPais) {
		this.imagemPais = imagemPais;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Rectangle getRectanglePais() {
		return rectanglePais;
	}

	public void setRectanglePais(Rectangle rectanglePais) {
		this.rectanglePais = rectanglePais;
	}
	
	public ArrayList<PersonagemBebe> getBebes() {
		return bebes;
	}

	public void setBebes(ArrayList<PersonagemBebe> bebes) {
		this.bebes = bebes;
	}

	public String getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(String primeiro) {
		this.primeiro = primeiro;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public ArrayList<String> getListaSangues() {
		return listaSangues;
	}

	public void setListaSangues(ArrayList<String> listaSangues) {
		this.listaSangues = listaSangues;
	}

	
	
}
