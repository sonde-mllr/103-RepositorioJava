package fp.universidades.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class Grado implements Comparable<Grado> {
	private String nombre;
	private Set<Asignatura> obligatorias;
	private Set<Asignatura> optativas;
	private Double minCreditosOpt;
	//private Integer totalCreditos; -> Creditos deasignaturas obligatorias + minCreditosOpt
	
	public String toString() {
		return nombre;
	}
	public Grado(String nombre, Set<Asignatura> obligatorias, Set<Asignatura> optativas,Double minCreditosOpt) {
		super();
		this.nombre = nombre;
		this.obligatorias = obligatorias;
		//TODO
		//Checkers.check("Todas las asignaturas optativas deben tener el mismo numero de creditos",optativas.stream().allMatch(x->x.Creditos()));
		
		Checkers.check("Todas las optativas deben tener los mismos créditos",
				optativas.stream().allMatch(x->Objects.equals(x.Creditos(),optativas.iterator().next().Creditos())));
		this.optativas = optativas;
		Checkers.check("El número de creditos opt entre 0 y total creditos de opt",
				minCreditosOpt > 0 && minCreditosOpt <= optativas.stream().mapToDouble(x->x.Creditos()).sum());
		this.minCreditosOpt = minCreditosOpt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grado other = (Grado) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Grado c) {
		int r = nombre.compareTo(c.nombre);
		return r;
	}
	
	public Double getTotalCreditos() {
		return minCreditosOpt+obligatorias.stream().mapToDouble(x->x.Creditos()).sum();
	}
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		asignaturas.addAll(getObligatorias());
		asignaturas.addAll(getOptativas());
		return asignaturas.stream().filter(x->x.curso() == curso).collect(Collectors.toSet());
	}
	public Asignatura getAsignatura(String codigo) {
		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		asignaturas.addAll(getObligatorias());
		asignaturas.addAll(getOptativas());
		Asignatura res = asignaturas.stream().filter(x->x.Codigo().equals(codigo)).findFirst().orElse(null);
		return res;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Set<Asignatura> getObligatorias() {
		return obligatorias;
	}
	public Set<Asignatura> getOptativas() {
		return optativas;
	}
	public Double getMinCreditosOpt() {
		return minCreditosOpt;
	}
	
	
}
