package com.digicart.shipping.dto;

/**
 * Request body for POST /api/shipping/config.
 */
public class UpsertShipperConfigRequest {

    private String pickupPincode;
    private Double defaultWeight;

    public String getPickupPincode() { return pickupPincode; }
    public void setPickupPincode(String pickupPincode) { this.pickupPincode = pickupPincode; }

    public Double getDefaultWeight() { return defaultWeight; }
    public void setDefaultWeight(Double defaultWeight) { this.defaultWeight = defaultWeight; }
}
