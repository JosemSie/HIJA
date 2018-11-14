package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	int numTotalCombos;
	
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
		this.numTotalCombos = 0;
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
			this.palosCartas[c.getValor()-1][this.conversor.paloAInt(c.getPalo())] = true;
			if(c.getValor()==14) {
				this.palosCartas[0][this.conversor.paloAInt(c.getPalo())] = true;
			}
		}
	}
	
	public void metodoAux() throws IOException {
		resultado = "";		
		for(Cordenada coor : this.rangAux.getYellow()) {//por cada posicion del rango insertaremos las parejas de cartas que no esten ya en la mesa
			
			if(coor.getColumna() != coor.getFila()) {
				if(coor.getColumna()<coor.getFila()) {//swited
					for(int i=0;i<4;i++) {
						if(!this.palosCartas[coor.getColumna()+1][i] && !this.palosCartas[coor.getFila()+1][i]) {
							this.cartasInsertar.add(new Carta(coor.getColumna()+2, this.conversor.intAPalo(i)));
							this.cartasInsertar.add(new Carta(coor.getFila()+2, this.conversor.intAPalo(i)));
						}	
					}
				}
				else {//offSwited
				for(int i=0;i<4;i++) {//i sera el palo de la primera
					for(int j=0;j<4;j++) {//j el palo de la segunda
						if(i!=j && !this.palosCartas[coor.getColumna()+1][i] && !this.palosCartas[coor.getFila()+1][j]) {
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
						if(!this.palosCartas[coor.getColumna()+1][i] && !this.palosCartas[coor.getFila()+1][j]) {
							this.cartasInsertar.add(new Carta(coor.getColumna()+2, this.conversor.intAPalo(i)));
							this.cartasInsertar.add(new Carta(coor.getFila()+2, this.conversor.intAPalo(j)));
						}
					}
				}
					
				
				
				
				
				//	ArrayList<Carta> auxiliar = new ArrayList<Carta>();
					
					
				/*	for(int i = 0;i<this.cartasInsertar.size()/2;i++) {
						auxiliar.clear();
						auxiliar.addAll(this.cartasMesa);
						auxiliar.add(this.cartasInsertar.get(i*2));
						auxiliar.add(this.cartasInsertar.get(1+i*2));
						
						System.out.println(auxiliar);
						if(!tieneDuplicados(auxiliar)) {
							MM = new MejorMano(auxiliar);
							this.resultado += MM.getMejorJugada() + "\n";
						}
					}*/
			}
		}
		ArrayList<Carta> auxiliar = new ArrayList<Carta>();
		
		
		for(int i = 0;i<this.cartasInsertar.size()/2;i++) {
			auxiliar.clear();
			auxiliar.addAll(this.cartasMesa);
			auxiliar.add(this.cartasInsertar.get(i*2));
			auxiliar.add(this.cartasInsertar.get(1+i*2));
			if(!tieneDuplicados(auxiliar)) {
				MM = new MejorMano(auxiliar);
				this.resultado += MM.getMejorJugada() + "\n";
				rellenaListaCombos(MM);
				
			}
		}	
		verCosas();
	}
	
	private void verCosas() {
		System.out.println("Numero total de combos: "+this.numTotalCombos+"\n");
		for(int i = 0;i<this.listaCombos.length;i++) {
			System.out.println(this.listaCombos[i]+"/"+this.numTotalCombos);
		}
	}
	
	private boolean tieneDuplicados(ArrayList<Carta> a) {
		Set<Carta> set = new HashSet<Carta>(a);
		return set.size() < a.size();
	}
	/*
	13 * Escalera Color
	 12* Poker
	11 * Full
	10 * Color
	9 * Escalera
	 8* trio 
	7 * set
	6 * doble pareja
	5 * overpair (pareja en mano mejor que la carta mas alta del board),
	4 * top pair (pareja con la carta mas alta del board),
	3 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es d�bil),
	2 * middle pair (pareja con la segunda carta mas alta del board) 
	1 * weak pair (otras parejas).
	0 * Carta mas alta
	 * No mano
	 * */
	private void rellenaListaCombos(MejorMano MM) {
		switch(MM.getRank()){
		//Carta alta
		case 0:
			this.listaCombos[0]++;
			this.numTotalCombos++;
			break;
		//Pareja
		case 1:
			this.listaCombos[1]++;
			this.numTotalCombos++;
			break;
		//DoblePareja
		case 2:
			this.listaCombos[6]++;
			this.numTotalCombos++;
			break;
		//Trio
		case 3:
			this.listaCombos[7]++;
			this.numTotalCombos++;
			break;
		//escalera
		case 4:
			this.listaCombos[9]++;
			this.numTotalCombos++;
			break;
		//color
		case 5:
			this.listaCombos[10]++;
			this.numTotalCombos++;
			break;
		//full
		case 6:
			this.listaCombos[11]++;
			this.numTotalCombos++;
			break;
		//poker
		case 7:
			this.listaCombos[12]++;
			this.numTotalCombos++;
			break;
		//Escalera color
		case 8:
		//Escalera real
		case 9:
			this.listaCombos[13]++;
			this.numTotalCombos++;
			break;
		}
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