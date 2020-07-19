/**
 */
package Metamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Metamodel.MetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://thm.ecore.mddgenerator.de";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.thm.ecore.mddgenerator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = Metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link Metamodel.impl.PersistenceConfigImpl <em>Persistence Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Metamodel.impl.PersistenceConfigImpl
	 * @see Metamodel.impl.MetamodelPackageImpl#getPersistenceConfig()
	 * @generated
	 */
	int PERSISTENCE_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Dbschema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_CONFIG__DBSCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Jdbc User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_CONFIG__JDBC_USER_NAME = 1;

	/**
	 * The number of structural features of the '<em>Persistence Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Persistence Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENCE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Metamodel.impl.RootConfigImpl <em>Root Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Metamodel.impl.RootConfigImpl
	 * @see Metamodel.impl.MetamodelPackageImpl#getRootConfig()
	 * @generated
	 */
	int ROOT_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Persistence Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONFIG__PERSISTENCE_CONFIG = 0;

	/**
	 * The number of structural features of the '<em>Root Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Root Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONFIG_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Metamodel.PersistenceConfig <em>Persistence Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persistence Config</em>'.
	 * @see Metamodel.PersistenceConfig
	 * @generated
	 */
	EClass getPersistenceConfig();

	/**
	 * Returns the meta object for the attribute '{@link Metamodel.PersistenceConfig#getDbschema <em>Dbschema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dbschema</em>'.
	 * @see Metamodel.PersistenceConfig#getDbschema()
	 * @see #getPersistenceConfig()
	 * @generated
	 */
	EAttribute getPersistenceConfig_Dbschema();

	/**
	 * Returns the meta object for the attribute '{@link Metamodel.PersistenceConfig#getJdbcUserName <em>Jdbc User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc User Name</em>'.
	 * @see Metamodel.PersistenceConfig#getJdbcUserName()
	 * @see #getPersistenceConfig()
	 * @generated
	 */
	EAttribute getPersistenceConfig_JdbcUserName();

	/**
	 * Returns the meta object for class '{@link Metamodel.RootConfig <em>Root Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Config</em>'.
	 * @see Metamodel.RootConfig
	 * @generated
	 */
	EClass getRootConfig();

	/**
	 * Returns the meta object for the containment reference '{@link Metamodel.RootConfig#getPersistenceConfig <em>Persistence Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Persistence Config</em>'.
	 * @see Metamodel.RootConfig#getPersistenceConfig()
	 * @see #getRootConfig()
	 * @generated
	 */
	EReference getRootConfig_PersistenceConfig();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelFactory getMetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Metamodel.impl.PersistenceConfigImpl <em>Persistence Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Metamodel.impl.PersistenceConfigImpl
		 * @see Metamodel.impl.MetamodelPackageImpl#getPersistenceConfig()
		 * @generated
		 */
		EClass PERSISTENCE_CONFIG = eINSTANCE.getPersistenceConfig();

		/**
		 * The meta object literal for the '<em><b>Dbschema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSISTENCE_CONFIG__DBSCHEMA = eINSTANCE.getPersistenceConfig_Dbschema();

		/**
		 * The meta object literal for the '<em><b>Jdbc User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSISTENCE_CONFIG__JDBC_USER_NAME = eINSTANCE.getPersistenceConfig_JdbcUserName();

		/**
		 * The meta object literal for the '{@link Metamodel.impl.RootConfigImpl <em>Root Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Metamodel.impl.RootConfigImpl
		 * @see Metamodel.impl.MetamodelPackageImpl#getRootConfig()
		 * @generated
		 */
		EClass ROOT_CONFIG = eINSTANCE.getRootConfig();

		/**
		 * The meta object literal for the '<em><b>Persistence Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONFIG__PERSISTENCE_CONFIG = eINSTANCE.getRootConfig_PersistenceConfig();

	}

} //MetamodelPackage
