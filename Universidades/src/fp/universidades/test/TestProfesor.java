package fp.universidades.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidades.tipos.Profesor;
import fp.universidades.tipos.TipoCategoria;

public class TestProfesor {
	public static void main(String[] args) {
		Profesor p1 = new Profesor("45973397P", "ale", "martinez",LocalDate.of(2005, 2, 9), "c8534312@gmail.com", TipoCategoria.TITULAR);
		System.out.println(p1);
		p1.nuevaTutoria(LocalTime.now(),3, DayOfWeek.MONDAY);
		p1.nuevaTutoria(LocalTime.now(),3, DayOfWeek.FRIDAY);
		p1.nuevaTutoria(LocalTime.now(),3, DayOfWeek.THURSDAY);
		p1.nuevaTutoria(LocalTime.now(),3, DayOfWeek.MONDAY);
		System.out.println(p1.getTutorias());
	}
}
