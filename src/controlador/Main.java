package controlador;

import java.io.IOException;
import modelo.Rango;
import modelo.Tablero;
import modelo.utilidades.Ficheros;
import modelo.Equities;
import modelo.Juego;
import vista.practica1.VistaManos;
import vista.practica2.InterfazVistaRangos;
import vista.practica2.VistaRangos;
import vista.practica3.VistaBoard;

public class Main {

	/*
	 * El primer argumento es un numero que selecciona la practica a ejecutar
	 */
	public static void main(String[] args) {
		if(args.length >0)
			switch(args[0]){
			case "1":
				if(args.length != 4) new VistaManos().setVisible(true);
				else {
					/*	Ejemplos para ejecución con ficheros
					 * 1 1 entradasEjemplo/entrada1.txt entradasEjemplo/salida.txt
					 * 1 2 entradasEjemplo/entrada2.txt entradasEjemplo/salida.txt
					 * 1 3 entradasEjemplo/entrada3.txt entradasEjemplo/salida.txt
					 * 1 4 entradasEjemplo/entrada4.txt entradasEjemplo/salida.txt
					 */
					try{ new Juego(Integer.parseInt(args[1]), new Ficheros(args[2], args[3]));
					}catch (IOException exc) {exc.printStackTrace();}
				}
			break;
			
			case "2": iniciaPractica2();
			break;
			
			case "3": iniciaPractica3();
			break;
			
			default: iniciaPractica3();
			}
		else iniciaPractica3();
	}//main
	
	private static void iniciaPractica2() {
		Tablero modelo = new Tablero(new Rango(new String[] {}));
		InterfazVistaRangos vista = new VistaRangos();
		Controlador2 control = new Controlador2(vista, modelo);
		vista.setControlador(control);
		vista.arranca();
	}
	
	private static void iniciaPractica3() {
		//TODO generar la vista y pasarsela al controlador
		Equities modelo = new Equities();
		VistaBoard vista = new VistaBoard();
		Controlador3 control = new Controlador3(vista, modelo);
		vista.setControlador(control);
		vista.arranca();
	
	}
}
