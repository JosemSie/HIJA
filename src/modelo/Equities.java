package modelo;

import java.io.IOException;
/*
 * Clase principal para la practica 3
 * */
public class Equities {
	
	private static final int NUMCARTASMESA = 5;
	private static final int NUMJUGADORES = 6;
	private Croupier croupier;
	private Mazo mazo;
	private Jugador[] jugadores;
	
	
	public Equities() {
		this.jugadores = new Jugador[NUMJUGADORES];
		this.mazo = new Mazo();
		this.croupier = new Croupier(mazo, jugadores);
		for(int i=0;i<NUMJUGADORES;i++) this.jugadores[i] = new Jugador();
	}
	
	public void start() {
		generaCasoDePrueba();
		int[] comb = {0};//Cosas de java :D
		combinations(NUMCARTASMESA, 0, new Carta[5], comb);
		for(int i=0;i<NUMJUGADORES;i++) {
			jugadores[i].setEquity((jugadores[i].getGanadas()*100)/comb[0]);
			System.out.println("J" +i + " "+ jugadores[i].getEquity()+"%");
		}
	}
	/*
	 * Metodo recursivo
	 * Calcula todas las posibles combinaciones y guarda en el jugador el numero de 
	 * partidas ganadas.
	 * */
	private void combinations(int len, int startPosition, Carta[] result, int[] combinations){
	    if (len==0) {
	    	combinations[0]+=1;
	    	String[] listaManos = new String[NUMJUGADORES];
	    	for(int i=0;i<NUMJUGADORES;i++) {
	    		listaManos[i] =jugadores[i].getCartas();
	    		for(Carta c : result) listaManos[i]+=c.toString();
	    	}
	    	try {
				ListaMejoresManos listaOrdenada = new ListaMejoresManos(listaManos);
				jugadores[listaOrdenada.getGanador()].gana();
			} catch (IOException e) {e.printStackTrace();}
	    }
	    else {
		    for (int j=startPosition; j <= mazo.size()-len; j++){
		        result[result.length - len] = mazo.get(j);
		        combinations(len-1, j+1, result,combinations);
		    }
	    }
	}
	/*
	 * metodo para probar entradas
	 * */
	private void generaCasoDePrueba() {//Ejemplo del enunciado
		this.croupier.reparte("Ad", 0);
		this.croupier.reparte("Ac", 0);
		
		this.croupier.reparte("Qh", 1);
		this.croupier.reparte("Qd", 1);
		
		this.croupier.reparte("As", 2);
		this.croupier.reparte("Ks", 2);
		
		this.croupier.reparte("Kc", 3);
		this.croupier.reparte("Qs", 3);
		
		this.croupier.reparte("6d", 4);
		this.croupier.reparte("7c", 4);
		
		this.croupier.reparte("8d", 5);
		this.croupier.reparte("8h", 5);
	}
	
}
