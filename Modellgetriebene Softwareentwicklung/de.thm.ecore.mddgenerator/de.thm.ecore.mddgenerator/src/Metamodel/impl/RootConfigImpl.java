/**
 */
package Metamodel.impl;

import Metamodel.MetamodelPackage;
import Metamodel.PersistenceConfig;
import Metamodel.RootConfig;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Metamodel.impl.RootConfigImpl#getPersistenceConfig <em>Persistence Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootConfigImpl extends MinimalEObjectImpl.Container implements RootConfig {
	/**
	 * The cached value of the '{@link #getPersistenceConfig() <em>Persistence Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistenceConfig()
	 * @generated
	 * @ordered
	 */
	protected PersistenceConfig persistenceConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ROOT_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersistenceConfig getPersistenceConfig() {
		return persistenceConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPersistenceConfig(PersistenceConfig newPersistenceConfig, NotificationChain msgs) {
		PersistenceConfig oldPersistenceConfig = persistenceConfig;
		persistenceConfig = newPersistenceConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG, oldPersistenceConfig, newPersistenceConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPersistenceConfig(PersistenceConfig newPersistenceConfig) {
		if (newPersistenceConfig != persistenceConfig) {
			NotificationChain msgs = null;
			if (persistenceConfig != null)
				msgs = ((InternalEObject)persistenceConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG, null, msgs);
			if (newPersistenceConfig != null)
				msgs = ((InternalEObject)newPersistenceConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG, null, msgs);
			msgs = basicSetPersistenceConfig(newPersistenceConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG, newPersistenceConfig, newPersistenceConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG:
				return basicSetPersistenceConfig(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG:
				return getPersistenceConfig();
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
			case MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG:
				setPersistenceConfig((PersistenceConfig)newValue);
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
			case MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG:
				setPersistenceConfig((PersistenceConfig)null);
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
			case MetamodelPackage.ROOT_CONFIG__PERSISTENCE_CONFIG:
				return persistenceConfig != null;
		}
		return super.eIsSet(featureID);
	}

} //RootConfigImpl
