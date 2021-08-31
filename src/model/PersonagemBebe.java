package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PersonagemBebe  {

	BufferedImage imagemBebe; 
	int posx;
	int posy;
	int largura;
	int altura;
	String tipoSanguineo;
	Rectangle rectangleBebe;
	
	public PersonagemBebe( String file, int posx, int posy, int largura, int altura, String tipoSanguineo) throws IOException {
		imagemBebe = ImageIO.read(new File(file));
		this.posx = posx;
		this.posy = posy;
		this.largura = largura;
		this.altura = altura;
		this.tipoSanguineo = tipoSanguineo;
		rectangleBebe = new Rectangle(posx-10, posy-10, largura+15, altura+15);
	}

	public BufferedImage getImagemBebe() {
		return imagemBebe;
	}

	public void setImagemBebe(BufferedImage imagemBebe) {
		this.imagemBebe = imagemBebe;
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

	public Rectangle getRectangleBebe() {
		return rectangleBebe;
	}

	public void setRectanglePais(Rectangle rectangleBebe) {
		this.rectangleBebe = rectangleBebe;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	
}
