package fp.universidades.tipos;

public class AsignaturaClase {
	private String nombre;
	private String código;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;
	
	public AsignaturaClase(String nombre,String codigo,Double creditos, TipoAsignatura tipo, Integer curso) {
		this.nombre = nombre;
		this.código = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCódigo() {
		return código;
	}

	public Double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public Integer getCurso() {
		return curso;
	}
	public String toString() {
		return "("+código+")" + nombre;
	}
	
}
