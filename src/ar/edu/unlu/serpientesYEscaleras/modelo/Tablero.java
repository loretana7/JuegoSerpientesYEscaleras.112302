package ar.edu.unlu.serpientesYEscaleras.modelo;

import java.io.Serializable;

public class Tablero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JuegoSerpientesEscaleras j;
	//private Casillero rutaC[] = new Casillero[101];/* uno mas */
	private int nuevaPosicion;
	private int volver;
	private int d = 0;
	private  int posicion ;
	private int salto;
	private TipoCasilla tipoCasilla;
	public Tablero() {
		super();
		
	/** for (int i = 1; i < 100; i++)
		rutaC[i] = new Casillero(i, i, TipoCasilla.VACIA);
		rutaC[100] = new Casillero(100, 100, TipoCasilla.FIN);
		rutaC[2] = new Casillero(2, 38, TipoCasilla.ESCALERA);
		rutaC[7] = new Casillero(7, 14, TipoCasilla.ESCALERA);
		rutaC[8] = new Casillero(8, 31, TipoCasilla.ESCALERA);
		rutaC[15] = new Casillero(15, 26, TipoCasilla.ESCALERA);
		rutaC[21] = new Casillero(21, 42, TipoCasilla.ESCALERA);
		rutaC[28] = new Casillero(28, 84, TipoCasilla.ESCALERA);
		rutaC[36] = new Casillero(36, 44, TipoCasilla.ESCALERA);
		rutaC[51] = new Casillero(51, 67, TipoCasilla.ESCALERA);
		rutaC[71] = new Casillero(71, 91, TipoCasilla.ESCALERA);
		rutaC[78] = new Casillero(78, 98, TipoCasilla.ESCALERA);
		rutaC[87] = new Casillero(87, 94, TipoCasilla.ESCALERA);
		///////////////////////////////////////////////////////
		rutaC[16] = new Casillero(16, 6, TipoCasilla.SERPIENTE);
		rutaC[46] = new Casillero(46, 25, TipoCasilla.SERPIENTE);
		rutaC[49] = new Casillero(49, 11, TipoCasilla.SERPIENTE);
		rutaC[62] = new Casillero(62, 19, TipoCasilla.SERPIENTE);
		rutaC[64] = new Casillero(64, 60, TipoCasilla.SERPIENTE);// faltaba

		rutaC[74] = new Casillero(74, 53, TipoCasilla.SERPIENTE);
		rutaC[89] = new Casillero(89, 68, TipoCasilla.SERPIENTE);
		rutaC[92] = new Casillero(92, 88, TipoCasilla.SERPIENTE);
		rutaC[95] = new Casillero(95, 75, TipoCasilla.SERPIENTE);
		rutaC[99] = new Casillero(99, 80, TipoCasilla.SERPIENTE);
		///////////////////////////////////////////////////////////
		//////////////// Probar poner un case aca

	 */
	}
	public void Casilla(int pos, int saltar, TipoCasilla tipoCasillas) {
		posicion = pos;
		salto = saltar;
		tipoCasilla = tipoCasillas;
	}
	public void controlarSalto(int nuevaPosicion) {
		
		switch (nuevaPosicion) {
		
		case 100:
			 Casilla(100, 100, TipoCasilla.FIN);
			break;	
		//Escaleras	
		case 2:
			Casilla(2, 38, TipoCasilla.ESCALERA);		
			break;
		case 7:
			Casilla(7, 14, TipoCasilla.ESCALERA);
			break;
		case 8: 
			Casilla(8, 31, TipoCasilla.ESCALERA);
			break;
		case 15:
			Casilla(15, 26, TipoCasilla.ESCALERA);
			break;
		case 21:
			Casilla(21, 42, TipoCasilla.ESCALERA);
			break;
		case 28:
			Casilla(28, 84, TipoCasilla.ESCALERA);
			break;
		case 36:
			Casilla(36, 44, TipoCasilla.ESCALERA);
			break;
		case 51:
			Casilla(51, 67, TipoCasilla.ESCALERA);
			break;
		case 71:
			Casilla(71, 91, TipoCasilla.ESCALERA);
			break;
		case 78:
			Casilla(78, 98, TipoCasilla.ESCALERA);
			break;
		case 87:
			Casilla(87, 94, TipoCasilla.ESCALERA);
			break;
		// Serpientes	
		case 16:
			Casilla(16, 6, TipoCasilla.SERPIENTE);
			break;
		case 46:
			Casilla(46, 25, TipoCasilla.SERPIENTE);		
			break;
		case 49:
			Casilla(49, 11, TipoCasilla.SERPIENTE);	
			break;
		case 62:
			Casilla(62, 19, TipoCasilla.SERPIENTE);
			break;
		case 64:
			Casilla(64, 60, TipoCasilla.SERPIENTE);
			break;
		case 74:
			Casilla(74, 53, TipoCasilla.SERPIENTE);
			break;
		case 89:
			Casilla(89, 68, TipoCasilla.SERPIENTE);
			break;
		case 92:
			Casilla(92, 88, TipoCasilla.SERPIENTE);
			break;
		case 95:
			Casilla(95, 75, TipoCasilla.SERPIENTE);
			break;
		case 99:
			Casilla(99, 80, TipoCasilla.SERPIENTE);
			break;
			// Vacias	
		default:
			Casilla(posicion, nuevaPosicion, TipoCasilla.VACIA);
			break;
		}	
	} 

	public int getNuevaPosicion() {
		return nuevaPosicion;
	}
	public void setNuevaPosicion(int nuevaPosicion) {
		this.nuevaPosicion = nuevaPosicion;
	}
	public int getSalto() {
		return salto;
	}
	public void setSalto(int salto) {
		this.salto = salto;
	}
	public int getNuevaPosicion(int c, int dado) {// c:posicion donde entaba,el dado va a avanzar la casilla
		nuevaPosicion = c + dado;
		posicion=c;
		  if (nuevaPosicion > 100) {
			 int n = nuevaPosicion - 100;// a ver a donde va
			 nuevaPosicion = 100 - n;
		  }
		controlarSalto( nuevaPosicion);
		  
		return salto;
	}
public int getPoscionDestino() {//voy para aca
		
		return salto;
	}
	public TipoCasilla  getTipo() {//voy para aca
		
		return tipoCasilla;
	}

	


}
