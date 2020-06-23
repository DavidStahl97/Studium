package company;

import company.Company;
import company.Customer;
import company.OnlineOrder;
import company.Order;
import company.PhoneOrder;
import company.PostalOrder;
import java.time.LocalDate;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    Company _company = new Company();
    final Procedure1<Company> _function = (Company it) -> {
      Customer _customer = new Customer();
      final Procedure1<Customer> _function_1 = (Customer it_1) -> {
        it_1.setFirstName("Bill");
        it_1.setLastName("Cartwright");
        it_1.setOrders(CollectionLiterals.<Order>newArrayList());
      };
      Customer _doubleArrow = ObjectExtensions.<Customer>operator_doubleArrow(_customer, _function_1);
      Customer _customer_1 = new Customer();
      final Procedure1<Customer> _function_2 = (Customer it_1) -> {
        it_1.setFirstName("Butch");
        it_1.setLastName("Cassidy");
        PhoneOrder _phoneOrder = new PhoneOrder();
        final Procedure1<PhoneOrder> _function_3 = (PhoneOrder it_2) -> {
          it_2.setDate(LocalDate.now());
          it_2.setAmount(400.00);
          it_2.setNumber("23423423");
        };
        PhoneOrder _doubleArrow_1 = ObjectExtensions.<PhoneOrder>operator_doubleArrow(_phoneOrder, _function_3);
        PostalOrder _postalOrder = new PostalOrder();
        final Procedure1<PostalOrder> _function_4 = (PostalOrder it_2) -> {
          it_2.setDate(LocalDate.now());
          it_2.setAmount(400.00);
          it_2.setZipCode("sdfsdfsdf");
        };
        PostalOrder _doubleArrow_2 = ObjectExtensions.<PostalOrder>operator_doubleArrow(_postalOrder, _function_4);
        OnlineOrder _onlineOrder = new OnlineOrder();
        final Procedure1<OnlineOrder> _function_5 = (OnlineOrder it_2) -> {
          it_2.setDate(LocalDate.now());
          it_2.setAmount(34.00);
          it_2.setIpAddress("sdf.23323.2323");
        };
        OnlineOrder _doubleArrow_3 = ObjectExtensions.<OnlineOrder>operator_doubleArrow(_onlineOrder, _function_5);
        it_1.setOrders(CollectionLiterals.<Order>newArrayList(_doubleArrow_1, _doubleArrow_2, _doubleArrow_3));
      };
      Customer _doubleArrow_1 = ObjectExtensions.<Customer>operator_doubleArrow(_customer_1, _function_2);
      it.setCustomers(CollectionLiterals.<Customer>newArrayList(_doubleArrow, _doubleArrow_1));
    };
    final Company company = ObjectExtensions.<Company>operator_doubleArrow(_company, _function);
    System.out.println("hallo");
  }
  
  protected double _calculateOrderRebate(final PhoneOrder order) {
    double _xifexpression = (double) 0;
    double _amount = order.getAmount();
    boolean _greaterThan = (_amount > 1000);
    if (_greaterThan) {
      _xifexpression = 0.15;
    } else {
      double _xifexpression_1 = (double) 0;
      double _amount_1 = order.getAmount();
      boolean _greaterThan_1 = (_amount_1 > 700);
      if (_greaterThan_1) {
        _xifexpression_1 = 0.1;
      } else {
        _xifexpression_1 = 0.0;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected double _calculateOrderRebate(final OnlineOrder order) {
    double _xifexpression = (double) 0;
    double _amount = order.getAmount();
    boolean _greaterThan = (_amount > 600);
    if (_greaterThan) {
      _xifexpression = 0.15;
    } else {
      double _xifexpression_1 = (double) 0;
      double _amount_1 = order.getAmount();
      boolean _greaterThan_1 = (_amount_1 > 400);
      if (_greaterThan_1) {
        _xifexpression_1 = 0.1;
      } else {
        _xifexpression_1 = 0.0;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected double _calculateOrderRebate(final PostalOrder order) {
    double _xifexpression = (double) 0;
    double _amount = order.getAmount();
    boolean _greaterThan = (_amount > 550);
    if (_greaterThan) {
      _xifexpression = 0.1;
    } else {
      _xifexpression = 0.0;
    }
    return _xifexpression;
  }
  
  public double calculateOrderRebate(final Order order) {
    if (order instanceof OnlineOrder) {
      return _calculateOrderRebate((OnlineOrder)order);
    } else if (order instanceof PhoneOrder) {
      return _calculateOrderRebate((PhoneOrder)order);
    } else if (order instanceof PostalOrder) {
      return _calculateOrderRebate((PostalOrder)order);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(order).toString());
    }
  }
}
