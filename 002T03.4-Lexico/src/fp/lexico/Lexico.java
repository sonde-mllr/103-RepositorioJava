package fp.lexico;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lexico {
	private SortedSet<String> _palabras_;
	//private Integer _total_palabras_;
	
	public SortedSet<String> get_palabras_() {
		return _palabras_;
	}
	public Integer get_total_palabras_() {
		return _palabras_.size();
	}
	
	public Lexico() {
		this._palabras_ = new TreeSet<String>();
	}
	public Lexico(Collection<String> c) {
		List<String> c1 = c.stream().map(x->x.toLowerCase()).toList();
		this._palabras_ = new TreeSet<String>(c1);
	}
	@Override
	public int hashCode() {
		return Objects.hash(_palabras_);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lexico other = (Lexico) obj;
		return Objects.equals(_palabras_, other._palabras_);
	}
	@Override
	public String toString() {
		return "TipoLexico [_palabras_=" + _palabras_ + "]";
	}
	
	public void agregarPalabra(String palabra) {
		_palabras_.add(palabra);
	}
	
	public void agregarPalabras(Collection<String> palabras) {
		List<String> p1 = palabras.stream().map(x->x.toLowerCase()).toList();
		_palabras_.addAll(p1);
	}
	
	public Set<String> getPalabrasComunes(Lexico lexico){
		Set<String> aux = _palabras_;
		aux.retainAll(lexico.get_palabras_());
		return aux;
	}
	public Set<String> getTodasPalabras(Lexico lexico){
		Set<String> aux = _palabras_;
		aux.addAll(lexico.get_palabras_());
		return aux;
	}
	public Set<String> getDiferenciaPalabras(Lexico lexico){
		Set<String> aux = _palabras_;
		aux.removeAll(lexico.get_palabras_());
		return aux;
	}
}
