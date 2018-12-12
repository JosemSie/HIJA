package modelo;

import java.util.ArrayList;
/*
 * Guarda las cartas del jugador y sus estadisticas
 * */
public class Jugador {
	private static final int NUMCARTAS = 2;
	protected ArrayList<Carta> cartas;
	protected int equity;
	private int ganadas;
	protected boolean fold;
	
	/*
	 * Constructor
	 * */
	public Jugador() {
		this.cartas = new ArrayList<Carta>();
		this.equity=0;
		this.ganadas=0;
		this.fold=false;
	}
	
	/*
	 * Constructor con cartas
	 * */
	public Jugador(Carta carta1, Carta carta2) {
		this.cartas = new ArrayList<Carta>();
		this.darCarta(carta1);
		this.darCarta(carta2);
		this.equity=0;
		this.fold=false;
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
	
	public void setEquity(int equity) {
		this.equity = equity;
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
	
	public boolean tieneUnaCarta() {
		return cartas.size()==1;
	}
	
	public boolean tieneDosCartas() {
		return cartas.size()==2;
	}
	
	public void setFold(boolean f) {
		this.fold = f;
	}
	
	public boolean getFold() {
		return this.fold;
	}

	public void clearGanadas() {
		this.ganadas=0;
	}
	
}
