package company

import org.eclipse.xtend.lib.annotations.Accessors
import java.time.LocalDate

class Order {
	@Accessors double amount;
	@Accessors LocalDate date;
	
	def double calculateRabat() {
		return amount;
	}
}