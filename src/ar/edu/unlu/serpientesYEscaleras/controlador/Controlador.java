package ar.edu.unlu.serpientesYEscaleras.controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.serpientesYEscaleras.modelo.EstadosModel;
import ar.edu.unlu.serpientesYEscaleras.modelo.IJugador;
import ar.edu.unlu.serpientesYEscaleras.modelo.JuegoSerpientesEscaleras;
import ar.edu.unlu.serpientesYEscaleras.vistaConsola.VistaConsola;
import ar.edu.unlu.serpientesYEscaleras.vistaGrafica.VistaGrafica;

public class Controlador implements Observer {
	private JuegoSerpientesEscaleras juego;
    private IVistaSerpEscaleras vistosa;//para usar la vista
    //--------------------------------------------------------------
   
	

	public Controlador() {
		
	}
	public Controlador(JuegoSerpientesEscaleras juego, IVistaSerpEscaleras vistosa) {
		  this.juego = juego; //parte donde se conectan el juego, la vista y el controlador
		  this.vistosa = vistosa;
		juego.addObserver(this); 
		vistosa.setControlador(this); //de ivista
	}

	//-------------------------------------------------------------
	public static void main(String[] args) {
		JuegoSerpientesEscaleras j = new JuegoSerpientesEscaleras();
	     IVistaSerpEscaleras vistosa  = new  VistaGrafica();
	   //IVistaSerpEscaleras vistosa = new VistaConsola();
	    Controlador c = new Controlador(j, vistosa);
		j.comenzar();
	}
	
	//------------------------------------------------------------
	public void setVista(VistaGrafica vista) {
		this.vistosa = vista;
	}
	public void update(Observable o, Object arg) {
		if (arg instanceof EstadosModel) {
			EstadosModel cambio = (EstadosModel) arg;
			switch (cambio) {
			case CAMBIO_ESTADO:
				JuegoSerpientesEscaleras.ESTADOS e = juego.getEstado();
				if (e == JuegoSerpientesEscaleras.ESTADOS.JUGANDO) {
					vistosa.mostrarEnJuego();
					vistosa.mostrarUbicacion();
				} else if (e == JuegoSerpientesEscaleras.ESTADOS.CONFIGURANDO) {
					vistosa.mostrarAeteando();
				} else if (e == JuegoSerpientesEscaleras.ESTADOS.FINALIZADO) {
					vistosa.mostrarFinalizar();//para mostrar como quedo el  juego
				}
				break;
			case CAMBIO_JUGADOR:
				vistosa.mostrarEnJuego();
				break;
			case CAMBIO_LISTA_JUGADORES:
				vistosa.mostrarListaAlias();//los jugadores
				break;		
			case DADO_TIRADO:
				vistosa.mostrarDadoTirado();
				break;
			case GANASTE_OTRA_TIRADA:
				vistosa.ganoOtra();
				vistosa.mostrarUbicacion();
				vistosa.mostrarEnJuego();
				break;
			case MOVIO_LUGAR:
				//vistosa.mostrarUbicacion();
				vistosa.mostrarUbicacion();
				break;
			case ES_SERPIENTE:
				vistosa.mostrarSerpiente();
				break;
			case ES_ESCALERA:
				vistosa.mostrarEscalera();
				break;
			case PASO_DEL_FIN:
				//vistosa.mostrarUbicacion();
				vistosa.mostrarSePaso();
				break;
			case MOSTRAR_GANADOR:
			
				vistosa.ganador();
			
			}
			
		}
	}
	public void reiniciarJuego() {//para usar los mismos jugadores desde la posicion 0
		juego.resetearJuego();;
		
	}
	public void tirar() {//tiro el dado
		juego.tirar();
		
	}
	public String getGanador() {
		/*return juego.getGanador();*/
		//juego.guardarGanador();
		return juego.getGanador().getAlias();
		
	}
	//este lo voy a poner a ver si piuedo guardar el ganador
	public void guardarGanador()
	{
		juego.guardarGanador();
		
	}
	//hasta aca el guardar ganador
	//este para recuperar la lista de ganadores para mostrar el top
	public ArrayList<IJugador> getTopGanadores() 
	{
		ArrayList<IJugador> top = new ArrayList<>();
		top = juego.getTopGanadores();
		return top;
	}
	//hasta aca la lista de top jugadores
	public void ganador() throws RemoteException { //toque aca veamos si me da el nombre
		juego.getGanador().getAlias();//para mostrar el ganador no nececito la excepcion
		juego.guardarGanador(); //para guardar, si nececito la excepcion
	}
	public IJugador getAliasEnJuego() {
		 return juego.getAliasEnJuego();
	}
	public void comenzarJuego() {//para empezar
		juego.comenzarJuego();
		
	}
	public void agregarAlias(String alias) {//para agregar jugador
       	juego.agregarAlias(alias);
		
	}

	public void mostrarUbicacion() {
		juego.getUbicacion();
	}

	
	public void mostrarUbicacionAnt() {
		juego.getUbicacionAnte();
	}
	

	public ArrayList<IJugador> getListaJugadores() {
		return juego.getListaJugadores();
	}
	public void finalizarJuego() {
		juego.finalizarJuego();
	}
	public int getDado() {
		return juego.getDado();
	}
	public String getAliasPrimer() {
		return juego.getAliasPrimero();
	}	 
	public ArrayList<IJugador> getListaGanadores() 
	{
		ArrayList<IJugador> resultado = new ArrayList<IJugador>();
		resultado = juego.getTopGanadores();
		return resultado;
	}
}
