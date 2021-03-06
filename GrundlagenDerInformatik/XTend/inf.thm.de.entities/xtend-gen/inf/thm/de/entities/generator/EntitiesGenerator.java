/**
 * generated by Xtext 2.18.0
 */
package inf.thm.de.entities.generator;

import com.google.common.collect.Iterables;
import inf.thm.de.entities.entities.Entity;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class EntitiesGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Entity.class);
    for (final Entity e : _filter) {
      String _name = e.getName();
      String _plus = ("entities/" + _name);
      String _plus_1 = (_plus + ".java");
      fsa.generateFile(_plus_1, this.compile(e));
    }
  }
  
  public CharSequence compile(final Entity entity) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attributes is undefined for the type Entity"
      + "\nThe method or field attributes is undefined for the type Entity"
      + "\ntype cannot be resolved"
      + "\ncompile cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ncompile cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public Object compile(final /* AttributeType */Object attributeType) {
    throw new Error("Unresolved compilation problems:"
      + "\nelementType cannot be resolved"
      + "\ntypeToString cannot be resolved"
      + "\n+ cannot be resolved"
      + "\narray cannot be resolved");
  }
  
  protected String _typeToString(final /* BasicType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\ntypeName cannot be resolved"
      + "\n== cannot be resolved"
      + "\ntypeName cannot be resolved");
  }
  
  protected String _typeToString(final /* EntityType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nentity cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public String typeToString(final BasicType type) {
    if (type != null) {
      return _typeToString(type); else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(type).toString());
      }
    }
  }
  