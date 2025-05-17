package fp.universidades.tipos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

import fp.utiles.Checkers;

public record Tutoria(DayOfWeek dia,LocalTime horaComienzo,LocalTime horaFin) implements Comparable<Tutoria>{
	public Tutoria{		
		Duration duracion = Duration.between(horaComienzo, horaFin);
		Checkers.check("La duracion debe ser almenos 15 minutos", duracion.compareTo(Duration.ofMinutes(15))>= 0);
		Checkers.check("No puede ser sabado ni domingo", !(dia.equals(DayOfWeek.SATURDAY)) && !(dia.equals(DayOfWeek.SUNDAY)));
	}
	public Tutoria(DayOfWeek dia,LocalTime inicio,Duration duracion) {
		this(dia,inicio,calcularFin(inicio,duracion));
	} 
	public static LocalTime calcularFin(LocalTime inicio,Duration duracion) {
		LocalTime fin = null;
		fin = inicio.plus(duracion);
		return fin;
	}
	public Duration getDuracion() {
		Duration duracion = Duration.ZERO;
		duracion = Duration.between(horaComienzo, horaFin);
		return duracion;
	}
	public String toString() {
		return dia.name().charAt(0) + " " + horaComienzo + "-" + horaFin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dia, horaComienzo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutoria other = (Tutoria) obj;
		return dia == other.dia && Objects.equals(horaComienzo, other.horaComienzo);
	}
	public int compareTo(Tutoria o) {
		int r = dia.compareTo(o.dia);
		if(r==0) {
			r = horaComienzo.compareTo(o.horaComienzo);
		}
		return r;
	}
}
