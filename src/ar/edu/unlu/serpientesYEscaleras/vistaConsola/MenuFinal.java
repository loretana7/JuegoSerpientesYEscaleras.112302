package ar.edu.unlu.serpientesYEscaleras.vistaConsola;

import java.util.Scanner;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;

public class MenuFinal  extends MenuPrincipal{

	public  MenuFinal(Controlador miContolador, VistaConsola vista) {
		this.miControlador = miContolador;
		this.miVista = vista;
	}
	
	@Override
	public void mostrarMenu() {
		String eleccion="";
		while ((eleccion != "0") && (eleccion != "1") && (eleccion != "2") ) {
			System.out.println("elija una opcion entre 0 y 2"); 
		System.out.println("serpientes y escaleras");
		System.out.println("=============");
		System.out.println();
		System.out.println("Fin de Juego");
        //  if  (miControlador.get_Ganador() == null) {
		//System.out.println("El  jugador : " + miControlador.get_alias_en_juego().getAlias()+ "se retiro del juego");}
         if (miControlador.getGanador() != null) {
                 System.out.println(" el ganador es: "+ miControlador.getGanador() );
         }
		System.out.println("0 - Terminar el Juego");
		System.out.println("1 - Volver a Jugar");
		System.out.println("2 - mostrar topGanadores");
		System.out.println();
		System.out.println("Ingrese su opcion => ");
		 Scanner miScanner = new Scanner(System.in);
		String elije = miScanner.nextLine();
		System.out.println("opcion: [" + elije + "]");
		switch (elije) {
			case "0" :
					miControlador.finalizarJuego();
					break;
			case "1" : miControlador.reiniciarJuego(); 
						break;
			case "2" : miVista.topGanadores(); 
			break;
		}
	

      }
	}//fin del while

		
	}
