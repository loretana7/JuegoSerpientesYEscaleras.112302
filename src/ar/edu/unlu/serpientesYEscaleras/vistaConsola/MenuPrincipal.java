package ar.edu.unlu.serpientesYEscaleras.vistaConsola;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;

public abstract class MenuPrincipal {
	protected Controlador miControlador;
	protected VistaConsola miVista;
	public abstract void mostrarMenu();
}
