package fp.universidades.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidades.tipos.Asignatura;
import fp.universidades.tipos.Profesor;
import fp.universidades.tipos.TipoAsignatura;
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
		
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "0000230",12.,TipoAsignatura.ANUAL, 1);
		//Asignatura a2 = new Asignatura("Tecnología de computadores", "0000340",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		Asignatura a3 = new Asignatura("Matematicas discretas", "0000310",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		//Asignatura a4 = new Asignatura("Administracion de empresas", "0000210",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura a5 = new Asignatura("Arquitectura de computadores", "0000350",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		Asignatura a6 = new Asignatura("ISSI", "0000300",12.,TipoAsignatura.ANUAL, 2);
		
		p1.imparteAsignatura(a1, 8.);
		p1.imparteAsignatura(a3, 3.);
		p1.imparteAsignatura(a5, 5.);
		System.out.println(p1.getAsignaturas());
		System.out.println(p1.getCreditos());
		p1.eliminaAsignatura(a3);
		p1.eliminaAsignatura(a6);
		System.out.println(p1.getAsignaturas());
		System.out.println(p1.dedicacionAsignatura(a1));
		System.out.println(p1.dedicacionAsignatura(a3));
		System.out.println(p1.getDedicacionTotal());

	}
}
