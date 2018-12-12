package modelo;

import java.util.ArrayList;
import modelo.utilidades.Conversor;

/*
 * Mazo de cartas sin repartir
 * */
public class Mazo {

	private ArrayList<Carta> cartas;
	private Conversor conv;
	
	/*
	 * Por defecto, crea un mazo completo
	 * */
	public Mazo() {
		this.conv = new Conversor();
		this.cartas = new ArrayList<Carta>();
		generaMazo();
	}
	
	public boolean quita(String carta) {
		if(carta.length()==2)
			return cartas.removeIf(Carta -> Carta.toString().equals(carta));
		
		return false;
	}
	public int size() {
		return cartas.size();
	}
	public Carta get(int pos) {
		return cartas.get(pos);
	}
	private void generaMazo() {
		for(int i=0;i<52;i++) 
			this.cartas.add(new Carta((((13+i)/13)+i)%14, conv.intAPalo(i/13)));
	}
	
	public String toString() {
		String salida = "Mazo:\nNumero de cartas = " + this.cartas.size() + "\n___________________________\n";
		for(int i=0;i<cartas.size();i++) 
			salida += this.cartas.get(i).toString() + ((i%13)==12?"\n":" ");
		return salida;
	}
	public Carta getRandom() {
        return this.cartas.remove((int) (Math.random()* this.cartas.size() -1));
	}
}
