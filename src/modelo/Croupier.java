package modelo;
/*
 * Reparte cartas a los jugadores y las quita del mazo
 * */
public class Croupier {

	private Mazo mazo;
	private Jugador jugadores[];	
	private Mesa mesa;
	
	public Croupier(Mazo mazo, Jugador[] jugadores, Mesa mesa) {
		this.mazo = mazo;
		this.jugadores = jugadores;
		this.mesa = mesa;
	}
	/*
	 * Reparte carta a un jugador
	 * */
	public boolean reparte(String carta, int jugador) {
		if(mazo.quita(carta)) 
			return jugadores[jugador].darCarta(new Carta(carta));
		return false;
	}
	
	/*
	 * Pone una carta en la mesa
	 * */
	public boolean sacaCarta(String carta) {
		if(mazo.quita(carta)) {
			this.mesa.addCarta(new Carta(carta));
			return true;
		}
		return false;
	}
}
