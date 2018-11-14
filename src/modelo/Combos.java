package modelo;

import java.io.IOException;
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
	private ArrayList<Carta> cartasMesa;
	private Carta cartaAltaMesa;
	private Carta cartaBajaMesa;
	private Conversor conversor;
	private ArrayList<Carta> cartasInsertables;
	
	
	
	/*
	 * Constructor
	 * */
	public Combos(Rang r, ArrayList<Carta> cartas){
		this.conversor = new Conversor();
		this.cartasInsertables =  new ArrayList<Carta>();
		this.listaCombos = new int[14];
		this.cartasMesa = cartas;
		rangoACartas(r);
		//rellenaListaCombos();
	}
	
	private void rellenaListaCombos() throws IOException {
		ArrayList<Carta> l = new ArrayList<Carta>();
		Carta a,b;
		int size = this.cartasInsertables.size()/2;
		for(int i =0; i<size;i++) {
			l.clear();
			l.addAll(cartasMesa);
			a = this.cartasInsertables.get(i*2);//las cartas en la lista seran insertadas de dos en dos
			b = this.cartasInsertables.get(1+i*2);//porque al crear la lista de insertables la hicimos de dos en dos
			l.add(a);
			l.add(b);
			MejorMano m = new MejorMano(l);
			añadirCombo(m.getRank(), a, b);
			}
		//Antes de probar dar primero a generar!
		//Recorre el array manos y saca los combos
	}
	
	
	void añadirCombo(int rank, Carta a, Carta b) {
		switch(rank) {
		case 0:
			this.listaCombos[0]++;
			break;
		case 1://pareja
			if(a.getValor()==b.getValor()) {
				//HECTOOOOOR pls:3
			}
			break;
		case 2://doble pareja
			//no se que se hace con la doble pareja
			break;
		case 3://trio
			break;
		case 4://escalera
			break;
		case 5://color
			break;
		case 6://full
			break;
		case 7://poker
			break;
		case 8://escalera de color
			break;
		case 9://escalera real de color 
			//probablemente habra que fusionar el 8 y 9
			break;
			default:
				break;
		}
	}

	/*
	 * Se rellena el array manos dado el rango y las cartas de la mesa
	 * 
	 * */
	private void rangoACartas(Rang r) {
		int p,v;
		Carta a, b;
		this.cartasInsertables.clear();
		//boolean[][] BoardSelec = new boolean[][] {
		//					{false,false,false,false,false,false,false,false,false,false,false,false,false},
		//					{false,false,false,false,false,false,false,false,false,false,false,false,false},
		//					{false,false,false,false,false,false,false,false,false,false,false,false,false},
		//					{false,false,false,false,false,false,false,false,false,false,false,false,false},
		//					};
		//for(Carta c : cartas) {//marcamos las cartas que no podemos meter
		//	p=this.conversor.paloAInt(c.getPalo());
		//	v=c.getValor();
		//	BoardSelec[p][v]=true;
		//}
		for(Cordenada coor : r.getYellow()) {//por cada posicion del rango insertaremos las parejas de cartas que no esten ya en la mesa
			
			if(coor.getColumna() != coor.getFila()) {
				if(coor.getColumna()<coor.getFila()) {//swited
					for(int i=0;i<4;i++) {
		//				if(!BoardSelec[i][coor.getColumna()] && !BoardSelec[i][coor.getFila()]) {
						a = new Carta(coor.getColumna(), this.conversor.intAPalo(i));
						b= new Carta(coor.getFila(), this.conversor.intAPalo(i));
						if(!this.cartasMesa.contains(a) && !this.cartasMesa.contains(b)) {//si no esta entre las cartas ya marcadas insertamos la nueva pareja
							//cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
							cartasInsertables.add(a);
							//cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(i)));
							cartasInsertables.add(b);
						}	
					}
				}
				else {//offSwited
					for(int i=0;i<4;i++) {//i sera el palo de la primera
						for(int j=0;j<4;j++) {//j el palo de la segunda
							a = new Carta(coor.getColumna(), this.conversor.intAPalo(i));
							b= new Carta(coor.getFila(), this.conversor.intAPalo(j));
							//if(i!=j && !BoardSelec[i][coor.getColumna()] && !BoardSelec[j][coor.getFila()]) {
							if(!this.cartasMesa.contains(a) && !this.cartasMesa.contains(b)) {//si no esta entre las cartas ya marcadas insertamos la nueva pareja
								//cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
								cartasInsertables.add(a);
								//cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(j)));
								cartasInsertables.add(b);
							}
						}
					}
				}
			}
			else {//parejas
				for(int i=0;i<4;i++) {
					for(int j=i+1;j<4;j++) {//j el palo de la segunda
						//if(!BoardSelec[i][coor.getColumna()] && !BoardSelec[j][coor.getFila()]) {
						a = new Carta(coor.getColumna(), this.conversor.intAPalo(i));
						b= new Carta(coor.getFila(), this.conversor.intAPalo(j));
						if(!this.cartasMesa.contains(a) && !this.cartasMesa.contains(b)) {//si no esta entre las cartas ya marcadas insertamos la nueva pareja
								//cartasInsertables.add(new Carta(coor.getColumna(), this.conversor.intAPalo(i)));
							cartasInsertables.add(a);
								//cartasInsertables.add(new Carta(coor.getFila(), this.conversor.intAPalo(j)));
							cartasInsertables.add(b);
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
