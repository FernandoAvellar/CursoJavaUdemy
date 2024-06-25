package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		LocalDate d04 = LocalDate.parse("2022-06-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-06-20T13:22:00");
		Instant d06 = Instant.parse("2022-06-20T13:22:00Z");
		Instant d07 = Instant.parse("2022-06-20T22:10:00-03:00");
		
		DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("10/09/1980", fmt01);
		
		LocalDateTime d09 = LocalDateTime.parse("24/06/2024 13:22",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		LocalDate d10 = LocalDate.of(2024, 06, 24);
		LocalDateTime d11 = LocalDateTime.of(2024, 06, 24, 10, 53);
		
		DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

		
		System.out.println("d01 = " + d01.toString());
		System.out.println("d01_formatado = " +d01.format(fmt01));
		System.out.println("d02 = " + d02);
		System.out.println("d03 = " + d03);
		System.out.println("d04 = " + d04);
		System.out.println("d05 = " + d05);
		System.out.println("d06 = " + d06);
		System.out.println("d06_formatado = " + fmt02.format(d06));
		System.out.println("d07 = " + d07);
		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);
		

	}

}
