package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class AreaCalculator {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Rectangle rec = new Rectangle();
		
		System.out.println("Enter rectangle widht and hwight:");
		rec.widht = sc.nextDouble();
		rec.height = sc.nextDouble();
		System.out.printf("Area = %.2f%n", rec.area());
		System.out.printf("Perimeter = %.2f%n", rec.perimeter());
		System.out.printf("Diagonal = %.2f%n", rec.diagonal());
		
		sc.close();

	}

}
