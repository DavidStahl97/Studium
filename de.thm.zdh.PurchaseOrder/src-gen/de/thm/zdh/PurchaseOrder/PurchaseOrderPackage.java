/**
 */
package de.thm.zdh.PurchaseOrder;

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
 * @see de.thm.zdh.PurchaseOrder.PurchaseOrderFactory
 * @model kind="package"
 * @generated
 */
public interface PurchaseOrderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PurchaseOrder";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/PurchaseOrder";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PurchaseOrder";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PurchaseOrderPackage eINSTANCE = de.thm.zdh.PurchaseOrder.impl.PurchaseOrderPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.thm.zdh.PurchaseOrder.impl.PurchaseOrderImpl <em>Purchase Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderImpl
	 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderPackageImpl#getPurchaseOrder()
	 * @generated
	 */
	int PURCHASE_ORDER = 0;

	/**
	 * The feature id for the '<em><b>Po Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER__PO_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Ship To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER__SHIP_TO = 1;

	/**
	 * The feature id for the '<em><b>Bill To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER__BILL_TO = 2;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER__ITEMS = 3;

	/**
	 * The number of structural features of the '<em>Purchase Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Purchase Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURCHASE_ORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.zdh.PurchaseOrder.impl.ItemImpl
	 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 1;

	/**
	 * The feature id for the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PRODUCT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__QUANTITY = 1;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PRICE = 2;

	/**
	 * The feature id for the '<em><b>Purchase Order</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PURCHASE_ORDER = 3;

	/**
	 * The feature id for the '<em><b>Required</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__REQUIRED = 4;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__REQUIRED_BY = 5;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder <em>Purchase Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Purchase Order</em>'.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder
	 * @generated
	 */
	EClass getPurchaseOrder();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getPoNumber <em>Po Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Po Number</em>'.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder#getPoNumber()
	 * @see #getPurchaseOrder()
	 * @generated
	 */
	EAttribute getPurchaseOrder_PoNumber();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getShipTo <em>Ship To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ship To</em>'.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder#getShipTo()
	 * @see #getPurchaseOrder()
	 * @generated
	 */
	EAttribute getPurchaseOrder_ShipTo();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getBillTo <em>Bill To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bill To</em>'.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder#getBillTo()
	 * @see #getPurchaseOrder()
	 * @generated
	 */
	EAttribute getPurchaseOrder_BillTo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.zdh.PurchaseOrder.PurchaseOrder#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see de.thm.zdh.PurchaseOrder.PurchaseOrder#getItems()
	 * @see #getPurchaseOrder()
	 * @generated
	 */
	EReference getPurchaseOrder_Items();

	/**
	 * Returns the meta object for class '{@link de.thm.zdh.PurchaseOrder.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.Item#getProductName <em>Product Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Name</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getProductName()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_ProductName();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.Item#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getQuantity()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.zdh.PurchaseOrder.Item#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getPrice()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Price();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder <em>Purchase Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Purchase Order</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getPurchaseOrder()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_PurchaseOrder();

	/**
	 * Returns the meta object for the reference '{@link de.thm.zdh.PurchaseOrder.Item#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getRequired()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_Required();

	/**
	 * Returns the meta object for the reference '{@link de.thm.zdh.PurchaseOrder.Item#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required By</em>'.
	 * @see de.thm.zdh.PurchaseOrder.Item#getRequiredBy()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_RequiredBy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PurchaseOrderFactory getPurchaseOrderFactory();

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
		 * The meta object literal for the '{@link de.thm.zdh.PurchaseOrder.impl.PurchaseOrderImpl <em>Purchase Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderImpl
		 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderPackageImpl#getPurchaseOrder()
		 * @generated
		 */
		EClass PURCHASE_ORDER = eINSTANCE.getPurchaseOrder();

		/**
		 * The meta object literal for the '<em><b>Po Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURCHASE_ORDER__PO_NUMBER = eINSTANCE.getPurchaseOrder_PoNumber();

		/**
		 * The meta object literal for the '<em><b>Ship To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURCHASE_ORDER__SHIP_TO = eINSTANCE.getPurchaseOrder_ShipTo();

		/**
		 * The meta object literal for the '<em><b>Bill To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURCHASE_ORDER__BILL_TO = eINSTANCE.getPurchaseOrder_BillTo();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PURCHASE_ORDER__ITEMS = eINSTANCE.getPurchaseOrder_Items();

		/**
		 * The meta object literal for the '{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.zdh.PurchaseOrder.impl.ItemImpl
		 * @see de.thm.zdh.PurchaseOrder.impl.PurchaseOrderPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Product Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__PRODUCT_NAME = eINSTANCE.getItem_ProductName();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__QUANTITY = eINSTANCE.getItem_Quantity();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__PRICE = eINSTANCE.getItem_Price();

		/**
		 * The meta object literal for the '<em><b>Purchase Order</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__PURCHASE_ORDER = eINSTANCE.getItem_PurchaseOrder();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__REQUIRED = eINSTANCE.getItem_Required();

		/**
		 * The meta object literal for the '<em><b>Required By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__REQUIRED_BY = eINSTANCE.getItem_RequiredBy();

	}

} //PurchaseOrderPackage
