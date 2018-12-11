package modelo;

import java.util.ArrayList;
/*
 * Guarda las cartas del jugador y sus estadisticas
 * */
public class Jugador {
	private static final int NUMCARTAS = 2;
	private ArrayList<Carta> cartas;
	private int equity;
	private int ganadas;
	
	/*
	 * Constructor
	 * */
	public Jugador() {
		this.cartas = new ArrayList<Carta>();
		this.equity=0;
		this.ganadas=0;
	}
	
	/*
	 * Constructor con cartas
	 * */
	public Jugador(Carta carta1, Carta carta2) {
		this.cartas = new ArrayList<Carta>();
		this.darCarta(carta1);
		this.darCarta(carta2);
		this.equity=0;
	}
	
	public boolean darCarta(Carta carta) {
		if(cartas.size()<NUMCARTAS) {
			cartas.add(carta);
			return true;
		}
		return false;
	}
	
	public void setCarta(Carta carta, int pos) {//no la metera en el mismo orden
		if(!this.cartas.isEmpty() && this.cartas.size()>pos)
			this.cartas.remove(pos);
		this.cartas.add(carta);
	}
	
	public String getCartas() {
		return cartas.get(0).toString() + cartas.get(1).toString();
	}
	
	public int getEquity() {
		return equity;
	}
	public void gana() {
		ganadas++;
	}
	public int getGanadas() {
		return ganadas;
	}
	public void setEquity(int equity) {
		this.equity = equity;
	}
	
}
