package Carta;

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
}
