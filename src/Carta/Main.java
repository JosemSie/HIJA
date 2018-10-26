package Carta;

import java.io.IOException;
import vista.mainView;
import vista.vistaRangos;

public class Main {

	public static void main(String[] args) {
		
		
        if(args[0].equals("v")) { 
        	new mainView().setVisible(true);
        	new vistaRangos().setVisible(true);
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
