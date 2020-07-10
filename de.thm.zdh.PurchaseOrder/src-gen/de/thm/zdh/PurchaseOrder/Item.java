/**
 */
package de.thm.zdh.PurchaseOrder;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getProductName <em>Product Name</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getPrice <em>Price</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder <em>Purchase Order</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getRequired <em>Required</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.Item#getRequiredBy <em>Required By</em>}</li>
 * </ul>
 *
 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends EObject {
	/**
	 * Returns the value of the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Name</em>' attribute.
	 * @see #setProductName(String)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_ProductName()
	 * @model required="true"
	 * @generated
	 */
	String getProductName();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getProductName <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Name</em>' attribute.
	 * @see #getProductName()
	 * @generated
	 */
	void setProductName(String value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(int)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_Quantity()
	 * @model required="true"
	 * @generated
	 */
	int getQuantity();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(int value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(float)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_Price()
	 * @model required="true"
	 * @generated
	 */
	float getPrice();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(float value);

	/**
	 * Returns the value of the '<em><b>Purchase Order</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purchase Order</em>' container reference.
	 * @see #setPurchaseOrder(PurchaseOrder)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_PurchaseOrder()
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder#getItems
	 * @model opposite="items" required="true" transient="false"
	 * @generated
	 */
	PurchaseOrder getPurchaseOrder();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder <em>Purchase Order</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purchase Order</em>' container reference.
	 * @see #getPurchaseOrder()
	 * @generated
	 */
	void setPurchaseOrder(PurchaseOrder value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.zdh.PurchaseOrder.Item#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' reference.
	 * @see #setRequired(Item)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_Required()
	 * @see de.thm.zdh.PurchaseOrder.Item#getRequiredBy
	 * @model opposite="requiredBy"
	 * @generated
	 */
	Item getRequired();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getRequired <em>Required</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' reference.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(Item value);

	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.zdh.PurchaseOrder.Item#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference.
	 * @see #setRequiredBy(Item)
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderPackage#getItem_RequiredBy()
	 * @see de.thm.zdh.PurchaseOrder.Item#getRequired
	 * @model opposite="required"
	 * @generated
	 */
	Item getRequiredBy();

	/**
	 * Sets the value of the '{@link de.thm.zdh.PurchaseOrder.Item#getRequiredBy <em>Required By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required By</em>' reference.
	 * @see #getRequiredBy()
	 * @generated
	 */
	void setRequiredBy(Item value);

} // Item
