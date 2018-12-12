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
import modelo.Tablero;
import vista.practica2.InterfazVistaRangos;


/*
 * Clase controlador
 * - Tiene la vista y el modelo
 * - Maneja los ActionListener de la vista
 * */
public class Controlador2 implements ActionListener, ChangeListener{
	private InterfazVistaRangos vista;
	private Tablero modelo;
	
	public Controlador2(InterfazVistaRangos vista, Tablero modelo) {
		this.modelo = modelo;
		this.vista = vista;
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
		//Maneja los botones de la matriz de rangos
		if(e.getActionCommand().equals(InterfazVistaRangos.RANGO)) {
			this.vista.toggleRango((JToggleButton) e.getSource());
			generar();
			this.vista.generarPorcentajeRangos();
		}
		//Maneja el boton seleccionar
		else if(e.getActionCommand().equals(InterfazVistaRangos.SELECCIONAR)) {
			
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
		}
		//Maneja el boton generar
		else if(e.getActionCommand().equals(InterfazVistaRangos.GENERAR)) {
			generar();
		}
		
		//Maneja los botones de la matriz de cartas sobre la mesa
		else if(e.getActionCommand().equals(InterfazVistaRangos.CARTABOARD)) 
			this.vista.toggleBoard((JToggleButton) e.getSource());
		
		//Maneja el boton resultado
		else if(e.getActionCommand().equals(InterfazVistaRangos.RESULTADO)) {
			
			ArrayList<Carta> cartas = new ArrayList<Carta>();
			ArrayList<String> cartasTablero = new ArrayList<String>();
			for(int i=0;i<13;i++)
	    		for(int j=0;j<4;j++) 
	    			if(this.vista.isSelectedBoard(i, j))
	    				cartas.add(new Carta(this.vista.getNombreCartaBoard(i, j).charAt(0), (this.vista.getNombreCartaBoard(i, j).charAt(1))));	    		
			for(int i = 0; i<13;i++)
				for(int j = 0; j<13;j++)
					if(this.vista.isSelectedRango(i, j))cartasTablero.add(this.vista.getNombreCartaRango(i, j));
			Combos combos;
			try {
				if(cartas.size()<3 || cartas.size()>5)this.vista.muestraResultado("La mesa debe tener al menos tres cartas, y cinco como maximo");
				else {
					combos = new Combos(this.modelo.getRang(), cartas,cartasTablero);
					this.vista.muestraResultado(combos.toString());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
						
		}
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		this.vista.mostrarPorcentajeRangos();
		generar();
	}

	private void limpiar() {
		this.modelo.clean();
		this.vista.clean();
	}
	
	private void generar() {
		this.modelo.clean();
    	for(int i=0;i<13;i++)
    		for(int j=0;j<13;j++) {
    			if(this.vista.isSelectedRango(i, j)) 
    				this.modelo.selectCord(12-i, 12-j);
    		}
        this.modelo.tabToRang();
        //rescribir
        this.vista.muestraRango(this.modelo.getRang().toString());
	}
	
}
