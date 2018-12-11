package modelo.utilidades;

import modelo.Carta;

public class Conversor {
	public Conversor(){
	}
	
	public int charAValor (char v){
		int aux;
		switch (v){
			case '2':
				aux = 2;
			break;
			case '3':
				aux = 3;
			break;
			case '4':
				aux = 4;
			break;
			case '5':
				aux = 5;
			break;
			case '6':
				aux = 6;
			break;
			case '7':
				aux = 7;
			break;
			case '8':
				aux = 8;
			break;
			case '9':
				aux = 9;
			break;
			case 'T':
				aux = 10;
			break;
			case 'J':
				aux = 11;
			break;
			case 'Q':
				aux = 12;
			break;
			case 'K':
				aux = 13;
			break;
			case 'A':
				aux = 14;
			break;
			default:
				aux = 0;
			break;
		}
		
		return aux;
	}
	//Este metodo mostramos el valor de la carta (con t, j, q, j, a). Si error devuelve '\n'
	public char getValorCarta(int valor){
			char aux;
			switch (valor){
			case 1:
				aux = 'A';
			break;
			case 2:
				aux = '2';
			break;
			case 3:
				aux = '3';
			break;
			case 4:
				aux = '4';
			break;
			case 5:
				aux = '5';
			break;
			case 6:
				aux = '6';
			break;
			case 7:
				aux = '7';
			break;
			case 8:
				aux = '8';
			break;
			case 9:
				aux = '9';
			break;
			case 10:
				aux = 'T';
			break;
			case 11:
				aux = 'J';
			break;
			case 12:
				aux = 'Q';
			break;
			case 13:
				aux = 'K';
			break;
			case 14:
				aux = 'A';
			break;
			default:
				aux = '\n';
			break;
			}
			return aux;
	}
	public int stringAValor (String v){
		int aux;
		switch (v){
			case "2":
				aux = 2;
			break;
			case "3":
				aux = 3;
			break;
			case "4":
				aux = 4;
			break;
			case "5":
				aux = 5;
			break;
			case "6":
				aux = 6;
			break;
			case "7":
				aux = 7;
			break;
			case "8":
				aux = 8;
			break;
			case "9":
				aux = 9;
			break;
			case "T":
				aux = 10;
			break;
			case "J":
				aux = 11;
			break;
			case "Q":
				aux = 12;
			break;
			case "K":
				aux = 13;
			break;
			case "A":
				aux = 14;
			break;
			default:
				aux = 0;
			break;
		}
		
		return aux;
	}
	public char intAPalo(int palo) {
		switch (palo){
			case 0: return 'h';
			case 1: return 'd';
			case 2: return 'c';
			case 3: return 's';
		}
		return '\n';
	}
	
	public int paloAInt(char palo) {
		switch (palo){
			case 'h': return 0;
			case 'd': return 1;
			case 'c': return 2;
			case 's': return 3;
		}
		return 0;
	}
	public String cartaParaFichero (Carta c){
		String nombre = "";
		String carta;
		String palo;
		
		switch (c.getValor()){
			case 1: carta="ace_of"; break;
			case 2: carta="2_of"; break;
			case 3: carta="3_of"; break;
			case 4: carta="4_of"; break;
			case 5: carta="5_of"; break;
			case 6: carta="6_of"; break;
			case 7: carta="7_of"; break;
			case 8: carta="8_of"; break;
			case 9: carta="9_of"; break;
			case 10: carta="10_of"; break;
			case 11: carta="jack_of"; break;
			case 12: carta="queen_of"; break;
			case 13: carta="king_of"; break;
			case 14: carta="ace_of"; break;
			default: carta="NoCard"; break;
		}
		switch (c.getPalo()){
		case 1: palo="_hearts"; break;
		case 2: palo="_diamonds"; break;
		case 3: palo="_clubs"; break;
		case 4: palo="_spades"; break;
		default: palo=""; break;
		}
		nombre = carta + palo;
		return nombre;
	}
}
