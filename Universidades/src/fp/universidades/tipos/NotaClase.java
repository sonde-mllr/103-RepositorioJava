package fp.universidades.tipos;

import fp.utiles.Checkers;

public class NotaClase {
	private Asignatura asignatura;
	private String curso;
	private TipoConvocatoria convo;
	private Double valor;
	private Boolean honor;
	
	public NotaClase(Asignatura asignatura, String curso, TipoConvocatoria convo, Double valor, Boolean honor) {
		super();
		this.asignatura = asignatura;
		this.curso = curso;
		this.convo = convo;
		/*if(valor < 0 || valor > 10) {
			throw new IllegalArgumentException("Nota no válida");
		}*/
		Checkers.check("Nota no válida", valor < 0 || valor > 10);
		this.valor = valor;
		/*if(valor < 9 && honor) {
			throw new IllegalArgumentException("No puede tener mat de honor si la nota es menor a 9");
		}*/
		Checkers.check("No puede ter matricula de honor si la nota es menor a 9", valor < 9 && honor);
		this.honor = honor;
	}

	public NotaClase(Asignatura asignatura, String curso, TipoConvocatoria convo, Double valor) {
		super();
		this.asignatura = asignatura;
		this.curso = curso;
		this.convo = convo;
		this.valor = valor;
		this.honor = false;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public TipoConvocatoria getConvo() {
		return convo;
	}

	public void setConvo(TipoConvocatoria convo) {
		this.convo = convo;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getHonor() {
		return honor;
	}
	
	public TipoNota getCalificacion() {
		Double valor = getValor();
		TipoNota calificacion = TipoNota.SUSPENSO;
		if( 5.<= valor && valor < 7.) {
			calificacion = TipoNota.APROBADO;
		} else if(7. <= valor && valor < 9.) {
			calificacion = TipoNota.NOTABLE;
		} else if(valor >= 9.) {
			calificacion = TipoNota.SOBRESALIENTE;
		} else if(valor >= 9. && getHonor()) {
			calificacion = TipoNota.MATRICULA;
		}
		return calificacion;
	}
	
	public String toString() {
		return asignatura + " , " + curso + " , " +  convo + " , " + getCalificacion();
	}
	
}
