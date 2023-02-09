package ar.edu.unlu.serpientesYEscaleras.controlador;

public interface IVistaSerpEscaleras {//esta sirve para comunicarse con el controlador

	void jugadorEnTurno();//el que esta jugando

	void mostrarDadoTirado();

	void mostrarUbicacion();

	void setControlador(Controlador c);

	void mostrarEnJuego();//muestra el  menu de cuando esta en juego

	void mostrarListaAlias();

	void mostrarAeteando();
	
	void ganoOtra();

	void mostrarFinalizarP();

	void mostrarSerpiente();
	
	void mostrarFinalizar() ;//a ver ahora
	
	void mostrarEscalera();

	void mostrarSePaso();
	
	void ganador();

	void mostrarSetando();

	
	
}
