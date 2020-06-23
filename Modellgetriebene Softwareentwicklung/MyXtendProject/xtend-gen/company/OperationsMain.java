package company;

import com.google.common.collect.Iterables;
import company.Customer;
import company.OnlineOrder;
import company.Order;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OperationsMain {
  public static void main(final String[] args) {
    List<Order> orders = OperationsMain.obtainOrderListFromSomewhere();
    List<Order> onlineOrders = CollectionLiterals.<Order>newArrayList();
    List<Customer> customers = CollectionLiterals.<Customer>newArrayList();
    final Function1<Customer, Boolean> _function = (Customer it) -> {
      return Boolean.valueOf((it.getLastName().startsWith("A") || it.getLastName().startsWith("B")));
    };
    Iterable<Customer> result_1 = IterableExtensions.<Customer>filter(customers, _function);
    final Function1<Customer, Boolean> _function_1 = (Customer c) -> {
      int _size = c.getOrders().size();
      return Boolean.valueOf((_size > 4));
    };
    Iterable<Customer> result_2 = IterableExtensions.<Customer>filter(customers, _function_1);
    final Function1<Customer, Boolean> _function_2 = (Customer c) -> {
      final Function1<Order, Boolean> _function_3 = (Order o) -> {
        return Boolean.valueOf((o instanceof OnlineOrder));
      };
      int _size = IterableExtensions.size(IterableExtensions.filter(c.getOrders(), _function_3));
      return Boolean.valueOf((_size > 3));
    };
    Iterable<Customer> result_3 = IterableExtensions.<Customer>filter(customers, _function_2);
    final Function1<Customer, Double> _function_3 = (Customer c) -> {
      final Function1<Order, Double> _function_4 = (Order it) -> {
        return Double.valueOf(it.getAmount());
      };
      final Function2<Double, Double, Double> _function_5 = (Double a, Double b) -> {
        return Double.valueOf(DoubleExtensions.operator_plus(a, b));
      };
      return IterableExtensions.<Double>reduce(ListExtensions.map(c.getOrders(), _function_4), _function_5);
    };
    Customer result_4 = IterableExtensions.<Customer, Double>maxBy(customers, _function_3);
    final Function1<Customer, List<? extends Order>> _function_4 = (Customer c) -> {
      return c.getOrders();
    };
    final Function1<Order, Boolean> _function_5 = (Order o) -> {
      return Boolean.valueOf((o instanceof OnlineOrder));
    };
    Iterable<Order> result_5 = IterableExtensions.<Order>filter(Iterables.<Order>concat(ListExtensions.<Customer, List<? extends Order>>map(customers, _function_4)), _function_5);
    final Function1<Customer, List<? extends Order>> _function_6 = (Customer c) -> {
      return c.getOrders();
    };
    final Function1<Order, Boolean> _function_7 = (Order o) -> {
      return Boolean.valueOf((o instanceof OnlineOrder));
    };
    final Function1<Order, Double> _function_8 = (Order it) -> {
      return Double.valueOf(it.getAmount());
    };
    final Function2<Double, Double, Double> _function_9 = (Double a, Double b) -> {
      return Double.valueOf(DoubleExtensions.operator_plus(a, b));
    };
    Double result_6 = IterableExtensions.<Double>reduce(IterableExtensions.<Order, Double>map(IterableExtensions.<Order>filter(Iterables.<Order>concat(ListExtensions.<Customer, List<? extends Order>>map(customers, _function_6)), _function_7), _function_8), _function_9);
    final Function1<Customer, List<? extends Order>> _function_10 = (Customer c) -> {
      return c.getOrders();
    };
    final Function1<Order, Boolean> _function_11 = (Order o) -> {
      return Boolean.valueOf((o instanceof OnlineOrder));
    };
    final Function1<Order, Double> _function_12 = (Order it) -> {
      return Double.valueOf(it.calculateRabat());
    };
    final Function2<Double, Double, Double> _function_13 = (Double a, Double b) -> {
      return Double.valueOf(DoubleExtensions.operator_plus(a, b));
    };
    Double result_7 = IterableExtensions.<Double>reduce(IterableExtensions.<Order, Double>map(IterableExtensions.<Order>filter(Iterables.<Order>concat(ListExtensions.<Customer, List<? extends Order>>map(customers, _function_10)), _function_11), _function_12), _function_13);
    final Function1<Customer, List<? extends Order>> _function_14 = (Customer c) -> {
      return c.getOrders();
    };
    final Function1<OnlineOrder, Double> _function_15 = (OnlineOrder it) -> {
      return Double.valueOf(it.getAmount());
    };
    String result_8 = IterableExtensions.<OnlineOrder, Double>maxBy(Iterables.<OnlineOrder>filter((Iterables.<Order>concat(ListExtensions.<Customer, List<? extends Order>>map(customers, _function_14))), OnlineOrder.class), _function_15).getIpAddress();
    final Function1<Customer, Double> _function_16 = (Customer c) -> {
      final Function1<Order, Double> _function_17 = (Order it) -> {
        return Double.valueOf(it.getAmount());
      };
      return Double.valueOf(IterableExtensions.maxBy(c.getOrders(), _function_17).getAmount());
    };
    Customer result_9 = IterableExtensions.<Customer, Double>maxBy(customers, _function_16);
  }
  
  public static List<Order> obtainOrderListFromSomewhere() {
    return null;
  }
}
