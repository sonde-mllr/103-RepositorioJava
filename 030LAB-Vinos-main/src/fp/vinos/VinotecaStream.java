package fp.vinos;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class VinotecaStream implements Vinoteca {
	private Set<Vino> vinos;
	
	public VinotecaStream() {
		super();
		this.vinos = new HashSet<Vino>();
	}
	public VinotecaStream(Collection<Vino> v) {
		super();
		this.vinos = new HashSet<Vino>(v);
	}
	
	public String toString() {
		return String.valueOf(this.vinos.size());
	}
	
	@Override
	public void agregarVino(Vino v) {
		this.vinos.add(v);
	}

	@Override
	public void eliminarVino(Vino v) {
		if(this.vinos.contains(v)) {
			this.vinos.remove(v);
		} else {
			throw new IllegalArgumentException("El vino no existe");
		}
	}

	@Override
	public Integer obtenerNumeroVinos() {
		return this.vinos.size();
	}

	@Override
	public Boolean contieneVino(Vino v) {
		return this.vinos.contains(v);
	}

	@Override
	public void agregarVinos(Collection<Vino> c) {
		this.vinos.addAll(c);
	}

	@Override
	public Boolean contieneVinos(Collection<Vino> c) {
		return this.vinos.containsAll(c);
	}

	public Integer calcularNumeroVinosDePais(String pais) {
		return (int) this.vinos.stream().filter(x->x.pais().equals(pais)).count();
	}
	public List<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup){
		Checkers.check("El limite inferior debe ser menor que el superior", inf<sup);
		return this.vinos.stream().filter(x->x.puntos() > inf && x.puntos() <sup).toList();
	}
	
	public Integer calcularNumeroVinosDePaisConPuntuacion(String pais,Integer umbral) {
		return (int) this.vinos.stream().filter(x->x.puntos()>umbral).filter(x->x.pais().equals(pais)).count();
	}
	
	public Set<Vino> obtenerVinosBaratos(Double precioMax) {
		return this.vinos.stream().filter(x->x.precio()<precioMax).collect(Collectors.toSet());
	}
	
	public Boolean existeVinoDeUvaEnRegion(String region,String uva) {
		return this.vinos.stream().filter(x->x.region().equals(region)).filter(x->x.uva().equals(uva)).count() != 0;
	}
	
	public Set<String> calcuarUvasDeRegion(String region){
		return this.vinos.stream().filter(x->x.region().equals(region)).map(x->x.uva()).collect(Collectors.toSet());
	}
	
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		return this.vinos.stream().filter(x->x.region().equals(region)).mapToInt(x->x.puntos()).sum();
	}
	
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		return this.vinos.stream().collect(Collectors.averagingInt(x->x.puntos()));
	}
	
	public Vino obtenerVinoMejorPuntuado() {
		return this.vinos.stream().max(Comparator.comparingInt(Vino::puntos)).orElseThrow(NoSuchElementException::new);
	}
	
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		return this.vinos.stream().filter(x->x.pais().equals(pais)).max(Comparator.comparingInt(Vino::puntos)).orElseThrow(NoSuchElementException::new);
	}
	
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region,Integer n) {
		return this.vinos.stream().filter(x->x.region().equals(region)).sorted(Comparator.comparing(Vino::precio)).toList().subList(0, n);	
	}
	
	public Map<String,List<Vino>> agruparVinosPorPais(){
		return this.vinos.stream().collect(Collectors.groupingBy(Vino::pais));
	}
	
	public Map<String,Set<String>> agruparUvasPorPais(){
		return this.vinos.stream().collect(Collectors.groupingBy(Vino::pais,Collectors.mapping(Vino::uva,Collectors.toSet())));
	}
	
	public Map<String,Integer> calcularCalidadPrecioPorRegionMayorDe(Double umbral){
		return this.vinos.stream().collect(
			    Collectors.groupingBy(
			        Vino::region,Collectors.collectingAndThen(
			            Collectors.filtering(
			                x -> x.getCalidadPrecio() > umbral,Collectors.counting()),
			            count -> count.intValue() 
			        )
			    )
			);	}
	
	public Map<String,Vino> calcularVinoMasCaroPorPais(){
		return this.vinos.stream().
				collect(Collectors.groupingBy(Vino::pais,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Vino::precio)),Optional::get)));
				
	}
	
	public Map<String, Object> calcularNmejoresVinosPorPais(Integer n) {
	    return this.vinos.stream()
	        .collect(Collectors.groupingBy(
	            Vino::pais,
	            TreeMap::new, // genera un SortedMap directamente
	            Collectors.collectingAndThen(
	                Collectors.toList(),
	                lista -> lista.stream()
	                              .sorted(Comparator.comparingInt(Vino::puntos).reversed())
	                              .limit(n)
	                              .collect(Collectors.toCollection(LinkedHashSet::new)) // preserva orden, sin duplicados
	            )
	        ));
	}
	
	public String calcularRegionConMejoresVinos(Double umbral) {
	    Map<String, Integer> aux = this.calcularCalidadPrecioPorRegionMayorDe(umbral);
	    
	    return aux.entrySet().stream()
	        .max(Map.Entry.comparingByValue()) 
	        .map(Map.Entry::getKey) 
	        .orElseThrow(NoSuchElementException::new);
	}

}
