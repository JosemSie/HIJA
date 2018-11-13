package modelo;

import java.util.ArrayList;

public class Mano {
	//Guarda en cada posicion los palos de las cartas con ese valor
	private String [] repetidas;
	//Guarda en cada posición el valor de las cartas con ese palo
	private String [] colores; //corazones, diamantes, treboles y picas
	private ArrayList<Carta> cartas;
	//private Carta[] cartas;
	private int size;
	
	public Mano(String valorCartas){
		//Como viene carta y palo, si son 10 letras seran 5 cartas.
		this.cartas = new ArrayList<Carta>(valorCartas.length()/2);
		
		//El as tiene que estar arriba y abajo para las escaleras
		//Luego en los for tendremos cuidado con esto, lo que haremos sera recorrerlo entre el 2 y el as alto
		this.repetidas = new String[] {"","","","","","","","","","","","","",""}; 
		this.colores = new String[] {"","","",""};
		int posicion = 0;
		char valor;
		char palo;
		
		//Vamos a ir aumentando dos veces, una para el valor de la carta y otra para el palo
		//Cogemos cada letra como char, pero luego vamos a usar siempre cada uno como String
		for (int i = 0; i < valorCartas.length()/2; i++){
			valor = valorCartas.charAt(2*i);				
			palo =  valorCartas.charAt(2*i + 1);
			this.cartas.add(new Carta(valor, palo));
			//System.out.println(this.cartas[posicion].getValor()-1);
			//Si tiene valor 13 quiere decir que es el as, asi que lo ponemos al principio y al final
			if (this.cartas.get(posicion).getValor()-1 == 13){
				this.repetidas[0] += String.valueOf(palo);
			}
			this.repetidas[this.cartas.get(posicion).getValor()-1] += String.valueOf(palo);
			
			
			switch (palo){
				case 'h':
					this.colores[0]+=valor;
				break;
				case 'd':
					this.colores[1]+=valor;
				break;
				case 'c':
					this.colores[2]+=valor;
				break;
				case 's':
					this.colores[3]+=valor;
				break;
				default:
				break;
			}
			posicion++;
		}
		this.size = posicion;
	}
	
	/*
	 * constructora aux
	 */
	public Mano(ArrayList<Carta> c) {
		this.cartas = c;
		this.repetidas = new String[] {"","","","","","","","","","","","","",""}; 
		this.colores = new String[] {"","","",""};
		for (Carta i : c){
			if (i.getValor() == 13){
				this.repetidas[0] += String.valueOf(i.getPalo());
			}
			this.repetidas[i.getValor()-1] += String.valueOf(i.getPalo());
			
			switch (i.getPalo()){
				case 'h':
					this.colores[0]+=i.getValor();
				break;
				case 'd':
					this.colores[1]+=i.getValor();
				break;
				case 'c':
					this.colores[2]+=i.getValor();
				break;
				case 's':
					this.colores[3]+=i.getValor();
				break;
				default:
				break;
			}	
		}
	}

	public void add(Carta carta) {
		this.cartas.add(carta);
		//System.out.println(this.cartas[posicion].getValor()-1);
		//Si tiene valor 13 quiere decir que es el as, asi que lo ponemos al principio y al final
		if (carta.getValor()-1 == 13){
			this.repetidas[0] += String.valueOf(carta.getPalo());
		}
		this.repetidas[carta.getValor()-1] += String.valueOf(carta.getPalo());
		
		
		switch (carta.getPalo()){
			case 'h':
				this.colores[0]+=carta.getValor();
			break;
			case 'd':
				this.colores[1]+=carta.getValor();
			break;
			case 'c':
				this.colores[2]+=carta.getValor();
			break;
			case 's':
				this.colores[3]+=carta.getValor();
			break;
			default:
			break;
		}
		this.size++;
	}
	
	public boolean contains(Carta c){
		int i =0;
		while(i<this.size){
			if((c.getValor()==this.cartas.get(i).getValor()) && (c.getPalo() == this.cartas.get(i).getPalo()))
				return true;
			i++;
		}
		return false;
	}
	
	public Carta getCarta(int pos){
		return this.cartas.get(pos);
	}
	public int getSize(){
		return this.size;
	}

	public String [] getRepetidas() {
		return repetidas;
	}
	
	public void setRepetidas(String [] repetidas) {
		this.repetidas = repetidas;
	}

	public String [] getColores() {
		return colores;
	}

	public void setColores(String [] colores) {
		this.colores = colores;
	}
	
	public String toString() {
		String mano = "";
		for(int i = 0; i < this.getSize(); i++)
			mano += getCarta(i);
		return mano;	
	}

}
	
	
