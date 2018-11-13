package modelo;

import java.io.IOException;
import java.util.ArrayList;

public class MejorMano {
	private Mano mano;
	private Mano mejorMano;
	
	private String mejorJugada;
	private String mejorJugadaAux;
	
	private String nombreJugador;

	private char pColor;
	private int rank;
	private boolean drawColor;
	private boolean drawEscalera;

	/*
	 * Constructor
	 * */
	public MejorMano(String aux) throws IOException{
		this.mejorJugada = "";
		this.drawColor = false;
		this.drawEscalera = false;
		this.setMano(new Mano(aux));
		
		calcularOpciones();
		creaMejorMano();
	}
	
	/*
	 * Constructura aux
	 * */
	public MejorMano(ArrayList<Carta> caux) throws IOException{
		this.mejorJugada = "";
		this.drawColor = false;
		this.drawEscalera = false;
		this.setMano(new Mano(caux));
		
		calcularOpciones();
		creaMejorMano();
	}
	
	/*
	 * Muestra el resultado del apartado 1 por consola
	 * */
	public String getResultado() throws IOException {
		String aux = "";
		
		if(!mejorJugada.isEmpty())aux += " - Mejor mano: " + mejorJugada+"\r\n";
		if(this.mano.getSize()<7) {
			if(drawColor)aux += " - Proyecto: Color"+"\r\n";
			if(drawEscalera)aux += " - Proyecto: Escalera "+"\r\n";
		}
		return aux;
	}

	/*
	 * Recorre todas las jugadas y guarda en la variable mejorJugada la mejor mano del jugador
	 * */
	public void calcularOpciones(){

		//Carta Alta
		if(calcularRepetidas(1)>=0) { 
			mejorJugada = "Carta Alta de " + mejorJugadaAux.charAt(0) + ": " + mejorJugadaAux;
			this.rank = 0;
		}
		
		//Pareja
		if(calcularRepetidas(2)>=0) { 
			mejorJugada = "Pareja de " + mejorJugadaAux.charAt(0) + ": " + mejorJugadaAux;
			this.rank = 1;
		}
		
		//Doble Pareja
		if(calcularDPareja()>=0) { 
			mejorJugada = "Doble Pareja de " + mejorJugadaAux.charAt(0) + " y " + mejorJugadaAux.charAt(4) + ": " + mejorJugadaAux;
			this.rank = 2;
		}
		
		//Trio
		if(calcularRepetidas(3)>=0) { 
			mejorJugada = "Trio de " + mejorJugadaAux.charAt(0) + ": " + mejorJugadaAux;
			this.rank = 3;
		}
		
		//Escalera
		
		if(calcularEscaleras()==1) { 
			mejorJugada = "Escalera: " + mejorJugadaAux;
			this.rank = 4;
		}
		
		//Color
		if(calculaColor()) { 
			mejorJugada = "Color: " + mejorJugadaAux;
			this.rank = 5;
		}
		
		//Full
		if(calcularRepetidas(3)>=0) {
			String aux = mejorJugadaAux;
			if(calcularRepetidas(2)>=0){
				mejorJugada = "Full: " + aux + " " + mejorJugadaAux;
				this.rank = 6;
			}
		}
		
		//Poker
		if(calcularRepetidas(4)>=0) { 
			mejorJugada = "Poker de " + mejorJugadaAux.charAt(0) + ": " + mejorJugadaAux;
			this.rank = 7;
		}
		int escalera = calcularEscaleras();
		//Escalera Color
		if(escalera==2) { 
			mejorJugada = "Escalera de color: " + mejorJugadaAux;
			this.rank = 8;
		}
		
		//Escalera real
		if(escalera ==3) { 
			mejorJugada = "Esacalera Real " + mejorJugadaAux;
			this.rank = 9;
		}	
	}
	
	/*
	 * Busca doble pareja en la mano del jugador
	 * */
	private int calcularDPareja() {
		int pareja = calcularRepetidas(2);
		if(pareja>=0) {
			Carta carta;
			int i = pareja-1;
			int j = 0;
			//No tiene que llegar a 1 porque solo puede contar una vez los ases
			while(i>=1 && this.mano.getRepetidas()[i].length()!=2)i--;
			if(i>=1) {
				mejorJugadaAux += "";
				while(j<2) {
					carta = new Carta(i+1,this.mano.getRepetidas()[i].charAt(j));
					mejorJugadaAux += carta.toString();
					j++;
				}
				return i;
			}
			return -1;
		}
		return -1;
	}

