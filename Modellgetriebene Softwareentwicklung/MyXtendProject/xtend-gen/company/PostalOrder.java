package company;

import company.Order;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PostalOrder extends Order {
  @Accessors
  private String zipCode;
  
  @Pure
  public String getZipCode() {
    return this.zipCode;
  }
  
  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }
}
