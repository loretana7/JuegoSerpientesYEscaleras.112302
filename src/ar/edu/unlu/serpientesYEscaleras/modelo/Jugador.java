package ar.edu.unlu.serpientesYEscaleras.modelo;

import java.io.Serializable;

public class Jugador implements IJugador, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String alias;//id_jugador
	private int ubicacion;
	private int ubicacion_anterior;
	private int ganador;
	//    private int x;
	//	private int y;
	public int getUbicacionAnterior() {
		return ubicacion_anterior;
	}
	public void setUbicacionAnterior(int ubicacion_anterior) {
		this.ubicacion_anterior = ubicacion_anterior;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Jugador(String nombre) { //constructor
		this.alias = nombre;
	}
	public  int getUbicacion() {//donde estoy parado
		return  ubicacion;
	}
	public String getAlias() {
	return alias;	
	}
	public void setGanador(int gan) {
		// TODO Auto-generated method stub
   this.ganador = gan;
		
	
	}
	
	public int  getGanador() {//donde estoy parado
		return  ganador;
    }
	

}
