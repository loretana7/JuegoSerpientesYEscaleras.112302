package ar.edu.unlu.serpientesYEscaleras.vistaGrafica;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import ar.edu.unlu.serpientesYEscaleras.controlador.Controlador;
import ar.edu.unlu.serpientesYEscaleras.controlador.IVistaSerpEscaleras;
import ar.edu.unlu.serpientesYEscaleras.modelo.IJugador;

import java.awt.Color;
import javax.swing.JList;

public class VistaGrafica implements IVistaSerpEscaleras {
	private JFrame frame;
	private Controlador controlador;
	private CardLayout cardLayout;
	private final String VComienzo = "VComienzo";
	private final String VJuego = "VJuego";
	private final String VFin = "VFin";
	private JTextField textField_1;
	private JTextField txtnombre;
	// private bldado; lblgano
	private JLabel lblpos_ac;
	private JLabel llblpos;
	private JLabel lblGan;
	private JLabel lblJugadorEnTurno;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JLabel lblgano;
	private JLabel lblDado;
	private JTextField txtdevol;
	
	public VistaGrafica() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setBounds(100, 100, 1400, 900);
		this.frame.setLocationRelativeTo(null);
		cardLayout = new CardLayout();
		Container contentPane = this.frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.add(VComienzo(), VComienzo);
		contentPane.add(VJuego(), VJuego);
		contentPane.add(VFin(), VFin);
	}

	@Override
	public void setControlador(Controlador c) {

		this.controlador = c;
	}

	
	public void comenzar() {
		mostrarAeteando();
	}

	private JPanel VComienzo() {
		JPanel PComienzo = new JPanel();
		frame.getContentPane().add(PComienzo, "name_2844592874195");
		PComienzo.setLayout(null);

		txtnombre = new JTextField();
		txtnombre.setBounds(939, 64, 241, 33);
		PComienzo.add(txtnombre);
		txtnombre.setColumns(10);

		txtdevol = new JTextField();
		txtdevol.setBounds(950, 176, 230, 95);
		PComienzo.add(txtdevol);
		txtdevol.setColumns(10);
		JButton btnComenzar = new JButton("comenzar"); // para empezar el juego
		btnComenzar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.comenzarJuego();
			}
		});
		btnComenzar.setBounds(895, 301, 256, 76);
		btnComenzar.setVisible(false);
		PComienzo.add(btnComenzar);
		JButton btncargar = new JButton("Nuevo_Jugador");
		btncargar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		btncargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.agregarAlias(txtnombre.getText());
				txtnombre.setText("");
				btnComenzar.setVisible(true);
			}
		});
		btncargar.setBounds(949, 113, 230, 52);
		PComienzo.add(btncargar);

		JButton btnsalir = new JButton("");// para salir del juego
		btnsalir.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/BotonSalir2.png")));
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////// para salir del juego
				System.exit(0);
			}
		});
		btnsalir.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		btnsalir.setBounds(921, 488, 119, 104);
		PComienzo.add(btnsalir);

		JLabel lblcartel = new JLabel("New label");
		lblcartel.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/cartel.png")));
		lblcartel.setBounds(93, 14, 393, 136);
		PComienzo.add(lblcartel);

		JLabel lblNewLabel_2 = new JLabel("Los Jugadores listados son:");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(660, 180, 282, 45);
		PComienzo.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ingrese_Nombre :-)");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(681, 38, 250, 76);
		PComienzo.add(lblNewLabel_3);

		JLabel lblprimer = new JLabel("New label");
		lblprimer.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/dos.png")));
		lblprimer.setBounds(30, 155, 512, 512);
		PComienzo.add(lblprimer);
		this.frame.setVisible(true);
		return PComienzo;
	}

	private JPanel VJuego() { // eh creado los mas lindos paneles de la historia
		JPanel PJuego = new JPanel();
		frame.getContentPane().add(PJuego, "name_2883192034414");
		PJuego.setLayout(null);
		lblJugador1 = new JLabel("");
		lblJugador1.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/patita1.jpg")));
		lblJugador1.setBounds(10, 648, 67, 64);
		PJuego.add(lblJugador1);

		lblGan = new JLabel("hola lore");
		lblGan.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblGan.setBounds(820, 43, 395, 49);
		PJuego.add(lblGan);

		lblJugador2 = new JLabel("");
		lblJugador2.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/patita2.jpg")));
		lblJugador2.setBounds(0, 586, 67, 64);
		PJuego.add(lblJugador2);
		lblDado = new JLabel("");
		lblDado.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/dado_1.png")));
		lblDado.setBounds(731, 247, 163, 141);
		PJuego.add(lblDado);
		JButton Tirar = new JButton("Tirar");
		Tirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGan.setText(" :) ");
				 
				controlador.tirar();

			}
		});

		Tirar.setBounds(879, 114, 227, 103);
		PJuego.add(Tirar);

		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/BotonSalir2.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // ver si lo sierra tambien para
				// dispose(); para cerrar una sola ventana
			}
		});
		btnSalir.setBounds(1089, 471, 126, 103);
		PJuego.add(btnSalir);

		llblpos = new JLabel("");
		llblpos.setBounds(904, 247, 333, 122);
		PJuego.add(llblpos);

		lblpos_ac = new JLabel("");
		lblpos_ac.setBounds(865, 366, 409, 103);
		PJuego.add(lblpos_ac);

		JLabel lbltablero = new JLabel("New label");
		lbltablero.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/Tablero - copia.png")));
		lbltablero.setBounds(0, -155, 1300, 950);
		PJuego.add(lbltablero);

		lblJugadorEnTurno = new JLabel("juega: ");
		lblJugadorEnTurno.setForeground(Color.PINK);
		lblJugadorEnTurno.setBounds(820, 550, 250, 64);
		PJuego.add(lblJugadorEnTurno);
		this.frame.setVisible(true);
		return PJuego;
	}

	@Override
	public void mostrarAeteando() { // panel inscripcion
		cardLayout.show(this.frame.getContentPane(), VComienzo);

	}

	private JPanel VFin() {
		JPanel Pfin = new JPanel();
		frame.getContentPane().add(Pfin, "name_4095538149716");
		Pfin.setLayout(null);
		JButton btnsalir_jf = new JButton("");
		btnsalir_jf.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/BotonSalir2.png")));
		btnsalir_jf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnsalir_jf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnsalir_jf.setBounds(1266, 10, 110, 107);
		Pfin.add(btnsalir_jf);
		
		JButton btnVolveajugar = new JButton("Volver_a_Jugar");
		btnVolveajugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.reiniciarJuego();
			}
		});
		btnVolveajugar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnVolveajugar.setBounds(1086, 556, 290, 84);
		Pfin.add(btnVolveajugar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VistaGrafica.class.getResource("/galeria/primer.png")));
		lblNewLabel.setBounds(288, 24, 675, 689);
		Pfin.add(lblNewLabel);
		
	     lblgano = new JLabel("");
		lblgano.setBounds(997, 125, 233, 63);
		Pfin.add(lblgano);

		
		JList LTopGanadores = new JList();
		LTopGanadores.setBounds(1039, 275, 195, 222);
		Pfin.add(LTopGanadores);
		
		JButton btnNewButton = new JButton("Mostrar lista ganadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTopGanadores( LTopGanadores);
			}
		});
		btnNewButton.setBounds(1010, 200, 186, 65);
		Pfin.add(btnNewButton);
		
		
		this.frame.setVisible(true);
		return Pfin;
	}

	@Override
	public void jugadorEnTurno() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarDadoTirado() {

	}

	@Override
	public void mostrarUbicacion() {
		int casillero = controlador.getAliasEnJuego().getUbicacion();
		int posX = getPosX(casillero);
		int posY = getPosY(casillero);

		if (controlador.getAliasPrimer() == controlador.getAliasEnJuego().getAlias()) {
			lblJugador1.setBounds(posX, posY, 67, 64);
			llblpos.setForeground(Color.red);
			llblpos.setText(" Participante:" + controlador.getAliasEnJuego().getAlias());
			lblpos_ac.setForeground(Color.red);
			lblpos_ac.setText(" Estabas en:" + controlador.getAliasEnJuego().getUbicacionAnterior()
					+ " ahora estas en: " + controlador.getAliasEnJuego().getUbicacion());

		} else {
			llblpos.setForeground(Color.BLUE);
			llblpos.setText(" Participante:" + controlador.getAliasEnJuego().getAlias());
			lblJugador2.setBounds(posX, posY, 67, 64);
			lblpos_ac.setForeground(Color.BLUE);
			lblpos_ac.setText(" Estabas en:" + controlador.getAliasEnJuego().getUbicacionAnterior()
					+ " ahora estas en: " + controlador.getAliasEnJuego().getUbicacion());

		}
		
		;
		
		int cara = controlador.getDado(); // cambio para ver la imagen del dado que salio
		String imagenDado = " ";
		switch (cara) {
		case 1:
			imagenDado = "/galeria/dado_1.png";
			break;
		case 2:
			imagenDado = "/galeria/dado_2.png";
			break;
		case 3:
			imagenDado = "/galeria/dado_3.png";
			break;
		case 4:
			imagenDado = "/galeria/dado_4.png";
			break;
		case 5:
			imagenDado = "/galeria/dado_5.png";
			break;
		case 6:
			imagenDado = "/galeria/dado_6.png";
			break;
		}

		lblDado.setIcon(new ImageIcon(VistaGrafica.class.getResource(imagenDado)));
		System.out.println("------------------");
		System.out.println("turno de :" + controlador.getAliasEnJuego().getAlias());
		System.out.println("Estabas en la :" + controlador.getAliasEnJuego().getUbicacionAnterior() + "-" + cara);
		System.out.println("------------------");
	}

	private int getPosY(int casillero) { // las cuentas para que posicione la patita en el tablero
		int cociente;

		if ((casillero % 10) == 0) {
			// tiene que quedar en la linea de abajo del
			casillero--;
		}
		cociente = casillero / 10;
		return (587 - (cociente * 65)); 

	}

	private int getPosX(int casillero) {
		int unidad;
		int decena;
		int x;
		if (casillero == 0) {
			x = 0;
		} else if ((casillero % 10) == 0) { //el modulo me devuelve el reto de la division
			// queda en los extremos
			if (((casillero / 10) % 2) == 0) { // la / devuleve la parte entera de la division 
				// si es 20 40 60 80 100 queda a la izquierda (en 69)
				x = 69;
			} else {
				// si es 10 30 50 70 90 queda a la derecha (en 650)
				x = 650;
			}
			// no es un nro divisible por 10
		} else {
			if (casillero < 10) {
				// primera linea, no tiene decena
				x = 69 + (64 * (casillero - 1));
			} else if (((casillero / 10) % 2) == 0) {
				// Se mueven hacia la derecha
				decena = ((casillero / 10) * 10); // me quedo con la parte decimal de la division de la posicion
				unidad = casillero % decena; 
				x = 69 + (64 * (unidad - 1));
			} else {
				// Se mueven hacia la izquierda
				decena = ((casillero / 10) * 10);
				unidad = casillero % decena;
				x = 650 - (64 * (unidad - 1));
			}
			//
		}
		return x;
	}

	@Override
	public void mostrarEnJuego() {
          
		cardLayout.show(this.frame.getContentPane(), VJuego);
		
	}

	@Override
	public void mostrarListaAlias() {
		// TODO Auto-generated method stub
		String s = "-";
		ArrayList<IJugador> j = controlador.getListaJugadores();
		for (IJugador jugador : j) {
			s = s + " " + jugador.getAlias()+ "\n";
		}
		if (s == "-") {
			txtdevol.setText("no se han registrado Jugadores,lo siento");
		} else {
			txtdevol.setText(s);
		}
	}

	@Override
	public void ganoOtra() {
		// TODO Auto-generated method stub
		lblGan.setText("Ganaste otra tirada!!!!!!!!!");
		
	}

	@Override
	public void mostrarFinalizarP() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarSerpiente() {
		// TODO Auto-generated method stub

		lblGan.setText("Caiste en una serpiente :-(");
	}

	@Override
	public void mostrarFinalizar() {
		cardLayout.show(this.frame.getContentPane(), VFin);
	}

	@Override
	public void mostrarEscalera() {
		// TODO Auto-generated method stub

		lblGan.setText("Caiste en una Escalera :-)");
	}

	@Override
	public void mostrarSePaso() {
		// TODO Auto-generated method stub

		lblGan.setText("te pasaste del fin volves a la casilla: "
				+ ((-((controlador.getAliasEnJuego().getUbicacionAnterior() + controlador.getDado()) - 100))
						+ 100));
	}

	@Override
	public void ganador() {
	
        controlador.guardarGanador();
		lblgano.setText("el ganador fue" + controlador.getGanador());
		//controlador.getListaGanadores(); //solo para ver qye hace
		JOptionPane.showMessageDialog(null, "el ganador es:  " + controlador.getGanador(), " ", 0);

	}

	@Override
	public void mostrarSetando() {
		// TODO Auto-generated method stub

	}
	public void mostrarTopGanadores(JList LTopGanadores) {
		ArrayList<IJugador> topGanadores = controlador.getTopGanadores();
		topGanadores.size();
		String[] lista = new String[topGanadores.size()];
		LTopGanadores.setModel((ListModel) new AbstractListModel() {
			public int getSize() {
				return lista.length;
			}
			public Object getElementAt(int index) {
				return lista[index];
			}
		});
		
	
		if (topGanadores.isEmpty()) {
			lista[0] = "aun Noexisten Ganadores";	
			
		} else {
			int i = 0;
			for(IJugador j : topGanadores ) {
				lista[i] = ( i+":" + j.getAlias() +  "\n");
				i++;
			}	
		}
	}

}
