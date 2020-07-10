/**
 */
package de.thm.zdh.PurchaseOrder;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage
 * @generated
 */
public interface PurchaseOrderFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PurchaseOrderFactory eINSTANCE = de.thm.zdh.PurchaseOrder.impl.PurchaseOrderFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Purchase Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Purchase Order</em>'.
	 * @generated
	 */
	PurchaseOrder createPurchaseOrder();

	/**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	Item createItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PurchaseOrderPackage getPurchaseOrderPackage();

} //PurchaseOrderFactory
