package controlador;

import java.io.IOException;
import modelo.Rang;
import modelo.Tablero;
import modelo.ficheros;
import modelo.juego;
import vista.InterfazVistaRangos;
import vista.VistaRangos;

public class Main {

	public static void main(String[] args) {
		
		
		if(args.length >0) {
	        if(args[0].equals("v")) { 
	        	//new mainView().setVisible(true);
	    		Tablero modelo = new Tablero(new Rang(new String[] {}));
	    		InterfazVistaRangos vista = new VistaRangos();
	    		controlador control = new controlador(vista, modelo);
	    		vista.setControlador(control);
	    		vista.arranca();
	        }
			else
				try {
					int apartado = Integer.parseInt(args[0]);
					new juego(apartado, new ficheros(args[1], args[2]));
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}
	}

	
}
