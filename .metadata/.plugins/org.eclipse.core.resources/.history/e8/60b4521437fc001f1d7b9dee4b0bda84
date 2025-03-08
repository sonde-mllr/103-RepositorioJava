package fp.universidades.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

/*
 * 	private Asignatura asignatura;
	private String curso;
	private TipoConvocatoria convo;
	private Double valor;
	private Boolean honor;
 * */

public record Nota(Asignatura Asignatura,String Curso, TipoConvocatoria Convo, Double Valor, Boolean Honor) {
	
	public Nota{
		Checkers.check("Nota no válida", Valor >= 0. && Valor <= 10.);
		if (Honor) {			
			Checkers.check("No se puede tener matricula si la nota es menor a 9", Valor >= 9.);
		}
	}
	public Nota(Asignatura asignatura,String curso,TipoConvocatoria convo,Double valor){
		this(asignatura,curso,convo,valor,false);
		Checkers.check("Nota no válida", valor >= 0. && valor <= 10.);
	}
	
	public TipoNota getCalificacion() {
		Double valor = Valor;
		TipoNota calificacion = TipoNota.SUSPENSO;
		if( 5.<= valor && valor < 7.) {
			calificacion = TipoNota.APROBADO;
		} else if(7. <= valor && valor < 9.) {
			calificacion = TipoNota.NOTABLE;
		} else if(valor >= 9.) {
			calificacion = TipoNota.SOBRESALIENTE;
		} else if(valor >= 9. && Honor) {
			calificacion = TipoNota.MATRICULA;
		}
		return calificacion;
	}
	
	public String toString() {
		return Asignatura + " , " + Curso + " , " +  Convo + " , " + getCalificacion();
	}
	@Override
	public int hashCode() {
		return Objects.hash(Asignatura, Convo, Curso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(Asignatura, other.Asignatura) && Convo == other.Convo
				&& Objects.equals(Curso, other.Curso);
	}

	public int compareTo(Nota o) {
		int r = Curso.compareTo(o.Curso);
		if(r==0) {
			r = Asignatura.compareTo(o.Asignatura);
			if(r==0){
				r = Convo.compareTo(o.Convo);
			}
		}
		return r;
	}
}
