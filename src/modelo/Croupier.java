package modelo;
/*
 * Reparte cartas a los jugadores y las quita del mazo
 * */
public class Croupier {

	private Mazo mazo;
	private Jugador jugadores[];	
	
	public Croupier(Mazo mazo, Jugador[] jugadores) {
		this.mazo = mazo;
		this.jugadores = jugadores;
	}
	
	public boolean reparte(String carta, int jugador) {
		if(mazo.quita(carta)) 
			return jugadores[jugador].darCarta(new Carta(carta));
		return false;
	}
}
