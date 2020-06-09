package company

import java.time.LocalDate
import java.util.ArrayList
import java.util.Arrays

class Main {
	def static void main(String[] args) {
				
		
		val company = new Company => [
			customers = newArrayList(
				new Customer => [
					firstName = "Bill"
					lastName = "Cartwright"
					orders = newArrayList(

					)
				],
				new Customer => [
					firstName = "Butch"
					lastName = "Cassidy"
					orders = newArrayList(
						new PhoneOrder => [
							date = LocalDate.now()
							amount = 400.00
							number = "23423423"
						],
						new PostalOrder => [
							date = LocalDate.now()
							amount = 400.00
							zipCode = "sdfsdfsdf" 
						],
						new OnlineOrder => [
							date = LocalDate.now()
							amount = 34.00
							ipAddress = "sdf.23323.2323"
						]
					)
				]				
			)
		]
		
		System.out.println("hallo")
	}
	
	def dispatch calculateOrderRebate(PhoneOrder order) {
		(order.amount > 1000) ? 0.15 : (order.amount > 700) ? 0.1 : 0.0;
	}
	
	def dispatch calculateOrderRebate(OnlineOrder order) {
		(order.amount > 600) ? 0.15 : (order.amount > 400) ? 0.1 : 0.0;
	}
	
	def dispatch calculateOrderRebate(PostalOrder order) {
		(order.amount > 550) ? 0.1 : 0.0;
	}		
}