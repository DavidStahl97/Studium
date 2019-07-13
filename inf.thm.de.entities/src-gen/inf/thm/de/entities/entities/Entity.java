/**
 * generated by Xtext 2.18.0
 */
package inf.thm.de.entities.entities;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link inf.thm.de.entities.entities.Entity#getName <em>Name</em>}</li>
 *   <li>{@link inf.thm.de.entities.entities.Entity#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link inf.thm.de.entities.entities.Entity#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see inf.thm.de.entities.entities.EntitiesPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see inf.thm.de.entities.entities.EntitiesPackage#getEntity_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link inf.thm.de.entities.entities.Entity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(Entity)
   * @see inf.thm.de.entities.entities.EntitiesPackage#getEntity_SuperType()
   * @model
   * @generated
   */
  Entity getSuperType();

  /**
   * Sets the value of the '{@link inf.thm.de.entities.entities.Entity#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(Entity value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link inf.thm.de.entities.entities.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see inf.thm.de.entities.entities.EntitiesPackage#getEntity_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // Entity
