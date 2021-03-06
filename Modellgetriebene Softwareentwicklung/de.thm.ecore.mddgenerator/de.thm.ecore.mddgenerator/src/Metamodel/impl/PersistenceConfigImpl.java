/**
 */
package Metamodel.impl;

import Metamodel.MetamodelPackage;
import Metamodel.PersistenceConfig;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Persistence Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Metamodel.impl.PersistenceConfigImpl#getDbschema <em>Dbschema</em>}</li>
 *   <li>{@link Metamodel.impl.PersistenceConfigImpl#getJdbcUserName <em>Jdbc User Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersistenceConfigImpl extends MinimalEObjectImpl.Container implements PersistenceConfig {
	/**
	 * The default value of the '{@link #getDbschema() <em>Dbschema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbschema()
	 * @generated
	 * @ordered
	 */
	protected static final String DBSCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbschema() <em>Dbschema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbschema()
	 * @generated
	 * @ordered
	 */
	protected String dbschema = DBSCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getJdbcUserName() <em>Jdbc User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String JDBC_USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJdbcUserName() <em>Jdbc User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcUserName()
	 * @generated
	 * @ordered
	 */
	protected String jdbcUserName = JDBC_USER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersistenceConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.PERSISTENCE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDbschema() {
		return dbschema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDbschema(String newDbschema) {
		String oldDbschema = dbschema;
		dbschema = newDbschema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PERSISTENCE_CONFIG__DBSCHEMA, oldDbschema, dbschema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJdbcUserName() {
		return jdbcUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJdbcUserName(String newJdbcUserName) {
		String oldJdbcUserName = jdbcUserName;
		jdbcUserName = newJdbcUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PERSISTENCE_CONFIG__JDBC_USER_NAME, oldJdbcUserName, jdbcUserName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.PERSISTENCE_CONFIG__DBSCHEMA:
				return getDbschema();
			case MetamodelPackage.PERSISTENCE_CONFIG__JDBC_USER_NAME:
				return getJdbcUserName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.PERSISTENCE_CONFIG__DBSCHEMA:
				setDbschema((String)newValue);
				return;
			case MetamodelPackage.PERSISTENCE_CONFIG__JDBC_USER_NAME:
				setJdbcUserName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.PERSISTENCE_CONFIG__DBSCHEMA:
				setDbschema(DBSCHEMA_EDEFAULT);
				return;
			case MetamodelPackage.PERSISTENCE_CONFIG__JDBC_USER_NAME:
				setJdbcUserName(JDBC_USER_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.PERSISTENCE_CONFIG__DBSCHEMA:
				return DBSCHEMA_EDEFAULT == null ? dbschema != null : !DBSCHEMA_EDEFAULT.equals(dbschema);
			case MetamodelPackage.PERSISTENCE_CONFIG__JDBC_USER_NAME:
				return JDBC_USER_NAME_EDEFAULT == null ? jdbcUserName != null : !JDBC_USER_NAME_EDEFAULT.equals(jdbcUserName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (dbschema: ");
		result.append(dbschema);
		result.append(", jdbcUserName: ");
		result.append(jdbcUserName);
		result.append(')');
		return result.toString();
	}

} //PersistenceConfigImpl