	/*
	 * Busca color y draw de color en la mano del jugador.
	 * */
	public boolean calculaColor() {
		for(int i = 0; i < 4; i++) {
			if(this.mano.getColores()[i].length()==4)
				drawColor=true;
			else if(this.mano.getColores()[i].length()>=5) {
				mejorJugadaAux = "";
				for(int j = 0; j < 5; j++) {
					mejorJugadaAux += this.mano.getColores()[i].charAt(j);
					switch (i){
						case 0:
							mejorJugadaAux += "h";
						break;
						case 1:
							mejorJugadaAux += "d";
						break;
						case 2:
							mejorJugadaAux += "c";
						break;
						case 3:
							mejorJugadaAux += "s";
						break;
						default:
						break;
					}
				}
				return true;
			}
		}
		return false;
	}	
	/*
	 * Busca el número de cartas repetidas pasadas por parámetro
	 * */
	public int calcularRepetidas(int numero){
		Carta carta;
		int i = 13;
		int j = 0;
		
		while(i>=0 && this.mano.getRepetidas()[i].length()!=numero)i--;
		if(i>=0) {
			mejorJugadaAux = "";
			while(j<numero) {
				carta = new Carta(i+1,this.mano.getRepetidas()[i].charAt(j));
				mejorJugadaAux += carta.toString();
				j++;
			}
			return i;
		}
		return -1;
	}
//	//determina si en el intervalo [pos-n, pos] hay escalera de color 
	private int escaleraColor(int pos, int n) {//pos sera la ultima posicion desde la que se hace escalera, n = numero de cartas que hacen la escalera 
		int length;
		int h=0 , d=0 , c=0, s=0;
		
		for(int i=pos; i>pos-n;i--) {
			char[] cartaPalos=this.mano.getRepetidas()[i].toCharArray();
			length = cartaPalos.length;
			if(length!=0) {
				for(int j=0;j<length; j++) {//marcamos los palos en los que tenemos carta
					switch (cartaPalos[j]){
					case 'h':
						h++;
					break;
					case 'd':
						d++;
					break;
					case 'c':
						c++;
					break;
					case 's':
						s++;
					break;
					default:
					break;
					}
				}
				}
			}
		int max=0;//guardaremos el maximo numero de cartas del mismo palo
		if(h>max)max = h;
		if(d>max)max = d;
		if(c>max)max = c;
		if(s>max)max=s;
		
		//guardamos el palo del que es la escalera de color
		if(h==5)pColor='h';
		else if(d==5)pColor='d';
		else if(c==5)pColor='c';
		else if(s==5)pColor='s';
		
		return max;
	}
	
	private int calcularEscaleras() {
		int retu=0;//0 si no hay escalera, 1 si hay escalera "normal", 2 si es una escalera de color, 3 escalera real
		int n=0;//contador de cartas por intervalo (si llega 5 es escalera, si es 4 proyecto) 
		int retuAnt=0;//guardara la mejor de las escaleras que anteriores para compararla con las actual
		int color;// contiene el numero de cartas del palo mas numeroso que hay en los rangos de cinco cartas
		String [] repes = this.mano.getRepetidas();
		int size = repes.length;
		for(int i =0;i<size;i++) {
			retuAnt=retu;//Actualizamos la ultima escalera
			if( i>4 && repes[i-5].length()>0) n--;
			
			if(repes[i].length()>=1) {
				n++;
				//Si tenemos escalera
				if(n==5) {
					this.drawEscalera = false;
					color=escaleraColor(i,5);
					if(retu==0) {
						retu=1;
						//Si estamos en las ultimas posiciones para la escalera real 
						if(i==size-1 && color == 5) {
							retu=3;
						}
						else if(color==5) {
							retu = 2;
						}

					}
					if(retu!=0&&retu>=retuAnt)
						escriEscalera(i, retu);
				}
				
			}
			
			if (n==4 && retu==0) {
				drawEscalera=true;
			}
		}
		return retu;
	}
	
	private void escriEscalera(int p, int r) {//p = posicion en la que termina la escalera, r = 1 escalera normal, r > 1 es con color
		mejorJugadaAux = "";
		//Para poder convertir el valor de la carta en la figura, necesitamos una carta auxiliar
		Carta aux;
		for(int i=(p-4); i<=p; i++) {
			//En caso de haber escalera normal no nos importa de que palo sea pero en el caso de tener color usaremos pColor
			if(r==1)
				aux = new Carta((char)i+1, this.mano.getRepetidas()[i].charAt(0));
			else
				aux = new Carta((char)i+1, pColor);
			mejorJugadaAux += "" + aux.toString();
		}
	}
	
	private void creaMejorMano(){
		mejorMano = new Mano(mejorJugadaAux);
		if(mejorJugadaAux.length()<10){
			for(int i=13; i>0;i--){
				for(int j=0;j<this.mano.getRepetidas()[i].length();j++){
					Carta carta = new Carta(i+1,this.mano.getRepetidas()[i].charAt(j));
					if(!this.mejorMano.contains(carta) && mejorMano.getSize()<5) 
						mejorMano.add(carta);
				}
			}
		}
	}
	
	public Mano getMano() {
		return mano;
	}
	
	public Mano getMejorMano() {
		return mejorMano;
	}

	public void setMano(Mano mano) {
		this.mano = mano;
	}
	
	public int getRank() {
		return this.rank;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getMejorJugada(){
		return this.mejorJugada;
	}
}
