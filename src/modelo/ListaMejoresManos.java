package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class ListaMejoresManos {
	
	ArrayList<MejorMano> lista;

	public ListaMejoresManos(String[] manos) throws IOException {
		lista = new ArrayList<MejorMano>(manos.length);
		for(int i=0;i<manos.length;i++) {
			lista.add(new MejorMano(manos[i]));
			lista.get(i).setNombreJugador("J" + (i+1));
		}
		lista.sort(new Comparator<MejorMano>() {
			@Override
			public int compare(MejorMano mano1, MejorMano mano2){
				if (mano1.getRank() > mano2.getRank()){
					return -1;
				}
				else if (mano1.getRank() < mano2.getRank()){
					return 1;
				}
				else{//Si son iguales debemos mirar las cartas con cuidado
					int pos = 0;
					Carta aux1 = mano1.getMejorMano().getCarta(pos);
					Carta aux2 = mano2.getMejorMano().getCarta(pos);
					if (aux1.getValor() > aux2.getValor()){
						return -1;
					}
					else if (aux1.getValor() < aux2.getValor()){
						return 1;
					}
					else{ 
						//Si es dobles parejas o full, hay que mirar la segunda carta implicada
						//Como se muestra primero la pareja tenemos que mirar la tercera carta directamente (posicion 2)
						if (mano1.getRank() == 2 || mano1.getRank() == 6){
							pos = 2;
							aux1 = mano1.getMejorMano().getCarta(pos);
							aux2 = mano2.getMejorMano().getCarta(pos);
							if (aux1.getValor() > aux2.getValor()){
								return -1;
							}
							else if (aux1.getValor() < aux2.getValor()){
								return 1;
							}
							else {//Si son dobles parejas, hay que mirar la �ltima carta para ver si es mas alta
								if (mano1.getRank() == 2){
									pos++;//para mirar la ultima carta hay que avanzar la posicion
									aux1 = mano1.getMejorMano().getCarta(pos);
									aux2 = mano2.getMejorMano().getCarta(pos);
									if (aux1.getValor() > aux2.getValor()){
										return -1;
									}
									else if (aux1.getValor() < aux2.getValor()){
										return 1;
									}
									else{
										return 0;
									}
								}
								else{//Si es full se ha llegado hasta el final, es el mismo por lo que son iguales
									return 1;
								}
							}
						}
						//Ponemos pos + 1 porque tenemos que mirar a partir de la siguiente carta
						//Si son la misma carta, hay que ir mirando todas hasta llegar al final, si llegamos al final es 
						//porque son iguales.
						for (int i = pos + 1; i < mano1.getMejorMano().getSize(); i++){
							aux1 = mano1.getMejorMano().getCarta(i);
							aux2 = mano2.getMejorMano().getCarta(i);
							if (aux1.getValor() > aux2.getValor()){
								return -1;
							}
							else if (aux1.getValor() < aux2.getValor()){
								return 1;
							}
						}
						return 1;//Si llega aqui es porque Ha mirado todas las cartas y tienen las mismas
					}

					
				}
			}
			
		});
		getGanador();
	}
	
	public ArrayList<MejorMano> getLista(){
		return this.lista;
	}
	
	public int getGanador() {
		String ganador = this.lista.get(0).getNombreJugador();
		return Integer.parseInt(ganador.substring(1, ganador.length()))-1;
	}
}
