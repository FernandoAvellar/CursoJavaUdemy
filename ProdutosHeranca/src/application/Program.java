package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Product> list = new ArrayList<Product>();

		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();

		for (int i = 1; i <= numberOfProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char productType = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();

			if (productType == 'c') {
				list.add(new Product(productName, productPrice));
			} else if (productType == 'i') {
				System.out.print("Custom Fees: ");
				double customFees = sc.nextDouble();
				list.add(new ImportedProduct(productName, productPrice, customFees));
			} else if (productType == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				sc.nextLine();
				String typedData = sc.nextLine();
				LocalDate manufactureDate = LocalDate.parse(typedData, fmt1);
				list.add(new UsedProduct(productName, productPrice, manufactureDate));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
