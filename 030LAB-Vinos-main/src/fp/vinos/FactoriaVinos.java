package fp.vinos;

import java.util.ArrayList;
import java.util.List;

import fp.utiles.Ficheros;


public class FactoriaVinos {
	private static Vino parsearVino(String linea) {
		String[] s1 = linea.split(",");
		String pais = s1[0].strip();
		String region = s1[1].strip();
		Integer puntos = Integer.valueOf(s1[2].strip());
		Double precio = Double.valueOf(s1[3].strip());
		String uva = s1[4].strip();
		return new Vino(pais,region,puntos,precio,uva);		
	}
	
	public static VinotecaStream leerVinoteca(String fichero) {
		List<Vino> res = new ArrayList<Vino>();
		List<String> lineas = Ficheros.leeLineas(fichero);
		lineas.remove(0);
		for(String linea:lineas) {
			res.add(parsearVino(linea));
		}
		return new VinotecaStream(res);
	}
}
