/**
 */
package de.thm.zdh.PurchaseOrder.impl;

import de.thm.zdh.PurchaseOrder.Item;
import de.thm.zdh.PurchaseOrder.PurchaseOrder;
import de.thm.zdh.PurchaseOrder.PurchaseOrderPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getProductName <em>Product Name</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getPurchaseOrder <em>Purchase Order</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link de.thm.zdh.PurchaseOrder.impl.ItemImpl#getRequiredBy <em>Required By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemImpl extends MinimalEObjectImpl.Container implements Item {
	/**
	 * The default value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected String productName = PRODUCT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int QUANTITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected int quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final float PRICE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected float price = PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected Item required;

	/**
	 * The cached value of the '{@link #getRequiredBy() <em>Required By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBy()
	 * @generated
	 * @ordered
	 */
	protected Item requiredBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PurchaseOrderPackage.Literals.ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductName(String newProductName) {
		String oldProductName = productName;
		productName = newProductName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__PRODUCT_NAME,
					oldProductName, productName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(int newQuantity) {
		int oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__QUANTITY, oldQuantity,
					quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrice(float newPrice) {
		float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurchaseOrder getPurchaseOrder() {
		if (eContainerFeatureID() != PurchaseOrderPackage.ITEM__PURCHASE_ORDER)
			return null;
		return (PurchaseOrder) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPurchaseOrder(PurchaseOrder newPurchaseOrder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPurchaseOrder, PurchaseOrderPackage.ITEM__PURCHASE_ORDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurchaseOrder(PurchaseOrder newPurchaseOrder) {
		if (newPurchaseOrder != eInternalContainer()
				|| (eContainerFeatureID() != PurchaseOrderPackage.ITEM__PURCHASE_ORDER && newPurchaseOrder != null)) {
			if (EcoreUtil.isAncestor(this, newPurchaseOrder))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPurchaseOrder != null)
				msgs = ((InternalEObject) newPurchaseOrder).eInverseAdd(this,
						PurchaseOrderPackage.PURCHASE_ORDER__ITEMS, PurchaseOrder.class, msgs);
			msgs = basicSetPurchaseOrder(newPurchaseOrder, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__PURCHASE_ORDER,
					newPurchaseOrder, newPurchaseOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item getRequired() {
		if (required != null && required.eIsProxy()) {
			InternalEObject oldRequired = (InternalEObject) required;
			required = (Item) eResolveProxy(oldRequired);
			if (required != oldRequired) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PurchaseOrderPackage.ITEM__REQUIRED,
							oldRequired, required));
			}
		}
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item basicGetRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequired(Item newRequired, NotificationChain msgs) {
		Item oldRequired = required;
		required = newRequired;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					PurchaseOrderPackage.ITEM__REQUIRED, oldRequired, newRequired);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(Item newRequired) {
		if (newRequired != required) {
			NotificationChain msgs = null;
			if (required != null)
				msgs = ((InternalEObject) required).eInverseRemove(this, PurchaseOrderPackage.ITEM__REQUIRED_BY,
						Item.class, msgs);
			if (newRequired != null)
				msgs = ((InternalEObject) newRequired).eInverseAdd(this, PurchaseOrderPackage.ITEM__REQUIRED_BY,
						Item.class, msgs);
			msgs = basicSetRequired(newRequired, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__REQUIRED, newRequired,
					newRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item getRequiredBy() {
		if (requiredBy != null && requiredBy.eIsProxy()) {
			InternalEObject oldRequiredBy = (InternalEObject) requiredBy;
			requiredBy = (Item) eResolveProxy(oldRequiredBy);
			if (requiredBy != oldRequiredBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PurchaseOrderPackage.ITEM__REQUIRED_BY,
							oldRequiredBy, requiredBy));
			}
		}
		return requiredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item basicGetRequiredBy() {
		return requiredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredBy(Item newRequiredBy, NotificationChain msgs) {
		Item oldRequiredBy = requiredBy;
		requiredBy = newRequiredBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					PurchaseOrderPackage.ITEM__REQUIRED_BY, oldRequiredBy, newRequiredBy);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredBy(Item newRequiredBy) {
		if (newRequiredBy != requiredBy) {
			NotificationChain msgs = null;
			if (requiredBy != null)
				msgs = ((InternalEObject) requiredBy).eInverseRemove(this, PurchaseOrderPackage.ITEM__REQUIRED,
						Item.class, msgs);
			if (newRequiredBy != null)
				msgs = ((InternalEObject) newRequiredBy).eInverseAdd(this, PurchaseOrderPackage.ITEM__REQUIRED,
						Item.class, msgs);
			msgs = basicSetRequiredBy(newRequiredBy, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PurchaseOrderPackage.ITEM__REQUIRED_BY, newRequiredBy,
					newRequiredBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPurchaseOrder((PurchaseOrder) otherEnd, msgs);
		case PurchaseOrderPackage.ITEM__REQUIRED:
			if (required != null)
				msgs = ((InternalEObject) required).eInverseRemove(this, PurchaseOrderPackage.ITEM__REQUIRED_BY,
						Item.class, msgs);
			return basicSetRequired((Item) otherEnd, msgs);
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			if (requiredBy != null)
				msgs = ((InternalEObject) requiredBy).eInverseRemove(this, PurchaseOrderPackage.ITEM__REQUIRED,
						Item.class, msgs);
			return basicSetRequiredBy((Item) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			return basicSetPurchaseOrder(null, msgs);
		case PurchaseOrderPackage.ITEM__REQUIRED:
			return basicSetRequired(null, msgs);
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			return basicSetRequiredBy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			return eInternalContainer().eInverseRemove(this, PurchaseOrderPackage.PURCHASE_ORDER__ITEMS,
					PurchaseOrder.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PurchaseOrderPackage.ITEM__PRODUCT_NAME:
			return getProductName();
		case PurchaseOrderPackage.ITEM__QUANTITY:
			return getQuantity();
		case PurchaseOrderPackage.ITEM__PRICE:
			return getPrice();
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			return getPurchaseOrder();
		case PurchaseOrderPackage.ITEM__REQUIRED:
			if (resolve)
				return getRequired();
			return basicGetRequired();
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			if (resolve)
				return getRequiredBy();
			return basicGetRequiredBy();
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
		case PurchaseOrderPackage.ITEM__PRODUCT_NAME:
			setProductName((String) newValue);
			return;
		case PurchaseOrderPackage.ITEM__QUANTITY:
			setQuantity((Integer) newValue);
			return;
		case PurchaseOrderPackage.ITEM__PRICE:
			setPrice((Float) newValue);
			return;
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			setPurchaseOrder((PurchaseOrder) newValue);
			return;
		case PurchaseOrderPackage.ITEM__REQUIRED:
			setRequired((Item) newValue);
			return;
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			setRequiredBy((Item) newValue);
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
		case PurchaseOrderPackage.ITEM__PRODUCT_NAME:
			setProductName(PRODUCT_NAME_EDEFAULT);
			return;
		case PurchaseOrderPackage.ITEM__QUANTITY:
			setQuantity(QUANTITY_EDEFAULT);
			return;
		case PurchaseOrderPackage.ITEM__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			setPurchaseOrder((PurchaseOrder) null);
			return;
		case PurchaseOrderPackage.ITEM__REQUIRED:
			setRequired((Item) null);
			return;
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			setRequiredBy((Item) null);
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
		case PurchaseOrderPackage.ITEM__PRODUCT_NAME:
			return PRODUCT_NAME_EDEFAULT == null ? productName != null : !PRODUCT_NAME_EDEFAULT.equals(productName);
		case PurchaseOrderPackage.ITEM__QUANTITY:
			return quantity != QUANTITY_EDEFAULT;
		case PurchaseOrderPackage.ITEM__PRICE:
			return price != PRICE_EDEFAULT;
		case PurchaseOrderPackage.ITEM__PURCHASE_ORDER:
			return getPurchaseOrder() != null;
		case PurchaseOrderPackage.ITEM__REQUIRED:
			return required != null;
		case PurchaseOrderPackage.ITEM__REQUIRED_BY:
			return requiredBy != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (productName: ");
		result.append(productName);
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", price: ");
		result.append(price);
		result.append(')');
		return result.toString();
	}

} //ItemImpl
