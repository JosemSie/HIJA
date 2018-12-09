package modelo;

import java.util.ArrayList;
/*
 * Guarda las cartas del jugador y sus estadisticas
 * */
public class Jugador {
	private static final int NUMCARTAS = 2;
	protected ArrayList<Carta> cartas;
	protected int equity;
	protected int ganadas;
	protected boolean fold;
	
	/*
	 * Constructor
	 * */
	public Jugador() {
		this.cartas = new ArrayList<Carta>();
		this.equity=0;
		this.ganadas=0;
		this.fold = false;
	}
	
	/*
	 * Constructor con cartas
	 * */
	public Jugador(Carta carta1, Carta carta2) {
		this.cartas = new ArrayList<Carta>();
		this.darCarta(carta1);
		this.darCarta(carta2);
		this.equity=0;
		this.fold = false;
	}
	
	public boolean darCarta(Carta carta) {
		if(cartas.size()<NUMCARTAS) {
			cartas.add(carta);
			return true;
		}
		return false;
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
	
	public void setFold(boolean b) {
		this.fold = b;
	}
	
	public boolean getFold() {
		return this.fold;
	}
}
