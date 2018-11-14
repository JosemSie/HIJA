package vista;

import javax.swing.JToggleButton;

import controlador.controlador;


/*
 * Interfaz de la vista
 * El controlador tiene acceso a los elementos aqui declarados
 * */
public interface InterfazVistaRangos {

	static final String RANGO="Pulsa en un rango";
	static final String GENERAR="Rangos de la matriz";
	static final String SELECCIONAR="Rangos a la matriz";
	static final String LIMPIAR="Limpia la matriz de Rangos";
	static final String CARTABOARD="Pulsa en una carta de la mesa";
	static final String RESULTADO ="Muestra las estadisticas";
	
	void setControlador(controlador c);
	void arranca();
	void toggleRango(JToggleButton boton);
	boolean isSelectedRango(int fila, int col);
	boolean isSelectedBoard(int fila, int col);
	String getNombreCartaBoard(int fila, int col);
	String getNombreCartaRango(int fila, int col);
	void muestraRango(String s);
	String getRangoTexto();
	void clean();
	void mostrarPorcentajeRangos();
	void toggleBoard(JToggleButton boton);
	void toggleBoard(int fila, int col);
	void generarPorcentajeRangos();
	void muestraResultado(String string);
}
