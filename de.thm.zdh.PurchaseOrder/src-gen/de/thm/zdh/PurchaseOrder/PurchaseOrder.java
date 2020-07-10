/**
 */
package de.thm.zdh.PurchaseOrder;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Purchase Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getPoNumber <em>Po Number</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getShipTo <em>Ship To</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getBillTo <em>Bill To</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getPurchaseOrder()
 * @model
 * @generated
 */
public interface PurchaseOrder extends EObject {
	/**
	 * Returns the value of the '<em><b>Po Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Po Number</em>' attribute.
	 * @see #setPoNumber(int)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getPurchaseOrder_PoNumber()
	 * @model required="true"
	 * @generated
	 */
	int getPoNumber();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getPoNumber <em>Po Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Po Number</em>' attribute.
	 * @see #getPoNumber()
	 * @generated
	 */
	void setPoNumber(int value);

	/**
	 * Returns the value of the '<em><b>Ship To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ship To</em>' attribute.
	 * @see #setShipTo(String)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getPurchaseOrder_ShipTo()
	 * @model
	 * @generated
	 */
	String getShipTo();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getShipTo <em>Ship To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ship To</em>' attribute.
	 * @see #getShipTo()
	 * @generated
	 */
	void setShipTo(String value);

	/**
	 * Returns the value of the '<em><b>Bill To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bill To</em>' attribute.
	 * @see #setBillTo(String)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getPurchaseOrder_BillTo()
	 * @model
	 * @generated
	 */
	String getBillTo();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getBillTo <em>Bill To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bill To</em>' attribute.
	 * @see #getBillTo()
	 * @generated
	 */
	void setBillTo(String value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.zdh.PurchaseOrder.Item}.
	 * It is bidirectional and its opposite is '{@link de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder <em>Purchase Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getPurchaseOrder_Items()
	 * @see de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder
	 * @model opposite="purchaseOrder" containment="true"
	 * @generated
	 */
	EList<Item> getItems();

} // PurchaseOrder
