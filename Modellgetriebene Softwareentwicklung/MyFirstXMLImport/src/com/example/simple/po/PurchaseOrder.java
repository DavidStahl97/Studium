/**
 */
package com.example.simple.po;

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
 *   <li>{@link com.example.simple.po.PurchaseOrder#getPoNumber <em>Po Number</em>}</li>
 *   <li>{@link com.example.simple.po.PurchaseOrder#getShipTo <em>Ship To</em>}</li>
 *   <li>{@link com.example.simple.po.PurchaseOrder#getBillTo <em>Bill To</em>}</li>
 *   <li>{@link com.example.simple.po.PurchaseOrder#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see com.example.simple.po.PoPackage#getPurchaseOrder()
 * @model extendedMetaData="name='PurchaseOrder' kind='elementOnly'"
 * @generated
 */
public interface PurchaseOrder extends EObject {
	/**
	 * Returns the value of the '<em><b>Po Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Po Number</em>' attribute.
	 * @see #setPoNumber(String)
	 * @see com.example.simple.po.PoPackage#getPurchaseOrder_PoNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='poNumber'"
	 * @generated
	 */
	String getPoNumber();

	/**
	 * Sets the value of the '{@link com.example.simple.po.PurchaseOrder#getPoNumber <em>Po Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Po Number</em>' attribute.
	 * @see #getPoNumber()
	 * @generated
	 */
	void setPoNumber(String value);

	/**
	 * Returns the value of the '<em><b>Ship To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ship To</em>' attribute.
	 * @see #setShipTo(String)
	 * @see com.example.simple.po.PoPackage#getPurchaseOrder_ShipTo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='shipTo'"
	 * @generated
	 */
	String getShipTo();

	/**
	 * Sets the value of the '{@link com.example.simple.po.PurchaseOrder#getShipTo <em>Ship To</em>}' attribute.
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
	 * @see com.example.simple.po.PoPackage#getPurchaseOrder_BillTo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='billTo'"
	 * @generated
	 */
	String getBillTo();

	/**
	 * Sets the value of the '{@link com.example.simple.po.PurchaseOrder#getBillTo <em>Bill To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bill To</em>' attribute.
	 * @see #getBillTo()
	 * @generated
	 */
	void setBillTo(String value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.simple.po.Item}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.example.simple.po.PoPackage#getPurchaseOrder_Items()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='items'"
	 * @generated
	 */
	EList<Item> getItems();

} // PurchaseOrder
