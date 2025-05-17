package fp.universidades.test;

import fp.universidades.tipos.Espacio;
import fp.universidades.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Espacio e1 = new Espacio(TipoEspacio.TEORIA,"A3.10",100);
		System.out.println(e1);
		System.out.println(e1.getPlantaINT());
		Espacio e2 = new Espacio("A0.10,0,100,TEORIA");
		System.out.println(e2);
		System.out.println(e2.getCapacidad());
	}

}
