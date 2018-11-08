package vista;

import javax.swing.JToggleButton;

import controlador.controlador;

public interface InterfazVistaRangos {

	static final String RANGO="Pulsa en un rango";
	static final String GENERAR="Rangos de la matriz";
	static final String SELECCIONAR="Rangos a la matriz";
	static final String PORCENTAJE="Porcentaje a la matriz";
	
	void setControlador(controlador c);
	void arranca();
	void toggle(JToggleButton boton);
	boolean isSelected(int fila, int col);
	void muestraRango(String s);
	String getRangoTexto();
	void pintaRango(int fila, int col);
	void clean();
	void mostrarPorcentajeRangos();
}
