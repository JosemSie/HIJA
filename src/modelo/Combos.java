package modelo;

import java.util.ArrayList;

/*
 * Escalera Color
 * Poker
 * Full
 * Color
 * Escalera
 * trio 
 * set
 * doble pareja
 * overpair (pareja en mano mejor que la carta mas alta del board),
 * top pair (pareja con la carta mas alta del board),
 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es débil),
 * middle pair (pareja con la segunda carta mas alta del board) 
 * weak pair (otras parejas).
 * Carta mas alta
 * No mano
 * */
public class Combos{
	
	/*
	 * Guarda todas las combinaciones de 5, 6 o 7 cartas que hay (quitando las de la mesa)
	 * */
	private ArrayList<MejorMano> manos;
	/*
	 * Cada pos representa un combo distinto
	 * */
	private int[] listaCombos;
	private Carta CartaAltaMesa;
	private Carta CartaBajaMesa;
	
	
	
	/*
	 * Constructor
	 * */
	public Combos(Rang r, ArrayList<Carta> cartas){
		this.listaCombos = new int[14];
		rangoACartas(r, cartas);
		rellenaListaCombos();
	}
	
	private void rellenaListaCombos() {
		//Antes de probar dar primero a generar!
		//Recorre el array manos y saca los combos
	}

	/*
	 * Se rellena el array manos dado el rango y las cartas de la mesa
	 * 
	 * */
	private void rangoACartas(Rang r, ArrayList<Carta> cartas) {
		ArrayList<Carta> c = cartas;
		//Antes de probar dar primero a generar!
		//aniadr todas las cartas del rango
		//----caux = cartas + parejaRang
		//manos[0]=new Mejormano(c);
	}
	
	private int numCombos() {
		int a = 0;
		//for(listaCombos) 
			
		return a;
	}
	
	public String toString() {
		
		return null;
	}
	
}
