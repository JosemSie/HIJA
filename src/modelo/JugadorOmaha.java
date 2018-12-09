package modelo;

import java.util.ArrayList;
/*
 * Como un jugador normal, pero en Omaha
 * */
public class JugadorOmaha extends Jugador{
	
	private static final int NUMCARTAS = 4;
	
	/*
	 * Constructor
	 * */
	public JugadorOmaha() {
		super();
	}
	
	/*
	 * Constructor con cartas
	 * */
	public JugadorOmaha(Carta carta1, Carta carta2, Carta carta3, Carta carta4) {
		this.cartas = new ArrayList<Carta>();
		this.darCarta(carta1);
		this.darCarta(carta2);
		this.darCarta(carta3);
		this.darCarta(carta4);
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
		return cartas.get(0).toString() + cartas.get(1).toString() + cartas.get(2).toString() + cartas.get(3).toString();
	}
	
}
