package TheRango;

import java.util.ArrayList;

public class Tablero {
	private int[][] tablero;
	private Rang rang; 
	
	public Tablero(Rang r) {//0 = gris, 1 = rojo, 2 = amarillo, 3 = verde
		this.rang  = r;
		this.tablero = new int[][] {{3,0,0,0,0,0,0,0,0,0,0,0,0},
									{0,3,0,0,0,0,0,0,0,0,0,0,0},
									{0,0,3,0,0,0,0,0,0,0,0,0,0},
									{0,0,0,3,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,3,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,3,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,3,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,3,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,3,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,3,0,0,0},
									{0,0,0,0,0,0,0,0,0,0,3,0,0},
									{0,0,0,0,0,0,0,0,0,0,0,3,0},
									{0,0,0,0,0,0,0,0,0,0,0,0,3}};
		RangToTab();
	}
	
	public void RangToTab() {
		ArrayList<Cordenada> y = this.rang.getYellow();
		for(Cordenada xy : y) {
			setColor(xy.getFila(), xy.getColumna(), 2);
		}
	}
	
	public void clean() {
		//this.rang= new Rang(new String[0]);
		this.tablero = new int[][] {{3,0,0,0,0,0,0,0,0,0,0,0,0},
									{0,3,0,0,0,0,0,0,0,0,0,0,0},
									{0,0,3,0,0,0,0,0,0,0,0,0,0},
									{0,0,0,3,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,3,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,3,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,3,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,3,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,3,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,3,0,0,0},
									{0,0,0,0,0,0,0,0,0,0,3,0,0},
									{0,0,0,0,0,0,0,0,0,0,0,3,0},
									{0,0,0,0,0,0,0,0,0,0,0,0,3}};
		
	}
	
	public void tabToRang() {
		this.rang = new Rang(this.tablero);
	}
	
	public void setColor(int f, int c, int color) {
		this.tablero[f][c]=color;
	}
	
	public int getCol(int f, int c, int color) {
		return this.tablero[f][c];
	}
	
	public void selectCord(int f, int c) {
		if(this.tablero[f][c]!=2)
			this.tablero[f][c]=2;
		else if(f!=c)
			this.tablero[f][c]=0;
		else
			this.tablero[f][c]=3;
		
		this.tabToRang();
	}
	
	public String toString() {
		String text = "";
		for(int i=12;i>=0;i--) {
			for(int j=12;j>=0;j--) {
				text += " " + this.tablero[i][j];
			}
			text += System.lineSeparator();
		}
		text += System.lineSeparator() + this.rang.toString() +  System.lineSeparator();
		return text;
	}
}
