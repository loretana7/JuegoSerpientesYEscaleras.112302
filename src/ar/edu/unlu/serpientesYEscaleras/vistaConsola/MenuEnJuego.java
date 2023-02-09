package ar.edu.unlu.serpientesYEscaleras.vistaConsola;

import java.util.Scanner;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;



public class MenuEnJuego extends MenuPrincipal {

	public MenuEnJuego(Controlador miControlador) {
		
	this.miControlador = miControlador;
	}
	
	@Override
	public void mostrarMenu() {
		String elija="";
		while ((elija != "0") && (elija != "1") && (elija != "2")&& (elija != "3") ) {
			do { //le agregue para ver si puede abandonar
		System.out.println("=============");
		System.out.println("El participante es: " + miControlador.getAliasEnJuego().getAlias());
		System.out.println("0 - Abandonar");
		System.out.println("1 - Tirar");
		System.out.println();
		System.out.println("elija su opcion => ");
		Scanner miScanner = new Scanner(System.in);
		 elija = miScanner.nextLine();
		System.out.println("opcion: [" + elija + "]");
		switch (elija) {
			case "0" :
				System.exit(0);
					//miControlador.finalizar_juego();
					break;
			case "1" : miControlador.tirar(); 
						break;
			
		}
			}while (elija !="0"); //probando 

			}
		}
	

 
}
