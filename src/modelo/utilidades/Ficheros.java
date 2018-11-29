package modelo.utilidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheros {
	private FileWriter fx;
	private FileReader f;
	private BufferedReader b;
	public Ficheros(String entrada, String salida) throws IOException {
		fx = new FileWriter(salida);
		f = new FileReader(entrada);
		b = new BufferedReader(f);
		
	}
	public void cerrarFicheros() throws IOException {
		 fx.close();
		 b.close();
	}
	public void escrituraFichero(String texto) throws IOException {
        fx.write(texto);
    }
	public String lecturaFichero() throws FileNotFoundException, IOException {
		return b.readLine();  
    }
}
