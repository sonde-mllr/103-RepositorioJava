package fp.sevici.tipos;

import java.util.Objects;

import fp.utils.Checkers;

public class Coordenadas {
	private Double latitud;
	private Double longitud;
	private UnidadMedida unidad;
	
	
	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public UnidadMedida getUnidad() {
		return unidad;
	}

	public Coordenadas() {
		this.latitud = 0.;
		this.longitud = 0.;
		this.unidad = UnidadMedida.GRADOS;
	}
	
	public Coordenadas(Double l1,Double l2) {
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º", l1 > -90. && l1 < 90.);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º", l2>-180. && l2 <180.);
		this.latitud = l1;
		this.longitud = l2;
		this.unidad =UnidadMedida.GRADOS;
	}
	
	public Coordenadas(Double l1,Double l2,UnidadMedida u) {
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º", l1 > -90. && l2 < 90.);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º", l2>-180. && l2 <180.);
		this.latitud = l1;
		this.longitud = l2;
		this.unidad = u;
	}
	
	public Coordenadas(String s) {
		String[] sp = s.split(",");
		Double l1 = Double.valueOf(sp[0].trim());
		Double l2 = Double.valueOf(sp[1].trim());
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º", l1 > -90. && l2 < 90.);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º", l2>-180. && l2 <180.);
		this.latitud = l1;
		this.longitud = l2;
		this.unidad = UnidadMedida.GRADOS;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud, unidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenadas other = (Coordenadas) obj;
		return Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud)
				&& unidad == other.unidad;
	}

	@Override
	public String toString() {
		return "Coordenadas [latitud=" + latitud + ", longitud=" + longitud + ", unidad=" + unidad + "]";
	}
	//TODO
	public Double getDistanciaHaversine(Coordenadas c) {
		return null;
	}
	public Coordenadas aRadianes() {
		if(this.unidad == UnidadMedida.RADIANES) {
			return null;
		}
		return new Coordenadas();
	}
	
}
