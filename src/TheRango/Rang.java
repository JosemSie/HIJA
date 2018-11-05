package TheRango;

import java.util.ArrayList;

public class Rang {
	
	private ArrayList<Cordenada> Yellow; 
	private String[] rangString;
	
	public Rang(String[] r ) {
		this.rangString = r;
		this.Yellow = new ArrayList<Cordenada>();
		generateYellow();
	}
	
	public Rang(int[][] t) {
		int n;
		this.Yellow = new ArrayList<Cordenada>();
		ArrayList<String> rangStringList = tabDiagToString(t);
		rangStringList.addAll(tabSwitedToString(t));
		rangStringList.addAll(tabOffSwitedToString(t));
		n = rangStringList.size();
		this.rangString = new String[n];
		for(int i = 0;i<n;i++) {
			this.rangString[i] = rangStringList.get(i); 
		}
	}
	
	private ArrayList<String> tabDiagToString(int[][] t){
		ArrayList<String> rangStringList = new ArrayList<String>();
		int diag=0;//0=salteadas, 1= rango, 2= diagonal plus
		int diagOrigen=0, diagFinal=0;
		for(int i=12;i>=0;i--) {
			if(t[i][i]==2) {
				this.Yellow.add(new Cordenada(i,i));
				if(i==12) {
					diag=2;
					diagOrigen=12;
					diagFinal=12;
				}
				else{
					if(diag==2 || diag==1){
						diagFinal = i;
					}
					else if (diag == 0) {
						diag = 1;
						diagOrigen = i;
						diagFinal = i;
					}
				}
			}
			if((t[i][i]!=2 || i==0) && diagOrigen!=-1){
				if(diag==2)//si era un rango que empezaba en el origen sera XX+
					rangStringList.add(numToString(diagFinal) + numToString(diagFinal) + "+");
				else if(diag==1){//si era un rango normal sera XX-YY
					if(diagOrigen!=diagFinal)
						rangStringList.add(numToString(diagOrigen) + numToString(diagOrigen) + "-" + 
									numToString(diagFinal) + numToString(diagFinal));
					else // si empieza y acaba en el mismo es una paraja suelta
						rangStringList.add(numToString(diagOrigen) + numToString(diagOrigen));
				}
				diag = 0;
				diagOrigen = -1;
			}			
		}
		return rangStringList;
	}
	
	private ArrayList<String> tabSwitedToString(int[][] t){
		ArrayList<String> rangStringList = new ArrayList<String>();
		int tipRan = 0;//0 = salteados, 1 = rango, 2 = rango +
		int pOrigen=-1, pFinal=-1;
		for(int i=0;i<13;i++) { 
			for(int j=i-1;j>=0;j--){
				if(t[i][j]==2) {
					this.Yellow.add(new Cordenada(i,j));//mirar
					if(i-1==j) {
						tipRan = 2;
						pOrigen = j;
						pFinal = j;
					}
					else if(tipRan!=0) {//si ya habia algun tipo de racha
						pFinal = j;
					}
					else{//si no habia ningun tipo de racha
						tipRan = 1;
						pOrigen = j;
						pFinal = j;
					}
				}
				
				if((t[i][j]!=2||j==0) && pOrigen!=-1){
					if(tipRan==2)//si era un rango que empezaba en la diagonal sera XX+
						rangStringList.add(numToString(i) + numToString(pFinal) + "s+");
					else if(tipRan==1){//si era un rango normal sera XX-YY 
						if(pOrigen!= pFinal)
							rangStringList.add(numToString(i) + numToString(pOrigen) + "s-" + 
									numToString(i) + numToString(pFinal) + "s");
						else // si empieza y acaba en el mismo es una paraja suelta
							rangStringList.add( numToString(i) + numToString(pOrigen) + "s");
					}
					tipRan = 0;
					pOrigen=-1;
				}
			}
			pOrigen=-1;
			pFinal=-1;
		}
		return rangStringList;
	}
	
