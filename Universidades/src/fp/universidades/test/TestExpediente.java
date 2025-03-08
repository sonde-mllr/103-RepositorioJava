package fp.universidades.test;

import fp.universidades.tipos.Asignatura;
import fp.universidades.tipos.Expediente;
import fp.universidades.tipos.Nota;
import fp.universidades.tipos.TipoAsignatura;
import fp.universidades.tipos.TipoConvocatoria;

public class TestExpediente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "0000230",12.,TipoAsignatura.ANUAL, 1);
		Nota n1 = new Nota(a1,"2014-15", TipoConvocatoria.PRIMERA,1.3,false);
		System.out.println("Nota 1" + n1);
		Nota n2 = new Nota(a1,"2014-15", TipoConvocatoria.SEGUNDA,2.3,false);
		System.out.println("Nota 2" + n2);
		Nota n3 = new Nota(a1,"2014-15", TipoConvocatoria.TERCERA,3.3,false);
		System.out.println("Nota 3" + n3);
		
		Expediente e1 = new Expediente();
		e1.nuevaNota(n1);
		System.out.println("E1 + n1 " + e1);
		e1.nuevaNota(n2);
		System.out.println("E1 + n2 " + e1);
		e1.nuevaNota(n3);
		System.out.println("E1 + n3 " + e1);
		
		Nota n4 = new Nota(a1,"2014-15", TipoConvocatoria.PRIMERA,5.3,false);
		e1.nuevaNota(n4);
		System.out.println("Nota 4" + n4);
		System.out.println("E1 + n4 == n1 " + e1);
		
		
	}

}
