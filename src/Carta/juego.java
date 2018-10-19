package Carta;

import java.io.FileNotFoundException;
import java.io.IOException;

public class juego {

	int apartado;
	ficheros f;
	String salida;
	
	public juego(int apartado, ficheros f) {
		this.apartado = apartado;
		this.f= f;

		try {
			ejecuta();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ejecuta() throws FileNotFoundException, IOException{
        String entrada = f.lecturaFichero();
        this.salida="";
		switch (apartado) {
		case 1:
			while(entrada != null) {
				this.salida += entrada+"\r\n" + new MejorMano(entrada).getResultado();
				f.escrituraFichero(this.salida+"\r\n");
				entrada = f.lecturaFichero();
			}
			f.cerrarFicheros();
			break;
		case 2:
			String cartas = "";
			int numCartasAdicionales;
			while(entrada!=null) {
				cartas = entrada.substring(0, 4);
				numCartasAdicionales = Integer.parseInt(entrada.substring(5,6));
				for(int i = 0; i<numCartasAdicionales;i++) {
					cartas += entrada.substring(7+i*2,9+i*2);
				}
				this.salida += entrada+"\r\n" + new MejorMano(cartas).getResultado();
				f.escrituraFichero(this.salida+"\r\n");
				entrada = f.lecturaFichero();
			}
			f.cerrarFicheros();
			break;
		case 3:
			while(entrada!=null) {
				cartas = entrada.toString();
				int n = Integer.parseInt(cartas.substring(0,1));
				ListaMejoresManos listaMejorMano = new ListaMejoresManos(parseo3(cartas));
				String[] auxJugada;
				String aux = "";
				for (int i = 0; i < n; i++){
					auxJugada = listaMejorMano.getLista().get(i).getMejorJugada().split(":");
					aux += listaMejorMano.getLista().get(i).getNombreJugador() + ": " + listaMejorMano.getLista().get(i).getMejorMano().toString() + " (" + auxJugada[0] + ")"+"\r\n";	
				}
				this.salida += entrada+"\r\n" + aux +"\r\n";
				f.escrituraFichero(this.salida);
				entrada = f.lecturaFichero();
			}
			f.cerrarFicheros();
			break;	
		case 4:
			String cartasComunes,cartasPropias;
			int numCartasComunes;
			while(entrada!=null) {
				cartasComunes ="";
				cartasPropias ="";
				cartasPropias = entrada.substring(0, 8);
				numCartasComunes = Integer.parseInt(entrada.substring(9,10));
				for(int i = 0; i<numCartasComunes;i++) {
					cartasComunes += entrada.substring(11+i*2,13+i*2);
				}
				this.salida += entrada+"\r\n" + new Omaha(cartasPropias, cartasComunes).getResultado();
				f.escrituraFichero(this.salida + "\r\n");
				entrada = f.lecturaFichero();
			}
			f.cerrarFicheros();
			break;
		}
    }


//Parseo para el apartado 3
//TODO
private static String[] parseo3(String arg) {
	int numManos = Integer.parseInt(String.valueOf(arg.charAt(0)));
	String[] manos = new String[numManos];
	for(int i=0;i<numManos;i++) {
		manos[i]="";
		for(int j=0;j<4;j++) manos[i] += arg.charAt(4+i*7+j);
		for(int j=0;j<10;j++) manos[i] += arg.charAt(2+numManos*7+j);
	}
	return manos;
}

public String getSalida() {
	return this.salida;
}
	
}