	private ArrayList<String> tabOffSwitedToString(int[][] t){
		ArrayList<String> rangStringList = new ArrayList<String>();
		int tipRan = 0;//0 = salteados, 1 = rango, 2 = rango +
		int pOrigen=-1, pFinal=-1;
		for(int i=0;i<13;i++) { 
			for(int j=i-1;j>=0;j--){
				if(t[j][i]==2) {
					this.Yellow.add(new Cordenada(j,i));//mirar
					if(i-1==j) {
						tipRan = 2;
						pOrigen = j;
						pFinal = j;
					}
					else if(tipRan!=0) {//si ya habia algun tipo de racha
						pFinal = j;
					}
					else{//si no habia ningun tipo de racha
						tipRan = 1;
						pOrigen = j;
						pFinal = j;
					}
				}
				if((t[j][i]!=2 || j==0) && pOrigen!=-1){
					if(tipRan==2)//si era un rango que empezaba en el origen sera XX+
						rangStringList.add( numToString(i) + numToString(pFinal) + "o+");
					else if(tipRan==1){//si era un rango normal sera XX-YY 
						if(pOrigen!= pFinal)
							rangStringList.add(numToString(i) + numToString(pOrigen) + "o-" +
									 numToString(i) + numToString(pFinal) + "o");
						else // si empieza y acaba en el mismo es una paraja suelta
							rangStringList.add( numToString(i) + numToString(pOrigen) + "o");
					}
					tipRan = 0;
					pOrigen=-1;
				}
			}
			pOrigen=-1;
			pFinal=-1;
		}
		return rangStringList;
	}
	
	private void generateYellow() {
		int f, c, faux;
		char t, s;
		for(String a: rangString) {
			if(a.length()==2) {
				this.Yellow.add(new Cordenada(parseOne(a.charAt(0)),parseOne(a.charAt(1))));
			}
			else if (a.length()==3) {
				f = parseOne(a.charAt(1));
				c = parseOne(a.charAt(0));
				t = a.charAt(2);
				if(t=='+') {
					if(c==f){
							for(int i=c;i<13;i++){
								this.Yellow.add(new Cordenada(i,i));
							}
					}
				}
				else if(t=='o'){//mitad inferiror
					this.Yellow.add(new Cordenada(f,c));
				}
				else if(t=='s') {//mitad superior
					this.Yellow.add(new Cordenada(c,f));
				}
				
				
			}
			else if(a.length()==4) {
				c = parseOne(a.charAt(0));
				f = parseOne(a.charAt(1));
				t = a.charAt(2);
				s = a.charAt(3);
				if(t=='o'){//mitad inferiror
						for(int j=f;j<c;j++){
							this.Yellow.add(new Cordenada(j,c));
						}
				}
				else if(t=='s') {//mitad superior
						for(int j=f;j<c;j++){
							this.Yellow.add(new Cordenada(c,j));
						}
				}
				
			}
			else {//rango
				c = parseOne(a.charAt(0));
				f = parseOne(a.charAt(1));
				t = a.charAt(2);
				faux = parseOne(a.charAt(5));
				if(t=='o')
					while(faux<=f) {
						this.Yellow.add(new Cordenada(faux, c));
						faux++;
					}
				else if(t=='s')
					while(faux<=f) {
						this.Yellow.add(new Cordenada(c, faux));
						faux++;
					}
			}
		}
	}
	
	public int parseOne(char s) {
		int ret;
		switch(s) {
		case 'A':
			ret = 12;
			break;
		case 'K':
			ret = 11;
			break;
		case 'Q':
			ret = 10;
			break;
		case 'J':
			ret = 9;
			break;
		case 'T':
			ret = 8;
			break;
		default: 
			ret = Character.getNumericValue(s)-2;
			break;
		}
		return ret;
	}
	
	public String numToString(int n) {
		int aux = n+2;
		String ret;
		switch(n) {
		case 12:
			ret = "A";
			break;
		case 11:
			ret = "K";
			break;
		case 10:
			ret = "Q";
			break;
		case 9:
			ret = "J";
			break;
		case 8:
			ret = "T";
			break;
		default: 
			ret = "" + aux;
			break;
		}
		return ret;
	}
	
	public ArrayList<Cordenada> getYellow(){
		return this.Yellow;
	}
	
	public String toString() {
		String ret="";
		for(int i=0; i<this.rangString.length; i++) {
			if(i!=0)
				ret +=", ";	
			ret += this.rangString[i];
		}
		return ret;
	}
}
