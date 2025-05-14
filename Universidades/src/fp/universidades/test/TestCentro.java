package fp.universidades.test;

import java.time.LocalDate;
import java.util.Set;

import fp.universidades.tipos.Centro;
import fp.universidades.tipos.Despacho;
import fp.universidades.tipos.Espacio;
import fp.universidades.tipos.Profesor;
import fp.universidades.tipos.TipoCategoria;
import fp.universidades.tipos.TipoEspacio;

public class TestCentro {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Centro c1 = new Centro("Etsii", "Reina mercedes", 5, 5);
		Espacio e1 = new Espacio(TipoEspacio.OTRO,"A1.30",30 );
		Espacio e2 = new Espacio(TipoEspacio.LABORATORIO,"B2.10",10 );
		Espacio e3 = new Espacio(TipoEspacio.OTRO,"B1.3",1 );
		Profesor p1 = new Profesor("45973397P", "ale", "martinez",LocalDate.of(2005, 2, 9), "c8534312@gmail.com", TipoCategoria.TITULAR);
		Profesor p2 = new Profesor("12384128S", "jesus", "jaén",LocalDate.of(2004, 4, 13), "jjaeper@gmail.com", TipoCategoria.TITULAR);
		Profesor p3 = new Profesor("12312387D", "olivia", "bautista",LocalDate.of(2005, 3, 2), "obaubau@gmail.com", TipoCategoria.TITULAR);
		Despacho d1 = new Despacho("Despacho1", 3, Set.of(p1,p2,p3));
		c1.nuevoEspacio(e1);
		c1.nuevoEspacio(e2);
		c1.nuevoEspacio(e3);
		c1.nuevoEspacio(e3);
		c1.nuevoEspacio(d1);
		System.out.println(c1);
		System.out.println(c1.getEspacios());
		System.out.println(c1.getEspacioMayorCapacidad());
		System.out.println(c1.getDespachos());
	}

}
