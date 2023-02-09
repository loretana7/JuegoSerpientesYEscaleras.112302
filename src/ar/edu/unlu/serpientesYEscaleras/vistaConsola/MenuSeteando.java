package ar.edu.unlu.serpientesYEscaleras.vistaConsola;

import java.util.Scanner;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;


public class MenuSeteando extends MenuPrincipal {

	public MenuSeteando(Controlador miControlador, VistaConsola vista) {
		this.miControlador = miControlador;
		this.miVista = vista;
	}
	
	@Override
	public void mostrarMenu() {
		String eleccion="";
		do {

		System.out.println("serpientes_y_escaleras");
		System.out.println();
		System.out.println("0 - Salir");
		System.out.println("1 - Registrar jugador");
		System.out.println("2 - Listar jugadores");
		System.out.println("3 - Iniciar partida");
		System.out.println();
		System.out.println("elija su opcion => ");
		Scanner miScanner = new Scanner(System.in);
		 eleccion = miScanner.nextLine();
		System.out.println("que_desea_hacer: [" + eleccion + "]"); 
	 
		switch (eleccion) {
			case "0" :
					//miControlador.finalizar_juego();
					break;
			case "1" : miVista.agregarAlias(); 
						break;
		
			case "2" : miVista.listarJugadores();
						mostrarMenu();
						break;
			case "3" : miVista.comenzarJuego();
			           break;
			           default :
			        	   System.out.println("digite un numero entre o y 3");; 
						
		} 
		 
		}while (eleccion == "0") ; //fin del while
	System.out.println("fin ");
	}
}
