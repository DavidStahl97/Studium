package hwp;

import hwp.Vector;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class HelloWorld {
  public static void main(final String[] args) {
    ArrayList<Integer> _newArrayList = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    Vector v1 = new Vector(_newArrayList);
    ArrayList<Integer> _newArrayList_1 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1));
    Vector v2 = new Vector(_newArrayList_1);
    int v3 = v1.operator_multiply(v2);
    InputOutput.<Integer>println(Integer.valueOf(v3));
    Vector v4 = v1.operator_multiply(10);
    InputOutput.<Vector>println(v4);
  }
  
  @Override
  public String toString() {
    String _string = super.toString();
    return ("I am instance of HelloWorld" + _string);
  }
}
