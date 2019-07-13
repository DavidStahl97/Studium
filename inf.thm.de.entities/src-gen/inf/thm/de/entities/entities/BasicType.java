/**
 * generated by Xtext 2.18.0
 */
package inf.thm.de.entities.entities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link inf.thm.de.entities.entities.BasicType#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see inf.thm.de.entities.entities.EntitiesPackage#getBasicType()
 * @model
 * @generated
 */
public interface BasicType extends ElementType
{
  /**
   * Returns the value of the '<em><b>Entity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entity</em>' reference.
   * @see #setEntity(Entity)
   * @see inf.thm.de.entities.entities.EntitiesPackage#getBasicType_Entity()
   * @model
   * @generated
   */
  Entity getEntity();

  /**
   * Sets the value of the '{@link inf.thm.de.entities.entities.BasicType#getEntity <em>Entity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entity</em>' reference.
   * @see #getEntity()
   * @generated
   */
  void setEntity(Entity value);

} // BasicType
