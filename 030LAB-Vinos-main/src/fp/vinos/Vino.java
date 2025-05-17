package fp.vinos;

public record Vino(String pais,String region,Integer puntos, Double precio, String uva) {
	public Double getCalidadPrecio() {
		return this.precio()/this.puntos();
	}
}
