package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.Carta;
import modelo.Equities;
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
	private String cartaSeleccionada;
	
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
		int jug, car;
		String[] comando = e.getActionCommand().split(" ");
		if(comando[0].equals("SelecCard")) { //define la carta selecionada
			if(comando[1].equals("Rand")) { //comando "SelecCard Rand" la carta selecionada es random
				Carta c = modelo.selecCartaRandom();
				vista.setCartaSelec(c);//le pasamos la carta selecionada a la vista
				this.cartaSeleccionada = c.toString();
			}
		}
		else if(comando[0].equals("ChangeCard")) {//comando "ChangeCard jug posicion"
			if(cartaSeleccionada==null) return;
			jug = Integer.parseInt(comando[1]);
			car = Integer.parseInt(comando[2]);
			modelo.reparte(cartaSeleccionada,jug);
			this.vista.addCartaJugador(jug, car);//pone la carta selecionada en el jugador
			modelo.calcula();
		}
		else if(e.getActionCommand().equals(CARTABOARD)) {
			this.cartaSeleccionada = ((JButton) e.getSource()).getText();
			this.vista.toggleBoard((JButton) e.getSource());
		}
		else if(comando[0].equals("CartaEnMesa")) {//comando "CartaMesa" mete la carta seleccionada en la mesa
			if(cartaSeleccionada==null) return;
			modelo.sacaCarta(cartaSeleccionada);
			this.vista.addCartaMesa(Integer.parseInt(comando[1]));
			modelo.calcula();
		}
		else if(comando[0].equals("Clear")) {
			modelo.clean();
			vista = new VistaBoard();
			vista.setControlador(this);
			vista.arranca();
		}
		else if(comando[0].equals("Calculate")) {
			modelo.calcula();
			vista.setEquities(modelo.getEquities());
		}
		else if(comando[0].equals("EQUITY")) {
			vista.setEquities((int[]) e.getSource());;
		}
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		modelo.calcula();
	}

}
