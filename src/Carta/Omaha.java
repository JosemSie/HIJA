package Carta;

import java.io.IOException;
import java.util.ArrayList;

public class Omaha {
	
	private String propias;
	private String comunes;
	
	String outOmaha;
	
	public Omaha (String p, String c) throws IOException {
		propias = p;
		comunes = c;
		outOmaha="";
		
		mejorOmaha();
	}
	
	public void mejorOmaha() throws IOException {
		ArrayList<String> arraylistaManos = new ArrayList<String>();
		ListaMejoresManos listaManos;
		
		int psize =this.propias.length()/2, csize =this.comunes.length()/2;
		for(int pi=0; pi<psize-1; pi++)
			for(int pj=pi+1; pj<psize;pj++) {
				
				for(int ci=0;ci<csize-2;ci++)
					for(int cj=ci+1;cj<csize-1;cj++)
						for(int ck=cj+1;ck<csize;ck++){
							
							arraylistaManos.add(propias.substring(pi*2,pi*2 + 2)+propias.substring(pj*2,pj*2 + 2)+
									comunes.substring(ci*2, ci*2 + 2)+comunes.substring(cj*2, cj*2 + 2)+comunes.substring(ck*2, ck*2 + 2));
							
						}
				
			}
		//String[] arrayManos = new String[arraylistaManos.size()];
		//arrayManos= (String[]) arraylistaManos.toArray();
		listaManos = new ListaMejoresManos(arraylistaManos.toArray(new String[0]));
		this.outOmaha= listaManos.getLista().get(0).getResultado();
		
		System.out.println(this.outOmaha);
				
	}

	public String getResultado() {
		return this.outOmaha;
	}
}
