package modelo;

public class ParejaCartas {
	private String cartas;
	private double valor;
	
	public ParejaCartas (String s, double i){
		this.setCartas(s);
		this.setValor(i);
	}

	public String getCartas() {
		return cartas;
	}

	public void setCartas(String cartas) {
		this.cartas = cartas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
