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

    public PincodeFallback() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public Double getCharge() { return charge; }
    public void setCharge(Double charge) { this.charge = charge; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
}
