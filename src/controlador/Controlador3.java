package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.Carta;
import modelo.Combos;
import modelo.Equities;
import modelo.Tablero;
import vista.practica2.InterfazVistaRangos;
import vista.practica3.VistaBoard;


/*
 * Clase controlador
 * - Tiene la vista y el modelo
 * - Maneja los ActionListener de la vista
 * */
public class Controlador3 implements ActionListener, ChangeListener{
	private VistaBoard vista;
	private Equities modelo;
	private String CARTABOARD="Pulsa en una carta de la mesa";
	
	public Controlador3(VistaBoard vista, Equities modelo) {
		this.modelo = modelo;
		this.vista = vista;
		//this.modelo.start();
	}
	
	
	/*
	 * Esta clase actua como actionListener de los elementos de la vista
	 * Cuando se raliza una accion, se ejecuta este metodo
	 * 
	 * Para diferenciar entre botones se usan los ActionCommands
	 * A cada elemento se le asigno un ActionCommand distinto
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.verMazo();
		int jug, car;
		String[] comando = e.getActionCommand().split(" ");
		if(comando[0].equals("SelecCard")) { //define la carta selecionada
			if(comando[1].equals("Rand")) {//comando "SelecCard Rand" la carta selecionada es random
				modelo.selecRand();
			}
			else {//comando "SelecCard ValorPalo" la carta selecionada es ValorPalo
				modelo.setCartaSelec(comando[1]);
			}
			vista.setCartaSelec(modelo.getCartaSelec());//le pasamos la carta selecionada a la vista
		}
		else if(comando[0].equals("ChangeCard")) {//comando "ChangeCard jug posicion"
			jug = Integer.parseInt(comando[1]);
			car = Integer.parseInt(comando[2]);
			if(modelo.setJugCarta(jug, car))
				this.vista.addCartaJugador(jug, car);//pone la carta selecionada en el jugador
		}
		else if(e.getActionCommand().equals(CARTABOARD)) {
			this.vista.toggleBoard((JButton) e.getSource());
		}
		else if(comando[0].equals("CartaEnMesa")) {//comando "CartaMesa" mete la carta seleccionada en la mesa
			if(modelo.cartaEnMesa()) {
				this.vista.setCartasMesa(modelo.getCartasMesa());
			}
			
		}
		else if(comando[0].equals("Clear")) {
			modelo.clean();
			vista = new VistaBoard();
			vista.setControlador(this);
			vista.arranca();
		}
		else if(comando[0].equals("Calculate")) {
			modelo.start();
			vista.setEquities(modelo.getEquities());
		}
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		modelo.start();
	}

}
