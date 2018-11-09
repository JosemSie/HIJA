package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import modelo.Tablero;
import vista.InterfazVistaRangos;


/*
 * Clase controlador
 * - Tiene la vista y el modelo
 * - Maneja los ActionListener de la vista
 * */
public class controlador implements ActionListener{
	private InterfazVistaRangos vista;
	private Tablero modelo;
	
	public controlador(InterfazVistaRangos vista, Tablero modelo) {
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
		if(e.getActionCommand().equals(InterfazVistaRangos.RANGO)) 
			this.vista.toggleRango((JToggleButton) e.getSource());
		
		//Maneja el boton seleccionar
		else if(e.getActionCommand().equals(InterfazVistaRangos.SELECCIONAR)) {
			this.modelo.clean();
			this.vista.clean();
			String texto = this.vista.getRangoTexto();
	    	if(!texto.isEmpty()) {
		    	modelo.setRango(texto.split(", "));
		    	int[][] tableroCutreAux = modelo.getTablerocutre();
		    	for(int i=0;i<13;i++)
		    		for(int j=0;j<13;j++) {
		    			if(tableroCutreAux[i][j]==2) 
		    				this.vista.pintaRango(12-i,12-j);
		    		}
	    	}
		}
		
		//Maneja el boton generar
		else if(e.getActionCommand().equals(InterfazVistaRangos.GENERAR)) {
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
		
		//Maneja los botones de la matriz de cartas sobre la mesa
		else if(e.getActionCommand().equals(InterfazVistaRangos.CARTABOARD)) 
			this.vista.toggleBoard((JToggleButton) e.getSource());
		
		//Maneja el boton resultado
		else if(e.getActionCommand().equals(InterfazVistaRangos.RESULTADO)) {
			String estadisticas = "Estadisticas: "
									+ "\n - Rangos " + this.modelo.getRang().toString()
									+ "\n - Cartas sobre la mesa";
			for(int i=0;i<13;i++)
	    		for(int j=0;j<4;j++) {
	    			if(this.vista.isSelectedBoard(i, j)) 
	    				estadisticas += " " + this.vista.getNombreCartaBoard(i, j) + " ";
	    		}
			this.vista.muestraResultado(estadisticas);
		}
	}

}
