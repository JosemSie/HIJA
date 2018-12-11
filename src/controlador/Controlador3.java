package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
		if(comando[0].equals("ChangeCard")) {
			jug = Integer.parseInt(comando[1]);
			car = Integer.parseInt(comando[2]);
			modelo.setJugCarta(jug, car);
			this.vista.setCartaSelec(modelo.getCartaSelec());
		}
		else if(comando[0].equals("SelecCard")) {
			if(comando[1].equals("Rand")) {
				modelo.selecRand();
				
			}
		}
		//Maneja el boton seleccionar
		/*else if(e.getActionCommand().equals(InterfazVistaRangos.SELECCIONAR)) {
			
			String texto = this.vista.getRangoTexto();
	    	if(texto.isEmpty()) limpiar();
	    	else {
		    	modelo.setRango(texto.split(", "));
		    	int[][] tableroCutreAux = modelo.getTablerocutre();
		    	for(int i=0;i<13;i++)
		    		for(int j=0;j<13;j++) 
		    			if((tableroCutreAux[i][j]==2) != this.vista.isSelectedRango(12-i, 12-j)) 
		    				this.vista.toggleBoard(12-i,12-j);
	    	}
		}
		else if(e.getActionCommand().equals(InterfazVistaRangos.LIMPIAR)) {
			limpiar();
		}*/
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		modelo.start();
	}

}
