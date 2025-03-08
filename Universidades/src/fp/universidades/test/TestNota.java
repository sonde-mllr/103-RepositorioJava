package fp.universidades.test;

import fp.universidades.tipos.Asignatura;
import fp.universidades.tipos.Nota;
import fp.universidades.tipos.TipoAsignatura;
import fp.universidades.tipos.TipoConvocatoria;

public class TestNota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asignatura r = new Asignatura("Fundamentos de Programacion", "0000230",12.,TipoAsignatura.ANUAL, 1);
		Nota nota = new Nota(r,"2014-15", TipoConvocatoria.PRIMERA,.3,false);
		System.out.println(nota);
		Nota nota2 = new Nota(r,"2014-15", TipoConvocatoria.PRIMERA,9.3);
		System.out.println(nota2);


	}

}
