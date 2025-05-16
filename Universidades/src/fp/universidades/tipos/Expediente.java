package fp.universidades.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expediente implements Comparable<Expediente>{
	private List<Nota> notas;
	// nota media: propiedad derivada
	
	public String toString() {
		return notas.toString();
	}
	
	public List<Nota> getNotas() {
		return notas;
	}

	public Expediente() {
		this.notas = new ArrayList<Nota>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(notas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}
	
	public void nuevaNota(Nota n) {
		if(!(notas.contains(n))) {
			notas.add(n);
		} else {
			notas.remove(n);
			notas.add(n);
		}
	}
	
	public Double getNotaMedia() {
		Double aux = 0.;
		int cont = 0;
		for(Nota nota:notas) {
			aux += nota.Valor();
			cont ++;
		}
		return aux/cont;
	}

	@Override
	public int compareTo(Expediente o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
