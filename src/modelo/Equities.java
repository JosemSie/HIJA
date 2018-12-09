package modelo;

import java.io.IOException;
/*
 * Clase principal para la practica 3
 * */
public class Equities {
	
	private int cartasPorSalir;
	private static final int NUMJUGADORES = 6;
	private Croupier croupier;
	private Mazo mazo;
	private Jugador[] jugadores;
	private Mesa mesa;
	
	
	public Equities() {
		this.jugadores = new Jugador[NUMJUGADORES];
		this.mazo = new Mazo();
		this.mesa = new Mesa();
		this.croupier = new Croupier(mazo, jugadores, mesa);
		for(int i=0;i<NUMJUGADORES;i++) this.jugadores[i] = new Jugador();
	}
	
	public void start() {
		generaCasoPreFlop();//tarda un ratillo
		//generaCasoFlop();
		//generaCasoTurn();
		//generaCasoRiver();
		this.jugadores[1].setFold(true);
		
		int[] comb = {0};//Cosas de java :D
		combinations(this.cartasPorSalir, 0, new Carta[this.cartasPorSalir], comb);
		for(int i=0;i<NUMJUGADORES;i++) {
			jugadores[i].setEquity((jugadores[i].getGanadas()*100)/comb[0]);
			System.out.println("J" +i + " "+ jugadores[i].getEquity()+"%" + "con " +  jugadores[i].getGanadas() + " partidas ganadas");
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
	    		if(jugadores[i].getFold()) {//si no esta haciendo fold lo metemos en la lista de mejoresManos
	    			listaManos[i] ="2h";
	    		}
	    		else{
	    			listaManos[i] =jugadores[i].getCartas();
	    			if(this.cartasPorSalir<5) listaManos[i] += mesa.getCartas();
	    			for(Carta c : result) listaManos[i]+=c.toString();
	    		}
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
	 * metodos para probar entradas
	 * */
	private void generaCasoPreFlop() {//Ejemplo del enunciado
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
		
		this.cartasPorSalir=5;
	}
	
	private void generaCasoFlop() {//Ejemplo del enunciado
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
		
		this.croupier.sacaCarta("Qc");
		this.croupier.sacaCarta("6s");
		this.croupier.sacaCarta("8c");
		this.cartasPorSalir=2;
	}
	
	private void generaCasoTurn() {//Ejemplo del enunciado
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
		
		this.croupier.sacaCarta("Qc");
		this.croupier.sacaCarta("6s");
		this.croupier.sacaCarta("8c");
		this.croupier.sacaCarta("Kd");
		this.cartasPorSalir=1;
	}
	private void generaCasoRiver() {//Ejemplo del enunciado
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
		
		this.croupier.sacaCarta("Qc");
		this.croupier.sacaCarta("6s");
		this.croupier.sacaCarta("8c");
		this.croupier.sacaCarta("Kd");
		this.croupier.sacaCarta("Kh");
		this.cartasPorSalir=0;
	}
}
