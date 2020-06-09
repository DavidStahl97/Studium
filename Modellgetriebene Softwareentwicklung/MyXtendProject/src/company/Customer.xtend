package company

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

class Customer {
	@Accessors String firstName;
	@Accessors String lastName;
	@Accessors List<? extends Order> orders;
}