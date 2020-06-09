package company;

import company.Order;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class OnlineOrder extends Order {
  @Accessors
  private String ipAddress;
  
  @Pure
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public void setIpAddress(final String ipAddress) {
    this.ipAddress = ipAddress;
  }
}
