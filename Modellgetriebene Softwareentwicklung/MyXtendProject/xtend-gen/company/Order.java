package company;

import java.time.LocalDate;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Order {
  @Accessors
  private double amount;
  
  @Accessors
  private LocalDate date;
  
  public double calculateRabat() {
    return this.amount;
  }
  
  @Pure
  public double getAmount() {
    return this.amount;
  }
  
  public void setAmount(final double amount) {
    this.amount = amount;
  }
  
  @Pure
  public LocalDate getDate() {
    return this.date;
  }
  
  public void setDate(final LocalDate date) {
    this.date = date;
  }
}
