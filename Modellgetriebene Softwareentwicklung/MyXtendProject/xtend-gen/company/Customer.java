package company;

import company.Order;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Customer {
  @Accessors
  private String firstName;
  
  @Accessors
  private String lastName;
  
  @Accessors
  private List<? extends Order> orders;
  
  @Pure
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }
  
  @Pure
  public String getLastName() {
    return this.lastName;
  }
  
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
  
  @Pure
  public List<? extends Order> getOrders() {
    return this.orders;
  }
  
  public void setOrders(final List<? extends Order> orders) {
    this.orders = orders;
  }
}
