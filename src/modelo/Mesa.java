package modelo;

import java.util.ArrayList;

public class Mesa {
	private ArrayList<Carta> cartas;
	
	public Mesa() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void addCarta(Carta carta) {
		if(cartas.size()<5) cartas.add(carta);
	}
	
	public boolean haySuficientesCartas() {
		return cartas.size()>2 || cartas.size()==0;
	}
	
	public String getCartas() {
		String res = "";
		for(int i=0;i<cartas.size();i++) res+=cartas.get(i).toString();
		return res;
	}

	public int getNumCartasPorSalir() {
		return 5-cartas.size();
	}
}
