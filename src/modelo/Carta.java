package modelo;

import modelo.utilidades.Conversor;

public class Carta {
	private int valor;
	private char palo;
	private Conversor conversor;
	
	//Le llegan dos char, uno lo convertimos en int (el valor) y otro en el palo
	public Carta(char v, char p){
		this.conversor = new Conversor();
		this.valor = this.conversor.charAValor(v);
		this.palo = p;
	}
	
	public Carta(int v, char p){		
		this.valor = v;
		this.palo = p;
		this.conversor = new Conversor();
	}
	
	public Carta(String id){
		this.conversor = new Conversor();
		if(id.length()==2) {
			this.valor = this.conversor.charAValor(id.charAt(0));
			this.palo = id.charAt(1);
		}
	}
	
	//Este metodo lo usamos para los c�lculos, para mostrar usaremos el que muestra la carta
	public int getValor(){
		return this.valor;
	}
	
	public char getPalo(){
		return this.palo;
	}	
	
	public String toString(){
		String aux;
		//aux = this.conversor.getValorCarta(this.valor) +getPalo()+ "";
		aux = Character.toString(this.conversor.getValorCarta(this.valor)) + Character.toString(getPalo());
		return aux;
	}
}
