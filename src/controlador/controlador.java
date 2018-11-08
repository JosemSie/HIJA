package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import modelo.Tablero;
import vista.InterfazVistaRangos;

public class controlador implements ActionListener{
	private InterfazVistaRangos vista;
	private Tablero modelo;
	
	public controlador(InterfazVistaRangos vista, Tablero modelo) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(InterfazVistaRangos.RANGO)) {
			this.vista.toggle((JToggleButton) e.getSource());
		}
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
		else if(e.getActionCommand().equals(InterfazVistaRangos.GENERAR)) {
	    	this.modelo.clean();
	    	for(int i=0;i<13;i++)
	    		for(int j=0;j<13;j++) {
	    			if(this.vista.isSelected(i, j)) 
	    				this.modelo.selectCord(12-i, 12-j);
	    		}
	        this.modelo.tabToRang();
	        //rescribir
	        this.vista.muestraRango(this.modelo.getRang().toString());
		}
		else if(e.getActionCommand().equals(InterfazVistaRangos.PORCENTAJE)) {
			this.vista.mostrarPorcentajeRangos();
		}
	
	}

}
