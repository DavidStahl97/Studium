package company

import java.util.List

class OperationsMain {
	def static void main(String[] args) {
		var List<Order> orders = obtainOrderListFromSomewhere();
		var List<Order> onlineOrders = newArrayList();
		var List<Customer> customers = newArrayList();
		
		// 1.
		var result_1 = customers.filter[lastName.startsWith("A") || lastName.startsWith("B")];
		
		// 2.
		var result_2 = customers.filter[c | c.orders.size() > 4];
		
		// 3.
		var result_3 = customers.filter[c | c.orders.filter[o | o instanceof OnlineOrder].size() > 3];
		
		// 4.
		var result_4 = customers.maxBy[c | c.orders.map[amount].reduce[a, b | a + b]];
		
		// 5.
		var result_5 = customers.map[c | c.orders].flatten.filter[o | o instanceof OnlineOrder];
		
		// 6.
		var result_6 = customers.map[c | c.orders].flatten.filter[o | o instanceof OnlineOrder].map[amount].reduce[a, b | a + b];
		
		// 7.
		var result_7 = customers.map[c | c.orders].flatten.filter[o | o instanceof OnlineOrder].map[calculateRabat()].reduce[a, b | a + b];
		
		// 8.
		var result_8 = customers.map[c | c.orders].flatten.filter(OnlineOrder).maxBy[amount].ipAddress;
		
		// 9.
		var result_9 = customers.maxBy[c | c.orders.maxBy[amount].amount];
		
		// 10.
		
	}
	
	def static List<Order> obtainOrderListFromSomewhere() {
		return null;
	}
}