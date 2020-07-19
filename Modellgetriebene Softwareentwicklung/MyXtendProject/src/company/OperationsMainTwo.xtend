package company

import java.util.List

class OperationsMainTwo {
	def static void main(String[] args) {
		var List<Order> orders = obtainOrderListFromSomewhere();
		var List<Order> onlineOrders = newArrayList();
		var List<Customer> customers = newArrayList();
		
		// 1.
		var result1 = customers.filter[c | c.lastName.startsWith("A") || c.lastName.startsWith("C")];
		
		// 2.
		var result2 = customers.filter[c | c.orders.length > 4];
		
		// 3.
		var result3 = customers.filter[c | c.orders.filter[o | o instanceof OnlineOrder].length > 3];
		
		// 4.
		var result4 = customers.maxBy[c | c.orders.map[amount].reduce[a, b | a + b]];
		
		// 5.
		var result5 = customers.map[c | c.orders.filter[o | o instanceof OnlineOrder]].flatten;
		
		// 6.
		var result6 = customers.map[c | c.orders.filter[o | o instanceof OnlineOrder]].flatten.map[amount].reduce[a, b | a + b];
		
		// 7.
		
		// 8.
		var result8 = customers.map[c | c.orders].flatten.filter(OnlineOrder).maxBy[ipAddress];
		
		// 9.
		var result9 = customers.maxBy[c | c.orders.maxBy[amount].amount];
		
		// 10.
		var result10 = customers.maxBy[c | c.orders.map[amount].reduce[a, b| a + b] / c.orders.length];
		
		// 11.
		var result11 = customers.maxBy[c | c.orders.filter(PhoneOrder).length];
		
		// 12.
		var result12 = customers.filter[c | c.orders.filter(OnlineOrder).length == 0];
	}
	
	def static List<Order> obtainOrderListFromSomewhere() {
		return null;
	}
}