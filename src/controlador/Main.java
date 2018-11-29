package controlador;

import java.io.IOException;
import modelo.Rango;
import modelo.Tablero;
import modelo.utilidades.Ficheros;
import modelo.Juego;
import vista.practica1.VistaManos;
import vista.practica2.InterfazVistaRangos;
import vista.practica2.VistaRangos;

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
			case "2":
				Tablero modelo = new Tablero(new Rango(new String[] {}));
	    		InterfazVistaRangos vista = new VistaRangos();
	    		Controlador control = new Controlador(vista, modelo);
	    		vista.setControlador(control);
	    		vista.arranca();
			break;
			case "3":
				//TODO inicia vista practica 3
			break;
			}
	}//main
}
