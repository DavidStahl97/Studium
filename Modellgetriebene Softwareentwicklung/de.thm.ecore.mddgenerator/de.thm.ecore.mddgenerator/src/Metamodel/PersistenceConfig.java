/**
 */
package Metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Persistence Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Metamodel.PersistenceConfig#getDbschema <em>Dbschema</em>}</li>
 *   <li>{@link Metamodel.PersistenceConfig#getJdbcUserName <em>Jdbc User Name</em>}</li>
 * </ul>
 *
 * @see Metamodel.MetamodelPackage#getPersistenceConfig()
 * @model
 * @generated
 */
public interface PersistenceConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Dbschema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dbschema</em>' attribute.
	 * @see #setDbschema(String)
	 * @see Metamodel.MetamodelPackage#getPersistenceConfig_Dbschema()
	 * @model
	 * @generated
	 */
	String getDbschema();

	/**
	 * Sets the value of the '{@link Metamodel.PersistenceConfig#getDbschema <em>Dbschema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dbschema</em>' attribute.
	 * @see #getDbschema()
	 * @generated
	 */
	void setDbschema(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc User Name</em>' attribute.
	 * @see #setJdbcUserName(String)
	 * @see Metamodel.MetamodelPackage#getPersistenceConfig_JdbcUserName()
	 * @model
	 * @generated
	 */
	String getJdbcUserName();

	/**
	 * Sets the value of the '{@link Metamodel.PersistenceConfig#getJdbcUserName <em>Jdbc User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc User Name</em>' attribute.
	 * @see #getJdbcUserName()
	 * @generated
	 */
	void setJdbcUserName(String value);

} // PersistenceConfig
