package fp.universidades.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public class Persona implements Comparable<Persona>{
	private String DNI;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;
	
	public Persona(String dNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super();
		Checkers.check("El dni debe tener 8 dígitos y una letra", dNI.length() == 9 );
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		Checkers.check("El email debe contener @", email.contains("@") || email.isEmpty());
		this.email = email;
	}
	
	public Persona(String dNI, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = "";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Integer getEdad() {
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}
	
	public String toString() {
		return DNI + " - " + apellidos  + "," + nombre  + " - " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI, apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(nombre, other.nombre);
	}
	public int compareTo(Persona o) {
		int r = getApellidos().compareTo(o.getApellidos());
		if(r==0) {
			r = getNombre().compareTo(o.getNombre());
			if(r==0) {
				r = getDNI().compareTo(o.getDNI());
			}
		}
		return r;
	}
}
