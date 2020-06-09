package company

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

class Company {
	@Accessors List<Customer> customers;
}