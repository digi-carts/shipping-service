package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request/response DTO: Shipper Config Request.
 */
public class ShipperConfigRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String pickupPincode;

    private Double defaultWeight = 0.5;

    private String activeProvider;

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getPickupPincode() { return pickupPincode; }
    public void setPickupPincode(String pickupPincode) { this.pickupPincode = pickupPincode; }

    public Double getDefaultWeight() { return defaultWeight; }
    public void setDefaultWeight(Double defaultWeight) { this.defaultWeight = defaultWeight; }

    public String getActiveProvider() { return activeProvider; }
    public void setActiveProvider(String activeProvider) { this.activeProvider = activeProvider; }
}
