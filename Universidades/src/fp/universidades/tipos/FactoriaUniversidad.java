package fp.universidades.tipos;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import fp.utiles.Ficheros;

public class FactoriaUniversidad {
	
	private static Espacio creaEspacio(String s) {
		Espacio espacio = new Espacio(s);
		return espacio;
	}
	
	public static List<Espacio> leeEspacios(String fichero){
		List<Espacio> ListaEspacios = new ArrayList<>();
		List<String> listaFichero = Ficheros.leeFichero("Error leyendo el fichero de espacios",fichero);
		for(String StringEspacio : listaFichero) {
			ListaEspacios.add(creaEspacio(StringEspacio));
		}
		return ListaEspacios;
	}
	
	private static Despacho creaDespacho(String s) {
		Despacho despacho = new Despacho(s);
		return despacho;
	}
	
	public static List<Despacho> leeDespachos(String fichero){
		List<Despacho> ListaDespachos = new ArrayList<>();
		List<String> listaFichero = Ficheros.leeFichero("Error leyendo el fichero de despachos",fichero);
		for(String StringDespacho : listaFichero) {
			ListaDespachos.add(creaDespacho(StringDespacho));
		}
		return ListaDespachos;
	}
	
	private static Alumno creaAlumno(String s) {
		String[] s1 = s.split(",");
		String dni = s1[0].strip();
		String nombre = s1[1].strip();
		String apellidos = s1[2].strip();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(s1[3].strip(),formatter);
		String email = s1[4].strip();
		Alumno a = new Alumno(dni,nombre,apellidos,fechaNacimiento,email);
		return a;
	}
	
	public static List<Alumno> leeAlumnos(String fichero){
		List<Alumno> ListaAlumnos = new ArrayList<>();
		List<String> listaFichero = Ficheros.leeFichero("Error leyendo el fichero de alumnos",fichero);
	    for (int i = 1; i < listaFichero.size(); i++) {
	        String stringAlumno = listaFichero.get(i);
			ListaAlumnos.add(creaAlumno(stringAlumno));
		}
		return ListaAlumnos;

	}
	
	private static Asignatura creaAsignatura(String s) {
		String[]s1 = s.split("#");
		String nombre = s1[0].strip();
		String codigo = s1[1].strip();
		Double creds = Double.valueOf(s1[2].strip());
		TipoAsignatura tipoA = TipoAsignatura.valueOf(s1[3].strip());
		Integer curso = Integer.valueOf(s1[4].strip());
		return new Asignatura(nombre, codigo, creds, tipoA,curso);
		
	}
	
	public static List<Asignatura> leeAsignatura(String fichero){
		List<Asignatura> ListaAsignaturas = new ArrayList<>();
		List<String> listaFichero = Ficheros.leeFichero("Error leyendo el fichero de asignaturas",fichero);
		for(String StringAsignatura : listaFichero) {
			ListaAsignaturas.add(creaAsignatura(StringAsignatura));
		}
		return ListaAsignaturas;
	}
	
	private static Nota creaNota(String s) {
		String[]st = s.split(",");
		Asignatura a = creaAsignatura(st[0]);
		Integer curso = Integer.valueOf(st[1].strip());
		TipoConvocatoria tipoC = TipoConvocatoria.valueOf(st[2].strip());
		Double valor = Double.valueOf(st[3].strip());
		Boolean honor = Boolean.valueOf(st[4].strip());
		return new Nota(a,curso,tipoC,valor,honor);
	}
	
	public static List<Nota> leeNotas(String fichero){
		List<Nota> ListaNotas = new ArrayList<Nota>();
		List<String> listaFichero = Ficheros.leeFichero("Error leyendo el fichero de asignaturas",fichero);
		for(String StringNota : listaFichero) {
			ListaNotas.add(creaNota(StringNota));
		}
		return ListaNotas;
	}
}
