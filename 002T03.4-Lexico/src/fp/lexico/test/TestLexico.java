package fp.lexico.test;

import java.nio.charset.StandardCharsets;
import java.util.Set;

import fp.lexico.LectorTexto;
import fp.lexico.Lexico;

public class TestLexico {

	public static void main(String[] args) {
		LectorTexto lector1 = new LectorTexto();
		lector1.agregaFichero("./res/lazarillo.txt", StandardCharsets.UTF_8);
		System.out.println("LECTOR 1");
		System.out.println(lector1.getPalabras().subList(0, 100));
	
		LectorTexto lector2 = new LectorTexto();
		System.out.println("LECTOR 2");
		lector2.agregaFichero("./res/platero.txt", StandardCharsets.UTF_8);
		System.out.println(lector2.getPalabras().subList(0,100));
		
		//TODO Probar aqu� el tipo Lexico
		Lexico l1 = new Lexico(lector1.getPalabras());
		Lexico l2 = new Lexico(lector2.getPalabras());
		
		System.out.println(l1.getDiferenciaPalabras(l2));
		System.out.println(l1.getPalabrasComunes(l2));
		System.out.println(l1.getTodasPalabras(l2));
		
	}

}
