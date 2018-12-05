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


/*
 * Clase controlador
 * - Tiene la vista y el modelo
 * - Maneja los ActionListener de la vista
 * */
public class Controlador3 implements ActionListener, ChangeListener{
	private InterfazVistaRangos vista;
	private Equities modelo;
	
	public Controlador3(Equities modelo) {
		this.modelo = modelo;
		//this.vista = vista;
		this.modelo.start();
	}
	
	
	/*
	 * Esta clase actua como actionListener de los elementos de la vista
	 * Cuando se raliza una accion, se ejecuta este metodo
	 * 
	 * Para diferenciar entre botones se usan los ActionCommands
	 * A cada elemento se le asigno un ActionCommand distinto
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {}


	@Override
	public void stateChanged(ChangeEvent e) {}

}
