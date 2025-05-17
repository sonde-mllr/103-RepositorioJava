package fp.universidades.tipos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.utiles.Checkers;

public class Profesor extends Persona{
	private TipoCategoria categoria;
	private SortedSet<Tutoria> tutorias;
	private Map<Asignatura,Double> creditosAsignaturas;
	
	public TipoCategoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(TipoCategoria categoria) {
		this.categoria = categoria;
	}
	public SortedSet<Tutoria> getTutorias() {
		return tutorias;
	}
	public Profesor(String dNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			TipoCategoria categoria) {
		super(dNI, nombre, apellidos, fechaNacimiento, email);
		Checkers.check("Un profesor debe ser mayor de edad",LocalDate.now().getYear() - fechaNacimiento.getYear() >= 18);
		this.categoria = categoria;
		this.tutorias = new TreeSet<Tutoria>();
		this.creditosAsignaturas = new HashMap<Asignatura,Double>();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(categoria);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(getDNI(),other.getDNI()) && Objects.equals(getNombre(),other.getNombre()) && Objects.equals(getApellidos(),other.getApellidos());
	}

	public int compareTo(Profesor p) {
		int r = super.compareTo(p);
		return r;
	}
	
	public String toString() {
		return super.toString() + " ("+categoria+")";
	}
	
	public void nuevaTutoria(LocalTime hora,Integer duracion,DayOfWeek dia) {
		tutorias.add(new Tutoria(dia, hora, Duration.ofHours(duracion)));
	}
	
	public void borraTutoria(LocalTime hora,DayOfWeek dia) {
		tutorias.remove(tutorias.stream().filter(x->x.horaComienzo()== hora && x.dia()==dia).toArray()[0]);
	}
	public void borraTutorias() {
		tutorias.clear();
	}
	
	public List<Asignatura> getAsignaturas(){
		return this.creditosAsignaturas.keySet().stream().toList();
	}
	
	public List<Double> getCreditos() {
		return this.creditosAsignaturas.values().stream().toList();
	}
	
	public void imparteAsignatura(Asignatura a,Double c) {
		Checkers.check("La dedicación no puede ser 0 o menos", c > 0);
		Checkers.check("No puede superar el numero de creditos de la asignatura", a.Creditos() > c);
		Checkers.check("El total de creditos que imparte no puede superar 24", this.getCreditos().stream().mapToDouble(Double::doubleValue).sum() <= 24);
		this.creditosAsignaturas.put(a, c);
	}
	
	public void eliminaAsignatura(Asignatura a) {
		if(this.creditosAsignaturas.containsKey(a)) {
			this.creditosAsignaturas.remove(a);			
		}
	}
	
	public Double dedicacionAsignatura(Asignatura a) {
		if(!this.creditosAsignaturas.containsKey(a)) {
			return 0.0;
		}
		return this.creditosAsignaturas.get(a);
	}
	
	public Double getDedicacionTotal() {
		return this.creditosAsignaturas.entrySet().stream().map(x->x.getValue()).mapToDouble(Double::doubleValue).sum();
	}
	
}
