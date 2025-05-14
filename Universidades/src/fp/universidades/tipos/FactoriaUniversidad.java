package fp.universidades.tipos;

import java.util.List;
import fp.utiles.Ficheros;

public class FactoriaUniversidad {
	private static Espacio creaEspacio(String s) {
		Espacio espacio = new Espacio(s);
		return espacio;
	}
	
	public static List<Espacio> leeEspacios(String fichero){
		List<String> listaFichero = leeFichero("Error leyendo el fichero de espacios",fichero);
		return null;
	}
}
