package fp.compras.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import fp.compras.Compra;

public class EjerciciosExpresiones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compra c1 = new Compra("40961226C", "Mercadona", "Cadiz", LocalDateTime.of(2019,2,24,5,33), LocalDateTime.of(2019,2,24,5,57), 8.65);
		Compra c2 = new Compra("86302030G", "Mercadona", "Malaga", LocalDateTime.of(2019,2,24,10,1), LocalDateTime.of(2019,2,24,10,34), 188.65);
		Compra c3 = new Compra("37089432T", "Mas", "Granada", LocalDateTime.of(2019,2,24,10,9), LocalDateTime.of(2019,2,24,12,56), 60.43);
		Compra c4 = new Compra("97785005E", "Mercadona", "Malaga", LocalDateTime.of(2019,2,24,13,58), LocalDateTime.of(2019,2,24,15,48), 17.43);
		System.out.println(c1.getProvincia() == "Malaga" && c1.getTotalCompra() > 60.0);
		System.out.println(c3.getFechaSalida().isBefore(LocalDateTime.of(2019, 2, 28,17,35)));
		System.out.println(c1.getSupermercado() == "Mercadona" || c3.getSupermercado()=="Mercadona");
		System.out.println(c2.getFechaSalida().getDayOfYear()==(c3.getFechaSalida().getDayOfYear()));
		System.out.println(c1.getFechaLlegada().getDayOfYear() == c4.getFechaLlegada().getDayOfYear() && c1.getFechaSalida().isBefore(c4.getFechaSalida()));
		System.out.println(c2.getSupermercado() == c4.getSupermercado() && (c2.getTotalCompra() > 100.0 || c4.getTotalCompra() > 100.0));
		System.out.println((c1.getTotalCompra()+c2.getTotalCompra()+c3.getTotalCompra()+c4.getTotalCompra())/4 > 100);
		System.out.println(c2.getFechaLlegada().getMonthValue() % 2 == 0);
		System.out.println(c3.getFechaLlegada().toLocalTime().isAfter(LocalTime.of(15, 0)) && c3.getFechaLlegada().toLocalTime().isBefore(LocalTime.of(21, 0)));
		System.out.println(c4.getFechaLlegada().getDayOfWeek()==DayOfWeek.MONDAY);
		System.out.println(c3.getDNI().charAt(0)=='9');
		System.out.println(c1.getDNI().charAt(8));
		System.out.print(Duration.between(c3.getFechaLlegada().toLocalTime(), c3.getFechaSalida().toLocalTime()).toHours());
		System.out.print(" horas y "+Duration.between(c3.getFechaLlegada().toLocalTime(), c3.getFechaSalida().toLocalTime()).toMinutes()%60 + " minutos");

	}

}
