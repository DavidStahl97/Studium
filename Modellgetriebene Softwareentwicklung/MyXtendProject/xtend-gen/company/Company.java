package company;

import company.Customer;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Company {
  @Accessors
  private List<Customer> customers;
  
  @Pure
  public List<Customer> getCustomers() {
    return this.customers;
  }
  
  public void setCustomers(final List<Customer> customers) {
    this.customers = customers;
  }
}
