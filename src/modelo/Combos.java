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
 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es d�bil),
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
	private ArrayList<Carta> cartasMesa;
	private ArrayList<Carta> cartasInsertar;
	private ArrayList<String> cartasRango;
	private Rang rangAux;
	boolean[][] palosCartas;
	/*
	 * Cada pos representa un combo distinto
	 * */
	private int[] listaCombos;
	private Carta CartaAltaMesa;
	private Carta CartaBajaMesa;
	private Conversor conversor;
	private MejorMano MM;
	private String resultado;
	
	/*
	 * Constructor
	 * */
	public Combos(Rang r, ArrayList<Carta> cartas,ArrayList<String> cartasRango) throws IOException{
		this.listaCombos = new int[14];
		this.conversor = new Conversor();
		this.cartasMesa = cartas;
		this.rangAux = r;
		this.cartasRango = cartasRango;
		this.palosCartas = new boolean[14][4];
		this.cartasInsertar = new ArrayList<Carta>();
		cogerPalos();
		metodoAux();
		//rangoACartas(r, cartas);
		//rellenaListaCombos();
		
	}
	private char selectPalo(int pos) {
		char sol= ' ';
		int i = 0;
		while(i<4&&sol==' ') {
			if(!this.palosCartas[pos][i]) {
				if(i == 0) {
					sol = 'h';
					this.palosCartas[pos][0]= true;
				}
				else if(i == 1) {
					sol ='s';
					this.palosCartas[pos][1]= true;
				}
				else if(i == 2) {
					this.palosCartas[pos][2]= true;
					sol = 'd';
				}
				else {
					sol = 'c';
					this.palosCartas[pos][3]= true;
				}
			}
			i++;
		}
		return sol;
	}
	private void cogerPalos() {
		for(Carta c: this.cartasMesa) {
			if(c.getPalo() == 'h') {
				this.palosCartas[c.getValor()-1][0] = true;
			}
			else if(c.getPalo() == 's') {
				this.palosCartas[c.getValor()-1][1] = true;
			}
			else if(c.getPalo() == 'd') {
				this.palosCartas[c.getValor()-1][2] = true;
			}
			else {
				this.palosCartas[c.getValor()-1][3] = true;
			}	
		}
	}
	
	public void metodoAux() throws IOException {
		resultado = "";		
		//for(int i = 0;i<this.cartasRango.size();i++) {
			/*if(this.cartasRango.get(i).length()==2) {
				this.cartasMesa.add()
				this.cartasMesa.add(new Carta(this.cartasRango.get(i).charAt(0),this.selectPalo(this.conversor.charAValor(this.cartasRango.get(i).charAt(0)))));
				this.cartasMesa.add(new Carta(this.cartasRango.get(i).charAt(1),this.selectPalo(this.conversor.charAValor(this.cartasRango.get(i).charAt(1)))));
				MM = new MejorMano(this.cartasMesa);
				System.out.println(MM.getMejorJugada());
			}
			else {
				
			}*/
			for(Cordenada coor : this.rangAux.getYellow()) {//por cada posicion del rango insertaremos las parejas de cartas que no esten ya en la mesa
				
				if(coor.getColumna() != coor.getFila()) {
					if(coor.getColumna()<coor.getFila()) {//swited
						for(int i=0;i<4;i++) {
							if(!this.palosCartas[coor.getColumna()+2][i] && !this.palosCartas[coor.getFila()+2][i]) {
								this.cartasInsertar.add(new Carta(coor.getColumna()+2, this.conversor.intAPalo(i)));
								this.cartasInsertar.add(new Carta(coor.getFila()+2, this.conversor.intAPalo(i)));
							}	
						}
					}
					else {//offSwited
					for(int i=0;i<4;i++) {//i sera el palo de la primera
						for(int j=0;j<4;j++) {//j el palo de la segunda
							if(i!=j && !this.palosCartas[coor.getColumna()+2][i] && !this.palosCartas[coor.getFila()+2][j]) {
									this.cartasInsertar.add(new Carta(coor.getColumna()+2, this.conversor.intAPalo(i)));
									this.cartasInsertar.add(new Carta(coor.getFila()+2, this.conversor.intAPalo(j)));
								}
							}
						}
					}
				}
				else {//parejas
					for(int i=0;i<4;i++) {
						for(int j=i+1;j<4;j++) {//j el palo de la segunda
							if(!this.palosCartas[coor.getColumna()+2][i] && !this.palosCartas[coor.getFila()+2][j]) {
								this.cartasInsertar.add(new Carta(coor.getColumna()+2, this.conversor.intAPalo(i)));
								this.cartasInsertar.add(new Carta(coor.getFila()+2, this.conversor.intAPalo(j)));
							}
						}
					}
				}
		
					ArrayList<Carta> auxiliar = new ArrayList<Carta>();
					
					
					for(int i = 0;i<this.cartasInsertar.size()/2;i++) {
						auxiliar.clear();
						auxiliar.addAll(this.cartasMesa);
						auxiliar.add(this.cartasInsertar.get(i*2));
						auxiliar.add(this.cartasInsertar.get(1+i*2));
						MM = new MejorMano(auxiliar);
						this.resultado += MM.getMejorJugada() + "\n";
					}
					
					
			}
			
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
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							};
		for(Carta c : cartas) {//marcamos las cartas que no podemos meter
			p=this.conversor.paloAInt(c.getPalo());
			v=c.getValor();
			BoardSelec[p][v-1]=true;
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
		return resultado;
	}
	
}