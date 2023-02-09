package ar.edu.unlu.serpientesYEscaleras.modelo;

import java.io.Serializable;
import java.util.Random;

public class Dado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4349182297074370963L;
	private int cara;
	private int cant_caras;//podria ponerlo como final
	private Random suerte = new Random();
	public Dado() {
		this(6);
	}
	
	public Dado(int cantidadDeCaras) {
		if (cantidadDeCaras > 1)
			this.cant_caras = cantidadDeCaras;
		else
			this.cant_caras = 6;
		tirar();
	}
	public int getCara() {
		return cara;
	}
	
	public void tirar() {//este para crear en numero de la tirada
		
		this.cara = suerte.nextInt(cant_caras)+1;
	}
	public String toString() {// a ver para que lo usamos
		return Integer.toString(this.cara);
	}
}
