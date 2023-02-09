package ar.edu.unlu.serpientesYEscaleras.vistaConsola;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;
import ar.edu.unlu.serpientesYEscaleras.controlador.IVistaSerpEscaleras;
import ar.edu.unlu.serpientesYEscaleras.modelo.IJugador;

import java.io.*;
import java.net.*;
import java.rmi.RemoteException;
import java.awt.color.*;
import java.awt.print.*;

public class VistaConsola implements IVistaSerpEscaleras {
	private MenuPrincipal miMenu;
	private Controlador controlador;
	//////////////////////////////////////////
	public VistaConsola() {//constructor de la clase
		
	}
	/////////////////////////////////////////
	
	public void agregarAlias() {
		Scanner miSc = new Scanner(System.in);
		System.out.println("(: escriba el nombre del participante  :)");
		String alias = miSc.nextLine();
		//tomamos de la pantalla el nombre de nuestro participante
		controlador.agregarAlias(alias);
		
	}
	
	public void comenzarJuego() {//llama para empezar a jugar
	controlador.comenzarJuego();
	}
	@Override
	public void mostrarEnJuego() {
		miMenu = new MenuEnJuego(controlador);
		miMenu.mostrarMenu();	
	}
	@Override
	public void mostrarAeteando() {
		miMenu = new MenuSeteando(controlador, this);
		miMenu.mostrarMenu();
		
	}
	@Override
	public void jugadorEnTurno() {
			System.out.println("el participante es uhhhhhhhhhhh : " + controlador.getAliasEnJuego().getAlias());
		
	}
	@Override
	public void mostrarDadoTirado() {

		System.out.println("Salio el dado: " + controlador.getDado());
	}
	@Override 
	public void mostrarUbicacion() {
		System.out.println("estaba en la posicion  :" + controlador.getAliasEnJuego().getUbicacionAnterior());
		System.out.println(" ahora Esta en la posicion : " + controlador.getAliasEnJuego().getUbicacion());
		
	}
	@Override
	public void setControlador(Controlador controlador) {
		// lore ahora si anda
		this.controlador = controlador;
		miMenu = new MenuSeteando(controlador, this);
	}
	@Override
	public void mostrarListaAlias() {//la lista de los jugadores
		miMenu.mostrarMenu();
	}

	@Override
	public void mostrarFinalizarP() {
		// TODO Auto-generated method stub
		System.out.println("no te muestro nada :-)");
		ArrayList<IJugador> j = controlador.getListaJugadores();
		for (IJugador jugador : j) {
			System.out.println("el jugador: " +  jugador.getAlias() + " quedo en el casillero " +  jugador.getUbicacion());
		}
	}
	public void ganoOtra() {
		System.out.println("Salio un seis:-) ganaste otra tirada ");	
	}
	public void listarJugadores() {
		// TODO Auto-generated method stub
		ArrayList<IJugador> j = controlador.getListaJugadores();
		for (IJugador jugador : j) {
			System.out.println("el jugador: " +  jugador.getAlias() + " esta en la ubicacion " +  jugador.getUbicacion());
		}
	}
	public void topGanadores() {
		System.out.println(" topGanadores");
		ArrayList<IJugador> j = controlador.getTopGanadores();
		 for (IJugador jugador : j) {
			System.out.println(jugador.getAlias()+"-");
		 }
	}
	public void mostrarSerpiente() {

	System.out.println("caiste en una serpiente, retrocedes a la posicion: "+ controlador.getAliasEnJuego().getUbicacion());
	}
	public void mostrarEscalera() {

		System.out.println("caiste en una escalera, avanzas a la posicion: "+ controlador.getAliasEnJuego().getUbicacion());
	
	}
	public void mostrarSePaso() {
		 System.out.println("se paso del fin retrocede a la cassilla numero " + ((-((controlador.getAliasEnJuego().getUbicacionAnterior() +controlador.getDado())-100))+100)  );
	}
	public void mostrarFinalizar() {
		miMenu = new MenuFinal(controlador,this);
		miMenu.mostrarMenu();
	}
public void ganador() {
	controlador.guardarGanador();
	System.out.println("el ganador essssssssssssssssssssss: ............" + controlador.getGanador());
}

@Override
public void mostrarSetando() {
	// TODO Auto-generated method stub
	
}
}

