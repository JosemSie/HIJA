package modelo;

import java.awt.event.ActionEvent;
import java.io.IOException;

import controlador.Controlador3;
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
	private Carta cartaSelec;
	private Controlador3 controlador;
	private Thread hilo;
	private boolean calculando;
	
	public Equities() {
		this.jugadores = new Jugador[NUMJUGADORES];
		this.mazo = new Mazo();
		this.mesa = new Mesa();
		this.calculando = false;
		this.croupier = new Croupier(mazo, jugadores, mesa);
		for(int i=0;i<NUMJUGADORES;i++) this.jugadores[i] = new Jugador();
	}
	
	public void setControlador(Controlador3 controlador) {
		this.controlador = controlador;
	}
		
	@SuppressWarnings("deprecation")
	public void calcula() {
		this.cartasPorSalir=mesa.getNumCartasPorSalir();
		boolean distribucionValida = true;
		for(int i=0;i<NUMJUGADORES;i++) {
			jugadores[i].clearGanadas();
			if(jugadores[i].tieneUnaCarta()) {
				jugadores[i].setFold(true);
				distribucionValida = false;
			}
			else if(!jugadores[i].tieneDosCartas()) jugadores[i].setFold(true);
			else jugadores[i].setFold(false);
		}
		
		if(!distribucionValida || !mesa.haySuficientesCartas()) return;
		if(calculando) {
			this.hilo.stop();
			System.out.println("Calculo cancelado\nx x x x x x x x");
		}
		calculando = true;
		this.hilo = new Thread(() -> {
			int[] comb = {0};//Cosas de java :D
			int[] equity = new int[NUMJUGADORES];
			combinations(this.cartasPorSalir, 0, new Carta[this.cartasPorSalir], comb);
			for(int i=0;i<NUMJUGADORES;i++) {
				jugadores[i].setEquity((jugadores[i].getGanadas()*100)/comb[0]);
				equity[i] = jugadores[i].getEquity();
			}
			controlador.actionPerformed(new ActionEvent(equity,1,"EQUITY"));
			calculando = false;
			System.out.println("Equity calculado :D");
		});
		hilo.start();
		System.out.println("Calculando Equity\n. . .");
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
	    		if(jugadores[i].getFold()) {
	    			listaManos[i] = "2h";//es la peor de las posibles manos
	    		}
	    		else {
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
	public boolean reparte(String idCarta, int jugador) {
		return this.croupier.reparte(idCarta, jugador);
	}
	public boolean sacaCarta(String idCarta) {
		return this.croupier.sacaCarta(idCarta);
	}
	/*
	 * metodos para probar entradas
	 * */
	public void clean() {
		this.jugadores = new Jugador[NUMJUGADORES];
		this.mazo = new Mazo();
		this.mesa = new Mesa();
		this.croupier = new Croupier(mazo, jugadores, mesa);
		for(int i=0;i<NUMJUGADORES;i++) this.jugadores[i] = new Jugador();
	}
			
	public boolean cartaEnMesa() {
		if(mazo.quita(this.cartaSelec.toString())) { 
			mesa.addCarta(this.cartaSelec);
			return true;
		}
		return false;
	}
	
	public Carta selecCartaRandom() {
		return this.mazo.getRandom();
	}
	
	public void verMazo() {
		System.out.println(this.mazo.toString());
	}
	
	public Carta getCartaSelec() {
		return this.cartaSelec;
	}
	
	public int[] getEquities() {
		int siz =this.jugadores.length;
		int[] equities = new int[this.jugadores.length]; 
		for(int i=0;i<siz; i++)
			equities[i]=this.jugadores[i].getEquity();
		return null;
	}
	
	public String getCartasMesa() {
		return mesa.getCartas();
	}
/*	
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
*/	
}
