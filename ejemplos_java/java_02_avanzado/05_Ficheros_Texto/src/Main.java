import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		/*try {
		leerFicheroTexto("/Users/miguelcampos/prueba.txt");
		} catch (FileNotFoundException e) {
			System.out.println("La ruta al fichero no es válida");
		}*/
		
		escribirFicheroTexto("/Users/miguelcampos/nuevo.txt");

	}

	private static void escribirFicheroTexto(String ruta) throws IOException {
		File nuevoFichero = new File(ruta);
		BufferedWriter bw;
		
		if(nuevoFichero.exists()) {
			System.out.println("El fichero de texto ya existía");
		} else {
			System.out.println("Se ha creado el nuevo fichero");
		}
		
		bw = new BufferedWriter(new FileWriter(nuevoFichero));
		bw.close();
		
	}

	private static void leerFicheroTexto(String ruta) throws FileNotFoundException, IOException {
		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		
		String lineaFichero;
		while((lineaFichero = b.readLine()) != null) {
			System.out.println(lineaFichero);
		}
		
	}
	
	

}
