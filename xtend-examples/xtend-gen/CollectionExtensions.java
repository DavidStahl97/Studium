import com.google.common.collect.Iterables;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CollectionExtensions {
  public static <E extends Object> Iterable<E> schnittmenge(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    final Function1<E, Boolean> _function = (E c1) -> {
      final Function1<E, Boolean> _function_1 = (E c2) -> {
        return Boolean.valueOf(c2.equals(c1));
      };
      return Boolean.valueOf(IterableExtensions.<E>exists(collectionTwo, _function_1));
    };
    return IterableExtensions.<E>filter(collectionOne, _function);
  }
  
  public static <E extends Object> Iterable<E> differenz(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    final Function1<E, Boolean> _function = (E c1) -> {
      final Function1<E, Boolean> _function_1 = (E c2) -> {
        return Boolean.valueOf(c2.equals(c1));
      };
      boolean _exists = IterableExtensions.<E>exists(collectionTwo, _function_1);
      return Boolean.valueOf((_exists == false));
    };
    return IterableExtensions.<E>filter(collectionOne, _function);
  }
  
  public static <E extends Object> boolean vereinigung(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    return IterableExtensions.<E>toList(CollectionExtensions.<E>differenz(collectionOne, collectionTwo)).addAll(collectionTwo);
  }
  
  public static <E extends Object> boolean symetrischeDifferenz(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    return Iterables.<E>addAll(IterableExtensions.<E>toList(CollectionExtensions.<E>differenz(collectionOne, collectionTwo)), CollectionExtensions.<E>differenz(collectionTwo, collectionOne));
  }
  
  public <E extends Object> Iterable<E> operator_and(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    final boolean s = this.<E>operator_or(collectionOne, collectionTwo);
    return CollectionExtensions.<E>schnittmenge(collectionOne, collectionTwo);
  }
  
  public <E extends Object> Iterable<E> operator_minus(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    return CollectionExtensions.<E>differenz(collectionOne, collectionTwo);
  }
  
  public <E extends Object> boolean operator_or(final Collection<E> collectionOne, final Collection<E> collectionTwo) {
    return CollectionExtensions.<E>vereinigung(collectionOne, collectionTwo);
  }
}
