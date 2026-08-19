package com.digicart.shipping.entity;

import jakarta.persistence.*;

/**
 * JPA entity mapped in this service schema (Pincode Fallback).
 */
@Entity
@Table(name = "pincode_fallback", schema = "shipping_svc")
public class PincodeFallback {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    @Column(name = "charge", nullable = false)
    private Double charge;

    @Column(name = "label")
    private String label;

    /**
     * Creates a new {@code PincodeFallback}.
     */
    public PincodeFallback() {}
    /**
     * Returns id.
     * @return the string
     */
    public String getId() { return id; }
    /**
     * Sets id.
     *
     * @param id resource identifier
     */
    public void setId(String id) { this.id = id; }
    /**
     * Returns store id.
     * @return the string
     */
    public String getStoreId() { return storeId; }
    /**
     * Sets store id.
     *
     * @param storeId store (tenant) identifier
     */
    public void setStoreId(String storeId) { this.storeId = storeId; }
    /**
     * Returns pincode.
     * @return the string
     */
    public String getPincode() { return pincode; }
    /**
     * Sets pincode.
     *
     * @param pincode pincode
     */
    public void setPincode(String pincode) { this.pincode = pincode; }
    /**
     * Returns charge.
     * @return the double
     */
    public Double getCharge() { return charge; }
    /**
     * Sets charge.
     *
     * @param charge charge
     */
    public void setCharge(Double charge) { this.charge = charge; }
    /**
     * Returns label.
     * @return the string
     */
    public String getLabel() { return label; }
    /**
     * Sets label.
     *
     * @param label label
     */
    public void setLabel(String label) { this.label = label; }
}
