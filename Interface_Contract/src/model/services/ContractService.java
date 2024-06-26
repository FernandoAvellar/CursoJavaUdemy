package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void processContract(Contract contract, Integer numberOfInstallments) {

		double baseValueByMonth = contract.getTotalValue() / numberOfInstallments;

		for (int i = 1; i <= numberOfInstallments; i++) {
			LocalDate paymentDate = contract.getDate().plusMonths(i);
			Double interest = onlinePaymentService.interest(baseValueByMonth, i);
			Double fee = onlinePaymentService.paymentFee(interest);
			Double finalValue = baseValueByMonth + interest + fee;
			Installment installment = new Installment(paymentDate, finalValue);
			contract.getInstallments().add(installment);
		}
	}
}
