package modelo;

import java.util.ArrayList;

/*
 * Escalera Color
 * Poker
 * Full
 * Color
 * Escalera
 * trio 
 * set
 * doble pareja
 * overpair (pareja en mano mejor que la carta mas alta del board),
 * top pair (pareja con la carta mas alta del board),
 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es débil),
 * middle pair (pareja con la segunda carta mas alta del board) 
 * weak pair (otras parejas).
 * Carta mas alta
 * No mano
 * */
public class Combos{
	
	/*
	 * Guarda todas las combinaciones de 5, 6 o 7 cartas que hay (quitando las de la mesa)
	 * */
	private ArrayList<MejorMano> manos;
	/*
	 * Cada pos representa un combo distinto
	 * */
	private int[] listaCombos;
	private Carta CartaAltaMesa;
	private Carta CartaBajaMesa;
	private Conversor conversor;
	
	
	
	/*
	 * Constructor
	 * */
	public Combos(Rang r, ArrayList<Carta> cartas){
		this.listaCombos = new int[14];
		rangoACartas(r, cartas);
		rellenaListaCombos();
	}
	
	private void rellenaListaCombos() {
		//Antes de probar dar primero a generar!
		//Recorre el array manos y saca los combos
	}

	/*
	 * Se rellena el array manos dado el rango y las cartas de la mesa
	 * 
	 * */
	private void rangoACartas(Rang r, ArrayList<Carta> cartas) {
		int p,v;
		boolean[][] BoardSelec = new boolean[][] {
							{false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false},
							};
		for(Carta c : cartas) {//marcamos las cartas que no podemos meter
			p=this.conversor.paloAInt(c.getPalo());
			v=c.getValor();
			BoardSelec[p][v]=true;
		}
		ArrayList<Carta> cartasInsertables = new ArrayList<Carta>();
		for(Cordenada coor : r.getYellow()) {//por cada posicion del rango insertaremos las parejas de cartas que no esten ya en la mesa
			
			if(coor.getColumna() != coor.getFila()) {
				if(coor.getColumna()<coor.getFila()) {//swited
					for(int i=0;i<4;i++) {
						if(!BoardSelec[i][coor.getColumna()] && !BoardSelec[i][coor.getFila()]) {
							cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
							cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(i)));
						}	
					}
				}
				else {//offSwited
					for(int i=0;i<4;i++) {//i sera el palo de la primera
						for(int j=0;j<4;j++) {//j el palo de la segunda
							if(i!=j && !BoardSelec[i][coor.getColumna()] && !BoardSelec[j][coor.getFila()]) {
									cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
									cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(j)));
							}
						}
					}
				}
			}
			else {//parejas
				for(int i=0;i<4;i++) {
					for(int j=i+1;j<4;j++) {//j el palo de la segunda
						if(!BoardSelec[i][coor.getColumna()] && !BoardSelec[j][coor.getFila()]) {
								cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
								cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(j)));
						}
					}
				}
			}
			
		}
		//Antes de probar dar primero a generar!
		//aniadr todas las cartas del rango
		//----caux = cartas + parejaRang
		//manos[0]=new Mejormano(c);
	}
	
	private int numCombos() {
		int a = 0;
		//for(listaCombos) 
			
		return a;
	}
	
	public String toString() {
		
		return null;
	}
	
}
