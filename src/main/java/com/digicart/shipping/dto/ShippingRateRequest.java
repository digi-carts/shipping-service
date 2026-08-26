package com.digicart.shipping.dto;

/**
 * Request body for POST /api/shipping/rates.
 */
public class ShippingRateRequest {

    private String pincode;
    private Double weight;

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}
