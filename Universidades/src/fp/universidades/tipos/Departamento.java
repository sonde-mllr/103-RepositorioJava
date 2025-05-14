package fp.universidades.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
}
