package modelo.utilidades;

public class Cordenada {
	
	private int fila;	
	private int columna;

	
	public Cordenada(int f, int c){
		this.fila = f;
		this.columna = c;
	}
	
	public void setFila(int f) {
		this.fila=f;
	}
	
	public void setColumna(int c) {
		this.columna=c;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}
}
