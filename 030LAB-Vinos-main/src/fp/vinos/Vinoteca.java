package fp.vinos;

import java.util.Collection;

public interface Vinoteca {
	public void agregarVino(Vino v);
	public void eliminarVino(Vino v);
	public Integer obtenerNumeroVinos();
	public Boolean contieneVino(Vino v);
	public void agregarVinos(Collection<Vino> c);
	public Boolean contieneVinos(Collection<Vino> c);
}
