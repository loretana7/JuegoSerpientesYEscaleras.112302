package ar.edu.unlu.serpientesYEscaleras.modelo;

public class Casillero {
	private  int posicion ;
	private int salto;
	private TipoCasilla tipoCasilla;

	public Casillero(int posicion, int salto, TipoCasilla tipoCasilla) {
		super();
		this.posicion = posicion;
		this.salto = salto;
		this.tipoCasilla = tipoCasilla;
	}
	

	public int getPoscionDestino() {//voy para aca
		
		return salto;
	}
	public TipoCasilla  getTipo() {//voy para aca
		
		return tipoCasilla;
	}
}
