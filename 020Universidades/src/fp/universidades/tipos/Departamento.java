package fp.universidades.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public record Departamento(String Nombre, Set<Profesor> Profesores,Set<Asignatura> Asignaturas) implements Comparable<Departamento> {
	public Departamento(String nombre) {
		this(nombre,new HashSet<Profesor>(),new HashSet<Asignatura>());
	}
	public void nuevoProfesor(Profesor p) {
		this.Profesores().add(p);
	}
	public void eliminaProfesor(Profesor p) {
		if(this.Profesores().contains(p)) {
			this.Profesores().remove(p);			
		}
	}
	public void nuevaAsignatura(Asignatura a) {
		this.Asignaturas().add(a);
	}
	public void eliminaAsignatura(Asignatura a) {
		if(this.Asignaturas().contains(a)){
			this.Asignaturas().remove(a);			
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(Nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(Nombre, other.Nombre);
	}
	
	public int compareTo(Departamento p) {
		int r = this.Nombre().compareTo(p.Nombre());
		return r;
	}
	public String toString() {
		return this.Nombre();
	}
	
	public void borraTutorias() {
		for(Profesor p:this.Profesores()) {
			p.borraTutorias();
		}
	}
	public void borraTutorias(TipoCategoria c) {
		for(Profesor p:this.Profesores()) {
			if(p.getCategoria() == c) {
				p.borraTutorias();				
			}
		}
	}
	
	public SortedMap<Asignatura,SortedSet<Profesor>> getProfesoresPorAsignatura(){
		SortedMap<Asignatura,SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();
		//this.Asignaturas.stream()
		for(Asignatura a: this.Asignaturas()) {
			SortedSet<Profesor> aux = new TreeSet<Profesor>();
			for(Profesor p: this.Profesores()) {
				if(p.getAsignaturas().contains(a)) {
					aux.add(p);
				}
			res.put(a, aux);
			}
		}
		return res;
	}
	
	public SortedMap<String, SortedSet<Tutoria>> getTutoriaPorProfesor(){
		return this.Profesores().stream().collect(Collectors.toMap(x->x.toString(),x->x.getTutorias(),(set1, set2) -> { set1.addAll(set2);return set1;},TreeMap::new));
	}
	
	
}
