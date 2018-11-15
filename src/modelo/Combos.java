//Quitar cualquier composicion que se forme con el tablero. es decir si en el tablero tienes una pareja y en la mano otra no tienes 2 pareja solo 1 pareja
//Cuidado con los full y las dobbles parejas ej(rango: 99, board. jd jh js)
//No mostrar la escalera si se puede hacer una escalera de color ej(rango:55,board: 2d 3d 4d Ad)
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
 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es dï¿½bil),
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
	int rangoJugadaDeLaMano;
	private MejorMano mejorManoMesa;
	/*
	 * Cada pos representa un combo distinto
	 * */
	private int[] listaCombos;
	private Conversor conversor;
	private MejorMano MM;
	private String resultado;
	private Carta cartaAltaMesa;
	private Carta cartaBajaMesa;
	/*
	 * Constructor
	 * */
	public Combos(Rang r, ArrayList<Carta> cartas,ArrayList<String> cartasRango) throws IOException{
		this.listaCombos = new int[16];
		this.conversor = new Conversor();
		this.cartasMesa = cartas;
		this.numTotalCombos = 0;
		this.rangAux = r;
		this.mejorManoMesa = new MejorMano(this.cartasMesa);
		MM = new MejorMano(cartasMesa);
		this.rangoJugadaDeLaMano = MM.getRank();
		this.cartasRango = cartasRango;
		this.palosCartas = new boolean[14][4];
		this.cartasInsertar = new ArrayList<Carta>();
		Carta primeraCarta = new Carta('2','d');
		Carta segundaCarta = new Carta('2','d');
		for (Carta a: cartas){
			if (a.getValor()>primeraCarta.getValor()){
				segundaCarta = primeraCarta;
				primeraCarta = a;
			}
			else if (a.getValor() > segundaCarta.getValor()){
				segundaCarta = a;
			}
		}
		this.cartaAltaMesa = primeraCarta;
		this.cartaBajaMesa = segundaCarta;
		cogerPalos();
		metodoAux();
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
				if(MM.getRank() == this.rangoJugadaDeLaMano) {
					auxiliar.removeAll(this.cartasMesa);
					MM = new MejorMano(auxiliar);
				}
				this.resultado += MM.getMejorJugada() + "\n";
				//rellenaListaCombos(MM);
				añadirCombo(MM);
			}
		}	
		verCosas();
	}
	
	private String verCosas() {
		String sol = "";
		System.out.println("Numero total de combos: "+this.numTotalCombos+"\n");
		if(this.listaCombos[1]>0) {
			sol += "Carta Alta: "+ this.listaCombos[1]+"\n";
		}
		if(this.listaCombos[2]>0) {
			sol += "Otras Parejas: "+ this.listaCombos[2]+"\n";
		}
		if(this.listaCombos[3]>0) {
			sol += "Media Pareja: "+ this.listaCombos[3]+"\n";
		}
		if(this.listaCombos[4]>0) {
			sol += "Poker Pair: "+ this.listaCombos[4]+"\n";
		}
		if(this.listaCombos[5]>0) {
			sol += "Top Pair: "+ this.listaCombos[5]+"\n";
		}
		if(this.listaCombos[6]>0) {
			sol += "Over Pair: "+ this.listaCombos[6]+"\n";
		}
		if(this.listaCombos[7]>0) {
			sol += "Doble Pareja: "+ this.listaCombos[7]+"\n";
		}
		if(this.listaCombos[8]>0) {
			sol += "Trio(uno en mesa): "+ this.listaCombos[8]+"\n";
		}
		if(this.listaCombos[9]>0) {
			sol += "Trio(dos en mesa): "+ this.listaCombos[9]+"\n";
		}
		if(this.listaCombos[10]>0) {
			sol += "Ecalera: "+ this.listaCombos[10]+"\n";
		}
		if(this.listaCombos[11]>0) {
			sol += "Color: "+ this.listaCombos[11]+"\n";
		}
		if(this.listaCombos[12]>0) {
			sol += "Full: "+ this.listaCombos[12]+"\n";
		}
		if(this.listaCombos[13]>0) {
			sol += "Poker: "+ this.listaCombos[13]+"\n";
		}
		if(this.listaCombos[14]>0) {
			sol += "Escalera color: "+ this.listaCombos[14]+"\n";
		}
		if(this.listaCombos[15]>0) {
			sol += "Escalera real de color: "+ this.listaCombos[15]+"\n";
		}
		return sol;
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
	3 * pocket pair below top pair [pp below tp] (pareja en mano con cartas menores que la mas alta del board pero que no es dï¿½bil),
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
	public void añadirComboDeParejas(MejorMano mano){
		//Si nuestra pareja es mejor que la carta mas alta del board
		if (this.conversor.stringAValor(mano.getMejorJugadaAux().substring(0, 1))>this.cartaAltaMesa.getValor()){
			this.listaCombos[6]++;
		}
		//Si nuestra pareja es con la carta mas alta del board
		else if(this.conversor.stringAValor(mano.getMejorJugadaAux().substring(0, 1))==this.cartaAltaMesa.getValor()){
			this.listaCombos[5]++;
		}
		//Si nuestra pareja esta entre medias de la alta y baja
		else if(this.conversor.stringAValor(mano.getMejorJugadaAux().substring(0, 1))<this.cartaAltaMesa.getValor()
				&& this.conversor.stringAValor(mano.getMejorJugadaAux().substring(0, 1))>this.cartaBajaMesa.getValor()){
			this.listaCombos[4]++;
		}
		//Si nuestra pareja esta hecha con la segunda carta mas alta
		else if(this.conversor.stringAValor(mano.getMejorJugadaAux().substring(0, 1))==this.cartaBajaMesa.getValor()){
			this.listaCombos[3]++;
		}
		//El resto de parejas
		else{
			this.listaCombos[2]++;
		}
	}
	void añadirCombo(MejorMano mano) {
		this.numTotalCombos++;
		switch(mano.getRank()) {
		
		case 0:
			this.listaCombos[1]++;
			break;
		case 1://pareja
			if(this.mejorManoMesa.calcularRepetidas(2) != -1) {
				if (this.mejorManoMesa.getMejorJugadaAux() == mano.getMejorJugada()){//Si la pareja es la misma, no tenemos nada
					this.listaCombos[0]++;
				}
				else{
					añadirComboDeParejas(mano);
				}
			}
			else{
				añadirComboDeParejas(mano);
			}
			break;
		case 2://doble pareja
			//Si no hay dobles parejas en la mesa, es que se ha formado con las cartas nuevas, se añade
			if (this.mejorManoMesa.calcularDPareja() == -1){
				this.listaCombos[7]++;
			}
			//Si habia dobles parejas, se miran si son iguales o no, si son distintas se añade y si no, no tenia nada
			else{
				if (this.mejorManoMesa.getMejorJugadaAux() == mano.getMejorJugada()){
					this.listaCombos[0]++;
				}
				else{
					this.listaCombos[7]++;
				}
			}
			break;
		case 3://trio
			//Si no hay trio en la mesa, se ha formado con las cartas nuevas y se añade
			if (this.mejorManoMesa.calcularRepetidas(3) == -1){//Si no hay trio en la mesa, se añade en un campo o en otro
				if (this.mejorManoMesa.calcularRepetidas(2) != -1){//Si tiene dos cartas repetidas, es que se ha hecho con dos de la mesa.
					this.listaCombos[9]++;
				}
				else{//Si no, se ha hecho con uno
					this.listaCombos[8]++;
				}
			}
			else{//Si hay trio en la mesa, miramos mas a fondo
				if (mano.getMejorJugada() == this.mejorManoMesa.getMejorJugadaAux()){//Si es el mismo trio, no tenemos nada
					this.listaCombos[0]++;
				}
				else{//Si es distinto trio, tenemos que ver como lo ha hecho
					if (this.mejorManoMesa.calcularRepetidas(2) != -1){//Si tiene dos cartas repetidas, es que se ha hecho con dos de la mesa.
						this.listaCombos[9]++;
					}
					else{//Si no, se ha hecho con uno
						this.listaCombos[8]++;
					}
				}			
			}
			
			break;
		case 4://escalera
			this.listaCombos[10]++;
			break;
		case 5://color
			this.listaCombos[11]++;
			break;
		case 6://full
			this.listaCombos[12]++;
			break;
		case 7://poker
			this.listaCombos[13]++;
			break;
		case 8://escalera de color
			this.listaCombos[14]++;
			break;
		case 9://escalera real de color 
			this.listaCombos[15]++;
			break;
			default:
				break;
		}
	}
	
	private int numCombos() {
		int a = 0;
		//for(listaCombos) 
			
		return a;
	}
	
	public String toString() {
		return "Numero de combos totales: " +this.numTotalCombos+"\n"+ verCosas();
	}
	
	
	
	
}