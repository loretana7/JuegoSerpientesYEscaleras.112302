package ar.edu.unlu.serpientesYEscaleras.modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import ar.edu.unlu.serpientesYEscaleras.serializacion.AddableObjectOutputStream;
import ar.edu.unlu.serpientesYEscaleras.serializacion.Serializador;

public class JuegoSerpientesEscaleras  extends Observable  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum ESTADOS {CONFIGURANDO, JUGANDO, FINALIZADO}
	//public static final String ESTADOS = null;
    private TipoCasilla tipoCasilla;
    
		//--------------------------------------------------------
	private ArrayList<Jugador> jugadores; //son todos los que van a jugar
	private boolean jugando = true;//para saber si no termino
	private  int ganador = -1;
	private int aliasEnJuego;
    final int  fin = 100;
    private Dado tira; 
    private int anterior=0;
    private Tablero tablerito;//para llamar a las funciones de tablero
	private ESTADOS estado = ESTADOS.CONFIGURANDO;
     private  boolean participante ;
     private static Serializador serializador = new Serializador("topGanador.dat");
    
	//-----------------------------------------------
	public void comenzar() {
		participante = true;
		 tablerito = new Tablero();//creo el tablero
	     tira = new Dado();//creo el dado
         jugadores = new ArrayList<>();// creo la lista de los jugadores
	     aliasEnJuego = 0;
	     avisar(EstadosModel.CAMBIO_LISTA_JUGADORES);
	     avisar(EstadosModel.CAMBIO_ESTADO);
	}
	//--------------------------------------------------
	public void comenzarJuego() {
		for (int i=0 ;i < jugadores.size();i++) {
			jugadores.get(i).setUbicacion(aliasEnJuego);
		}
	    estado=ESTADOS.JUGANDO;
	    avisar(EstadosModel.CAMBIO_JUGADOR);
	    avisar(EstadosModel.CAMBIO_ESTADO);
	}
	public void resetearJuego() {//para jugar con los mismos jugadores los pongo en cero. 
		for (int i=0 ;i < jugadores.size();i++) {
			jugadores.get(i).setUbicacion(0);
			jugadores.get(i).setUbicacionAnterior(0);
		
		} 
	
		ganador = -1;
	    estado=ESTADOS.JUGANDO;
	    avisar(EstadosModel.CAMBIO_JUGADOR);
	    avisar(EstadosModel.CAMBIO_ESTADO);
	}
	
	//-----------------------------------------------
	public void finalizarJuego() {
		jugando = false;//para saber si estamos jugando
		estado = ESTADOS.FINALIZADO;
		avisar(EstadosModel.CAMBIO_ESTADO);
	}
	//------------------------------------------------
	public ArrayList<IJugador> getListaJugadores() {
		ArrayList<IJugador> j = new ArrayList<>();
		for (Jugador jj : jugadores) {
			j.add(jj);//hago una copia  de los jugadores.
		}
		return j;
	}
	//-------------------------------------------------
	public void agregarAlias(String alias) {//hago una nueva lista para los jugadores
		Jugador j = new Jugador(alias);
		jugadores.add(j);
		avisar(EstadosModel.CAMBIO_LISTA_JUGADORES);
	}
	//-------------------------------------------------
	public void tirar() {
		Boolean bandera = true;
		tira.tirar();
		int posAnt = jugadores.get(aliasEnJuego).getUbicacion();
		anterior = posAnt;
		jugadores.get(aliasEnJuego).setUbicacionAnterior(anterior);
		int dado = tira.getCara();
		avisar(EstadosModel.DADO_TIRADO);	    
           if (posAnt + dado > fin) { 
        	   bandera = false;
        	   avisar(EstadosModel.PASO_DEL_FIN);
        	       posicionar( posAnt, dado ); //seteo la posicion del jugador y pregunto tipo
		            
		            avisar(EstadosModel.MOVIO_LUGAR);
	                cambiarAlias();
	     }	
           else { /* aca deberia de ir un else*/
        	   if (bandera) {
        		   bandera=false;
        		   posicionar( posAnt, dado );//seteo la posicion del jugador y pregunto tipo
    		     if ((tira.getCara() == 6) && (posAnt + dado != fin)) {
    		    	 avisar(EstadosModel.MOVIO_LUGAR);
    		    	 avisar(EstadosModel.GANASTE_OTRA_TIRADA); 
			        
	    	    } else { 
		               avisar(EstadosModel.MOVIO_LUGAR); //agregue este ahora 17
	                   cambiarAlias();
	    	        }
        	   }
           } if (bandera) {
		    int   c= tablerito.getNuevaPosicion(jugadores.get(aliasEnJuego).getUbicacion(), tira.getCara() );
		    //Observo que aca llamaria al case 
		       if (c== fin) {
		    	   hayGanador();
		    	 
	            	 estado= ESTADOS.FINALIZADO;
	            	 avisar(EstadosModel.CAMBIO_ESTADO);
	            	 avisar(EstadosModel.MOSTRAR_GANADOR);
				  
        		   }
           }
	}
	 public void posicionar(int posAnt,int dado ) { //pregunto para posicionar x e y y preguntar si cayo en algo nuevo
		 jugadores.get(aliasEnJuego).setUbicacion(tablerito.getNuevaPosicion(posAnt, dado));
  
	       tipoCasilla =  tablerito.getTipo(); 
         if (tipoCasilla == tipoCasilla.SERPIENTE) {
      	   avisar(EstadosModel.ES_SERPIENTE);
               } 
          if (tipoCasilla == tipoCasilla.ESCALERA) {
          avisar(EstadosModel.ES_ESCALERA);
               } 
	 }
	/*private void notificarObservadores(EstadosModel movioLugar) {
		// TODO Auto-generated method stub
		
	}*/
	private boolean hayGanador() {
		ganador = -1;

		// Si llego al final
	
		for (int i = 0; i < jugadores.size(); i ++) {
			if (jugadores.get(i).getUbicacion() == fin) {
				jugadores.get(aliasEnJuego).setGanador(i); //aca seteo el ganador
				ganador = i;	
			}
			/////////////
		}
	
		// Si el ganador fue seteado a un nro mayor a 0, hay ganador
		return (ganador >= 0);
	}
	//------------------------------------------------
	private void cambiarAlias() {//cambio el jugador
		if (hayGanador()) {
			
			estado = ESTADOS.FINALIZADO;
			avisar(EstadosModel.MOSTRAR_GANADOR);
			avisar(EstadosModel.CAMBIO_ESTADO);
		}
		aliasEnJuego ++;
		if (aliasEnJuego == jugadores.size()) {
			aliasEnJuego = 0;
		}
		if (estado != ESTADOS.FINALIZADO) {
			avisar(EstadosModel.CAMBIO_JUGADOR);
			
		}
	}
	
	public int getDado() {//esto hace el cubilette
	
		return  tira.getCara();
	}

	public IJugador getGanador(){//aca asigno el ganador//recordar hacer persistir a los ganadores:-)
		
			return jugadores.get(ganador);
	
	}
	public IJugador getAliasEnJuego() {
		return jugadores.get(aliasEnJuego); 		
	}
	
	//--------------------------------------------------------
	private void avisar(EstadosModel cambio) {//este para comunicarse con el enumerado
		setChanged();
		notifyObservers(cambio);
	}
	public int getUbicacion() {
		return jugadores.get(aliasEnJuego).getUbicacion();
	}
     public int getUbicacionAnte() {
	 return jugadores.get(aliasEnJuego).getUbicacionAnterior();
	}
 
	public ESTADOS getEstado() {
		return estado;
	}
	public String getAliasPrimero() {
		return jugadores.get(0).getAlias();
	}
	public void guardarPartida() {
		
		File partida = new File("partida.dat");
		if (participante) {
		if (!(partida.exists()))//si no existe es porq escribire la primer partida
		{
			String archi = "partida.dat";
			Serializador serializador = new Serializador(archi) ;
			serializador.writeOneObject(jugadores.get(0));
		}	else//sino agrego al final
		{
			String archi = "partida.dat";
			Serializador serializador = new Serializador(archi);
			serializador.addOneObject(jugadores.get(ganador));
	}
	}
	} //aca para la partida
	/**public void guardarGanador()
	{
		File ganadores = new File("topPartida.dat");
		if (!(ganadores.exists()))// si no existe el archivo escribo el primer objeto
		{
			String archi = "topGanadores.dat";
			try {
				AddableObjectOutputStream  oos = new AddableObjectOutputStream(new FileOutputStream(archi,false));
				oos.writeObject(jugadores.get(0).getAlias());//el unico jugador que queda es el ganador del juego.
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else//sino agrego al final
		{
			String archi = "topPartida.dat";
			try {
				AddableObjectOutputStream  oos = new AddableObjectOutputStream(new FileOutputStream(archi,true));
				oos.writeObject(jugadores.get(0).getAlias());
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}*/
	
	public void guardarGanador() {
		File ganadores = new File("topGanador.dat");
		String archi = "topGanador.dat";
		 Serializador serializador = new Serializador(archi);
		if (!(ganadores.exists())) {
		
			 serializador.writeOneObject(jugadores.get(ganador));
		} else {
			 serializador.addOneObject(jugadores.get(ganador));
		}
	}

	//probare con este para recuperar los datos como hizo el profe
     public ArrayList<IJugador> getTopGanadores() {
	
		Object[] top = serializador.readObjects();
		 ArrayList<IJugador> topJugador = new ArrayList<>(); //para recuperar el top jugador
		for(int i = 0; i < top.length; i ++) {
			topJugador.add((IJugador) top[i]);
		
		}
		return topJugador;
	}
   
}
