/**
 */
package de.thm.zdh.PurchaseOrder.impl;

import de.thm.zdh.PurchaseOrder.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PurchaseOrderFactoryImpl extends EFactoryImpl implements PurchaseOrderFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PurchaseOrderFactory init() {
		try {
			PurchaseOrderFactory thePurchaseOrderFactory = (PurchaseOrderFactory) EPackage.Registry.INSTANCE
					.getEFactory(PurchaseOrderPackage.eNS_URI);
			if (thePurchaseOrderFactory != null) {
				return thePurchaseOrderFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PurchaseOrderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurchaseOrderFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case PurchaseOrderPackage.PURCHASE_ORDER:
			return createPurchaseOrder();
		case PurchaseOrderPackage.ITEM:
			return createItem();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurchaseOrder createPurchaseOrder() {
		PurchaseOrderImpl purchaseOrder = new PurchaseOrderImpl();
		return purchaseOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurchaseOrderPackage getPurchaseOrderPackage() {
		return (PurchaseOrderPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PurchaseOrderPackage getPackage() {
		return PurchaseOrderPackage.eINSTANCE;
	}

} //PurchaseOrderFactoryImpl
