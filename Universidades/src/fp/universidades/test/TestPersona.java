package fp.universidades.test;

import java.time.LocalDate;

import fp.universidades.tipos.Persona;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("45974497E","Alejandro","Martínez González",LocalDate.of(2005, 2, 9),"c8534312@gmail.com");
		Persona p2 = new Persona("45974497E","Alejandro","Martínez González",LocalDate.of(2005, 2, 9));
		System.out.println(p1);
		System.out.println(p1.getEdad());
		System.out.println(p1.getEmail());
		System.out.println(p2);
		System.out.println(p2.getEmail());
		Persona p3 = new Persona("45974497E","Alejandro","Martínez González",LocalDate.of(2005, 2, 9));
	}

}
