package program;

import java.util.Locale;
import java.util.Scanner;

import utility.CurrencyConverter;

public class Conversor {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("What is the dollar price? ");
		double dolarPrice = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		double amount = sc.nextDouble();
		System.out.printf("Amount to be paid in reais: %.2f%n", CurrencyConverter.usdToReal(amount, dolarPrice));

		sc.close();

	}

}
