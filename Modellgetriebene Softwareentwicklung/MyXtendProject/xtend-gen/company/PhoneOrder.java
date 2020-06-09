package company;

import company.Order;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PhoneOrder extends Order {
  @Accessors
  private String number;
  
  @Pure
  public String getNumber() {
    return this.number;
  }
  
  public void setNumber(final String number) {
    this.number = number;
  }
}
