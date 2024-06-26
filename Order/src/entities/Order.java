package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem ordemItem) {
		items.add(ordemItem);
	}

	public void removeItem(OrderItem ordemItem) {
		items.remove(ordemItem);
	}

	public Double total() {
		Double totalSum = 0.0;
		for (OrderItem orderItem : items) {
			totalSum += orderItem.subTotal();
		}
		return totalSum;
	}

}
