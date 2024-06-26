package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter with contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (DD/MM/YYYY): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract Value: ");
		double value = sc.nextDouble();
		System.out.print("Number of installments: ");
		int numOfInstallments = sc.nextInt();

		Contract contract = new Contract(number, date, value);
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, numOfInstallments);

		System.out.println("Installments:");
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}

		sc.close();
	}
}
