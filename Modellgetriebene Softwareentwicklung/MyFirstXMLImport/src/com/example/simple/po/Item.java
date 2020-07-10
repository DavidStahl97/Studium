/**
 */
package com.example.simple.po;

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
 *   <li>{@link com.example.simple.po.Item#getProductName <em>Product Name</em>}</li>
 *   <li>{@link com.example.simple.po.Item#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.example.simple.po.Item#getPrice <em>Price</em>}</li>
 * </ul>
 *
 * @see com.example.simple.po.PoPackage#getItem()
 * @model extendedMetaData="name='Item' kind='elementOnly'"
 * @generated
 */
public interface Item extends EObject {
	/**
	 * Returns the value of the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Name</em>' attribute.
	 * @see #setProductName(String)
	 * @see com.example.simple.po.PoPackage#getItem_ProductName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='productName'"
	 * @generated
	 */
	String getProductName();

	/**
	 * Sets the value of the '{@link com.example.simple.po.Item#getProductName <em>Product Name</em>}' attribute.
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
	 * @see #isSetQuantity()
	 * @see #unsetQuantity()
	 * @see #setQuantity(int)
	 * @see com.example.simple.po.PoPackage#getItem_Quantity()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='element' name='quantity'"
	 * @generated
	 */
	int getQuantity();

	/**
	 * Sets the value of the '{@link com.example.simple.po.Item#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #isSetQuantity()
	 * @see #unsetQuantity()
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(int value);

	/**
	 * Unsets the value of the '{@link com.example.simple.po.Item#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuantity()
	 * @see #getQuantity()
	 * @see #setQuantity(int)
	 * @generated
	 */
	void unsetQuantity();

	/**
	 * Returns whether the value of the '{@link com.example.simple.po.Item#getQuantity <em>Quantity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quantity</em>' attribute is set.
	 * @see #unsetQuantity()
	 * @see #getQuantity()
	 * @see #setQuantity(int)
	 * @generated
	 */
	boolean isSetQuantity();

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #isSetPrice()
	 * @see #unsetPrice()
	 * @see #setPrice(float)
	 * @see com.example.simple.po.PoPackage#getItem_Price()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float" required="true"
	 *        extendedMetaData="kind='element' name='price'"
	 * @generated
	 */
	float getPrice();

	/**
	 * Sets the value of the '{@link com.example.simple.po.Item#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #isSetPrice()
	 * @see #unsetPrice()
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(float value);

	/**
	 * Unsets the value of the '{@link com.example.simple.po.Item#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrice()
	 * @see #getPrice()
	 * @see #setPrice(float)
	 * @generated
	 */
	void unsetPrice();

	/**
	 * Returns whether the value of the '{@link com.example.simple.po.Item#getPrice <em>Price</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Price</em>' attribute is set.
	 * @see #unsetPrice()
	 * @see #getPrice()
	 * @see #setPrice(float)
	 * @generated
	 */
	boolean isSetPrice();

} // Item
