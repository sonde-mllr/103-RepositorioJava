package fp.universidades.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Despacho extends Espacio{


	private Set<Profesor> profesores;

	public Despacho(String nombre, Integer capacidad,Set<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad);
		this.profesores = profesores;
		// TODO Auto-generated constructor stub
	}
	
	public Despacho(String nombre,Integer capacidad,Profesor profesor) {
		super(TipoEspacio.OTRO,nombre,capacidad);
		this.profesores = Set.of(profesor);
	}
	
	public Despacho(String nombre,Integer capacidad) {
		super(TipoEspacio.OTRO,nombre,capacidad);
		this.profesores= new HashSet<>();
	}
	
	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		Checkers.check("El numero de profesores no puede superar la capacidad del despacho",profesores.size() < getCapacidad());
		this.profesores = profesores;
	}
	
	@Override
	public void setEspacio(TipoEspacio espacio){
		throw new UnsupportedOperationException("No se puede cambiar el tipo, debe ser 'otro tipo");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(profesores);
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
		Despacho other = (Despacho) obj;
		return Objects.equals(getNombre(), other.getNombre()) && Objects.equals(getPlanta().charAt(8), other.getPlanta().charAt(8));
	}
	
	public int compareTo(Despacho d) {
		int r = super.compareTo(d);
		return r;
	}
	
	public String toString() {
		return super.toString() + " " + profesores.toString();
	}
	
}
