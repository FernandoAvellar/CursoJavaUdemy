package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientMail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String clientBirth = sc.nextLine();
		Client client = new Client(clientName, clientMail, LocalDate.parse(clientBirth, fmt1));

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), client);

		System.out.print("How many items to this order? ");
		Integer numberOfItems = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= numberOfItems; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();

			OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + order.getMoment().format(fmt2));
		System.out.println("Order Status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " ("
				+ order.getClient().getBirthDate().format(fmt1) + ") " + "- " + order.getClient().getEmail());

		System.out.println("Order items: ");

		for (OrderItem orderItem : order.getItems()) {
			System.out.println(orderItem);
		}

		System.out.println("Total price: $" + order.total());

		sc.close();

	}

}
