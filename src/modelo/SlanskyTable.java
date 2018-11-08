package modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class SlanskyTable {
	private ParejaCartas[][] tabla; //Esta es la tabla tal cual, sin ordenarla por si necesitamos mirar algo en ella
	private ArrayList<ParejaCartas> tablaOrdenada;	//Aqu� vaa estar toda la tabla ordenada
	
	public SlanskyTable(){
		this.tabla = new ParejaCartas[13][13];
		//Primero la usamos sin ordenar para que lo meta en la tabla y luego la ordenamos
		this.tablaOrdenada = new ArrayList<ParejaCartas>();
		rellenarTablaOrdenada();
		int iterador = 0;
		for (int i = 0; i < 13; i++){
			for (int j = 0; j < 13; j++){
				this.tabla[i][j] = this.tablaOrdenada.get(iterador);				
				iterador++;
			}
		}
		//Ordenamos el arraylist
		this.tablaOrdenada.sort(new Comparator<ParejaCartas>() {
			public int compare (ParejaCartas pareja1, ParejaCartas pareja2){
				if (pareja1.getValor() < pareja2.getValor()){
					return 1;
				}
				else if (pareja1.getValor() > pareja2.getValor()){
					return -1;
				}
				else{
					return 0;
				}
			}
		}); 
		
	}
	
	//Esta funcion simplemente mete los valores tal cual estan en la tabla para que luego sea mas facil meterlo en la misma
	private void rellenarTablaOrdenada(){
		this.tablaOrdenada.add(new ParejaCartas("AA", 500.0));
		this.tablaOrdenada.add(new ParejaCartas("AKs", 277.0));
		this.tablaOrdenada.add(new ParejaCartas("AQs", 137));
		this.tablaOrdenada.add(new ParejaCartas("AJs", 91.6));
		this.tablaOrdenada.add(new ParejaCartas("ATs", 69.5));
		this.tablaOrdenada.add(new ParejaCartas("A9s", 52.0));
		this.tablaOrdenada.add(new ParejaCartas("A8s", 44.9));
		this.tablaOrdenada.add(new ParejaCartas("A7s", 39.5));
		this.tablaOrdenada.add(new ParejaCartas("A6s", 35.3));
		this.tablaOrdenada.add(new ParejaCartas("A5s", 36.1));
		this.tablaOrdenada.add(new ParejaCartas("A4s", 33.3));
		this.tablaOrdenada.add(new ParejaCartas("A3s", 31.1));
		this.tablaOrdenada.add(new ParejaCartas("A2s", 29.0));
		
		this.tablaOrdenada.add(new ParejaCartas("AKo", 166.0));
		this.tablaOrdenada.add(new ParejaCartas("KK", 477.0));
		this.tablaOrdenada.add(new ParejaCartas("KQs", 43.3));
		this.tablaOrdenada.add(new ParejaCartas("KJs", 36.3));
		this.tablaOrdenada.add(new ParejaCartas("KTs", 31.4));
		this.tablaOrdenada.add(new ParejaCartas("K9s", 23.9));
		this.tablaOrdenada.add(new ParejaCartas("K8s", 19.9));
		this.tablaOrdenada.add(new ParejaCartas("K7s", 18.6));
		this.tablaOrdenada.add(new ParejaCartas("K6s", 17.4));
		this.tablaOrdenada.add(new ParejaCartas("K5s", 16.1));
		this.tablaOrdenada.add(new ParejaCartas("K4s", 15.0));
		this.tablaOrdenada.add(new ParejaCartas("K3s", 14.1));
		this.tablaOrdenada.add(new ParejaCartas("K2s", 13.3));

		this.tablaOrdenada.add(new ParejaCartas("AQo", 96.0));
		this.tablaOrdenada.add(new ParejaCartas("KQo", 29.3));
		this.tablaOrdenada.add(new ParejaCartas("QQ", 239.0));
		this.tablaOrdenada.add(new ParejaCartas("QJs", 24.7));
		this.tablaOrdenada.add(new ParejaCartas("QTs", 21.9));
		this.tablaOrdenada.add(new ParejaCartas("Q9s", 16.2));
		this.tablaOrdenada.add(new ParejaCartas("Q8s", 13.3));
		this.tablaOrdenada.add(new ParejaCartas("Q7s", 11.3));
		this.tablaOrdenada.add(new ParejaCartas("Q6s", 10.9));
		this.tablaOrdenada.add(new ParejaCartas("Q5s", 10.1));
		this.tablaOrdenada.add(new ParejaCartas("Q4s", 9.4));
		this.tablaOrdenada.add(new ParejaCartas("Q3s", 8.8));
		this.tablaOrdenada.add(new ParejaCartas("Q2s", 8.3));

		this.tablaOrdenada.add(new ParejaCartas("AJo", 68.1));
		this.tablaOrdenada.add(new ParejaCartas("KJo", 25.4));
		this.tablaOrdenada.add(new ParejaCartas("QJo", 16.4));
		this.tablaOrdenada.add(new ParejaCartas("JJ", 159.0));
		this.tablaOrdenada.add(new ParejaCartas("JTs", 18));
		this.tablaOrdenada.add(new ParejaCartas("J9s", 12.8));
		this.tablaOrdenada.add(new ParejaCartas("J8s", 10.3));
		this.tablaOrdenada.add(new ParejaCartas("J7s", 8.5));
		this.tablaOrdenada.add(new ParejaCartas("J6s", 7.3));
		this.tablaOrdenada.add(new ParejaCartas("J5s", 7.0));
		this.tablaOrdenada.add(new ParejaCartas("J4s", 6.4));
		this.tablaOrdenada.add(new ParejaCartas("J3s", 6.0));
		this.tablaOrdenada.add(new ParejaCartas("J2s", 5.5));

		this.tablaOrdenada.add(new ParejaCartas("ATo", 53.1));
		this.tablaOrdenada.add(new ParejaCartas("KTo", 22.4));
		this.tablaOrdenada.add(new ParejaCartas("QTo", 14.8));
		this.tablaOrdenada.add(new ParejaCartas("JTo", 11.5));
		this.tablaOrdenada.add(new ParejaCartas("TT", 120.0));
		this.tablaOrdenada.add(new ParejaCartas("T9s", 11.2));
		this.tablaOrdenada.add(new ParejaCartas("T8s", 8.7));
		this.tablaOrdenada.add(new ParejaCartas("T7s", 7.0));
		this.tablaOrdenada.add(new ParejaCartas("T6s", 5.9));
		this.tablaOrdenada.add(new ParejaCartas("T5s", 4.9));
		this.tablaOrdenada.add(new ParejaCartas("T4s", 4.6));
		this.tablaOrdenada.add(new ParejaCartas("T3s", 4.2));
		this.tablaOrdenada.add(new ParejaCartas("T2s", 3.7));

		this.tablaOrdenada.add(new ParejaCartas("A9o", 40.8));
		this.tablaOrdenada.add(new ParejaCartas("K9o", 17.8));
		this.tablaOrdenada.add(new ParejaCartas("Q9o", 11.7));
		this.tablaOrdenada.add(new ParejaCartas("J9o", 8.8));
		this.tablaOrdenada.add(new ParejaCartas("T9o", 7.4));
		this.tablaOrdenada.add(new ParejaCartas("99", 95.7));
		this.tablaOrdenada.add(new ParejaCartas("98s", 7.6));
		this.tablaOrdenada.add(new ParejaCartas("97s", 6.1));
		this.tablaOrdenada.add(new ParejaCartas("96s", 5.0));
		this.tablaOrdenada.add(new ParejaCartas("95s", 4.1));
		this.tablaOrdenada.add(new ParejaCartas("94s", 3.2));
		this.tablaOrdenada.add(new ParejaCartas("93s", 3.0));
		this.tablaOrdenada.add(new ParejaCartas("92s", 2.6));

		this.tablaOrdenada.add(new ParejaCartas("A8o", 35.4));
		this.tablaOrdenada.add(new ParejaCartas("K8o", 15.2));
		this.tablaOrdenada.add(new ParejaCartas("Q8o", 9.9));
		this.tablaOrdenada.add(new ParejaCartas("J8o", 7.4));
		this.tablaOrdenada.add(new ParejaCartas("T8o", 6.0));
		this.tablaOrdenada.add(new ParejaCartas("98o", 5.1));
		this.tablaOrdenada.add(new ParejaCartas("88", 79.6));
		this.tablaOrdenada.add(new ParejaCartas("87s", 5.5));
		this.tablaOrdenada.add(new ParejaCartas("86s", 4.5));
		this.tablaOrdenada.add(new ParejaCartas("85s", 3.6));
		this.tablaOrdenada.add(new ParejaCartas("84s", 2.8));
		this.tablaOrdenada.add(new ParejaCartas("83s", 2.2));
		this.tablaOrdenada.add(new ParejaCartas("82s", 2.0));

		this.tablaOrdenada.add(new ParejaCartas("A7o", 31.3));
		this.tablaOrdenada.add(new ParejaCartas("K7o", 14.2));
		this.tablaOrdenada.add(new ParejaCartas("Q7o", 8.5));
		this.tablaOrdenada.add(new ParejaCartas("J7o", 6.3));
		this.tablaOrdenada.add(new ParejaCartas("T7o", 5.1));
		this.tablaOrdenada.add(new ParejaCartas("97o", 4.2));
		this.tablaOrdenada.add(new ParejaCartas("87o", 3.7));
		this.tablaOrdenada.add(new ParejaCartas("77", 67.4));
		this.tablaOrdenada.add(new ParejaCartas("76s", 4.1));
		this.tablaOrdenada.add(new ParejaCartas("75s", 3.2));
		this.tablaOrdenada.add(new ParejaCartas("74s", 2.5));
		this.tablaOrdenada.add(new ParejaCartas("73s", 2.0));
		this.tablaOrdenada.add(new ParejaCartas("72s", 1.6));

		this.tablaOrdenada.add(new ParejaCartas("A6o", 28.0));
		this.tablaOrdenada.add(new ParejaCartas("K6o", 13.3));
		this.tablaOrdenada.add(new ParejaCartas("Q6o", 8.1));
		this.tablaOrdenada.add(new ParejaCartas("J6o", 5.3));
		this.tablaOrdenada.add(new ParejaCartas("T6o", 4.2));
		this.tablaOrdenada.add(new ParejaCartas("96o", 3.5));
		this.tablaOrdenada.add(new ParejaCartas("86o", 3.0));
		this.tablaOrdenada.add(new ParejaCartas("76o", 2.7));
		this.tablaOrdenada.add(new ParejaCartas("66", 57.6));
		this.tablaOrdenada.add(new ParejaCartas("65s", 3.1));
		this.tablaOrdenada.add(new ParejaCartas("64s", 2.3));
		this.tablaOrdenada.add(new ParejaCartas("63s", 1.8));
		this.tablaOrdenada.add(new ParejaCartas("62s", 1.5));

		this.tablaOrdenada.add(new ParejaCartas("A5o", 28.2));
		this.tablaOrdenada.add(new ParejaCartas("K5o", 12.3));
		this.tablaOrdenada.add(new ParejaCartas("Q5o", 7.5));
		this.tablaOrdenada.add(new ParejaCartas("J5o", 5.0));
		this.tablaOrdenada.add(new ParejaCartas("T5o", 3.4));
		this.tablaOrdenada.add(new ParejaCartas("95o", 2.8));
		this.tablaOrdenada.add(new ParejaCartas("85o", 2.4));
		this.tablaOrdenada.add(new ParejaCartas("75o", 2.1));
		this.tablaOrdenada.add(new ParejaCartas("65o", 1.9));
		this.tablaOrdenada.add(new ParejaCartas("55", 49.3));
		this.tablaOrdenada.add(new ParejaCartas("54s", 2.4));
		this.tablaOrdenada.add(new ParejaCartas("53s", 1.9));
		this.tablaOrdenada.add(new ParejaCartas("52s", 1.5));

		this.tablaOrdenada.add(new ParejaCartas("A4o", 25.9));
		this.tablaOrdenada.add(new ParejaCartas("K4o", 11.4));
		this.tablaOrdenada.add(new ParejaCartas("Q4o", 6.8));
		this.tablaOrdenada.add(new ParejaCartas("J4o", 4.4));
		this.tablaOrdenada.add(new ParejaCartas("T4o", 3.1));
		this.tablaOrdenada.add(new ParejaCartas("94o", 2.1));
		this.tablaOrdenada.add(new ParejaCartas("84o", 1.8));
		this.tablaOrdenada.add(new ParejaCartas("74o", 1.6));
		this.tablaOrdenada.add(new ParejaCartas("64o", 1.5));
		this.tablaOrdenada.add(new ParejaCartas("54o", 1.6));
		this.tablaOrdenada.add(new ParejaCartas("44", 40.9));
		this.tablaOrdenada.add(new ParejaCartas("43s", 1.7));
		this.tablaOrdenada.add(new ParejaCartas("42s", 1.4));

		this.tablaOrdenada.add(new ParejaCartas("A3o", 24.2));
		this.tablaOrdenada.add(new ParejaCartas("K3o", 10.6));
		this.tablaOrdenada.add(new ParejaCartas("Q3o", 6.2));
		this.tablaOrdenada.add(new ParejaCartas("J3o", 3.9));
		this.tablaOrdenada.add(new ParejaCartas("T3o", 2.7));
		this.tablaOrdenada.add(new ParejaCartas("93o", 2.0));
		this.tablaOrdenada.add(new ParejaCartas("83o", 1.5));
		this.tablaOrdenada.add(new ParejaCartas("73o", 1.3));
		this.tablaOrdenada.add(new ParejaCartas("63o", 1.3));
		this.tablaOrdenada.add(new ParejaCartas("53o", 1.3));
		this.tablaOrdenada.add(new ParejaCartas("43o", 1.1));
		this.tablaOrdenada.add(new ParejaCartas("33", 32.7));
		this.tablaOrdenada.add(new ParejaCartas("32s", 1.2));

		this.tablaOrdenada.add(new ParejaCartas("A2o", 22.5));
		this.tablaOrdenada.add(new ParejaCartas("K2o", 10.0));
		this.tablaOrdenada.add(new ParejaCartas("Q2o", 5.6));
		this.tablaOrdenada.add(new ParejaCartas("J2o", 3.44));
		this.tablaOrdenada.add(new ParejaCartas("T2o", 2.4));
		this.tablaOrdenada.add(new ParejaCartas("92o", 1.8));
		this.tablaOrdenada.add(new ParejaCartas("82o", 1.4));
		this.tablaOrdenada.add(new ParejaCartas("72o", 1.1));
		this.tablaOrdenada.add(new ParejaCartas("62o", 1.0));
		this.tablaOrdenada.add(new ParejaCartas("52o", 1.0));
		this.tablaOrdenada.add(new ParejaCartas("42o", 0.9));
		this.tablaOrdenada.add(new ParejaCartas("32o", 0.9));
		this.tablaOrdenada.add(new ParejaCartas("22", 24.0));
	}
	
	public String devuelveCarta(int i){
		return this.tablaOrdenada.get(i).getCartas();
	}
}
