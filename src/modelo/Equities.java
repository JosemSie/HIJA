package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Equities {
	
	private static final int NCARTASMESA = 5;	
	private Conversor conver;
	private ArrayList<Carta> cartasMesa;
	private boolean[][] cartasMarc;//las cartas que esten marcadas estaran a true
	private Carta[][] cartasJugadores;//las 2 cartas de cada jugador
	private ArrayList<Carta> cartaInsertb;//grupos de 5 cartas que reresentan las posibles manos
	private Carta[] posibleMesa;//aray de NCARTASMESA que ira iremos insertando en cartaInsertb
	
	private int[] probsWinPlayer;//resultado final
	private int[] puntaje;//la usaremos para contar el numero de manos que gana
	
	
	public Equities() {
		this.cartasMesa= new ArrayList<Carta>();
		this.cartasMarc= new boolean[14][4];
		this.cartasJugadores = new Carta[6][2];
		this.probsWinPlayer = new int[6];
		this.puntaje = new int[6];
		this.cartaInsertb = new ArrayList<Carta>();
	}
	
	public void start() {
		this.cartasMarc= new boolean[13][4];//23456789TJQKA
		this.probsWinPlayer = new int[] {0,0,0,0,0,0};
		this.puntaje = new int[] {0,0,0,0,0,0};
		
		for(Carta c : this.cartasMesa) {//marcamos las mesas de la mesa si las hay
			this.cartasMarc[c.getValor()][conver.charAValor(c.getPalo())] = true;
		}
		
		for(int i=0;i<6;i++)
			for(int j=0;j<2;j++) {//recorremos todas las cartas de todos los jugadores y las marcanmos en las cartasMarc
				this.cartasMarc[this.cartasJugadores[i][j].getValor()-2]
						[conver.paloAInt(this.cartasJugadores[i][j].getPalo())] = true;
			}
		
		generaCartaInsert();
		//generate
	}
	
	public void generaCartaInsert() {//genera la lista de todas permutaciones de NCARTASMESA cartas permitidas	
		int k = this.cartasMesa.size();
		this.cartaInsertb = new ArrayList<Carta>();
		this.posibleMesa = new Carta[NCARTASMESA];//el array de cartas que contendra la permutacion 
		for(int i=0;i<this.cartasMesa.size();i++)
			this.posibleMesa[i] = this.cartasMesa.get(i);
		
		generaCartaInserRecursiv(k, 0, 0);
	}
	
	//genera la lista NCARTASMESA en NCARTASMESA cartas de todas la baraja que aun no ha sido repartida
	//k = numero de cartas ya en la posibleMesa, p = el palo de la ultima carta insertada, v = el valor de la ultima carta insertada
	private void generaCartaInserRecursiv(int k, int p, int v){//solo variaran las que NO son de la mesa inicial, por lo que pasando la proxima posicion a cambiar de un array nos ahoramos mucha memoria 
		if(k==NCARTASMESA) {//cuando hemos generado una posible mesa 
			this.cartaInsertb.addAll(new  ArrayList<>(Arrays.asList(this.posibleMesa)));//la a�adimos a la lista de conjuntos de manos
			//AQUI PODRIAMOS PROBAR DIRECTAMENTE CON TODAS LAS MANOS QUE HAY JUGANDO Y VER QUIEN SE LLEVA EL PUNTO pero puede que quede un poco lioso
		}
		else {//en caso de no haber llenado toda la mesa seguimos llenando con cartas aun no utilizadas
			//siempre contaremos a partir de la siguiente carta que ha sido insertada
				for(int i=v+1; i<13;i++) {//23456789tjqka
					for(int j=p+1; j<4;j++) {//las cartas se intentaran insertar desde 2h, 2d... hasta ...Ac, As
						if(!this.cartasMarc[i][j]) {
							this.posibleMesa[k] = new Carta(i+2,conver.intAPalo(j));
							generaCartaInserRecursiv(k+1, j, i);
						}
					}
				}
				 
		}
	}//coste lineal en funcion de todas las permutaciones posibles
	
	/*private void quienGanaMesa(ArrayList<Carta> c){
		
		for(int i=0;i<6;i++){
			ArrayList<Carta> caux = new ArrayList<Carta>();
			caux.addAll(c);
			caux.add(this.cartasJugadores[i][1];
 			caux.add(this.cartasJugadores[i][2];
		}
	}
	*/			 
				 
	public void setPlayerCarts(Carta c, int jugador, int posi) {//setea una carta de un jugador siempre que no este en la mesa o en la mano de otro jugador
		int v = c.getValor()-2, p = conver.charAValor(c.getPalo());
		if (!this.cartasMarc[v][p]) {
			this.cartasJugadores[jugador][posi]=c;
			this.cartasMarc[v][p]=true;
		}
	}

}
