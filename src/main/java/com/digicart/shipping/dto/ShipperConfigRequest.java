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
     * Returns pickup pincode.
     * @return the string
     */
    public String getPickupPincode() { return pickupPincode; }
    /**
     * Sets pickup pincode.
     *
     * @param pickupPincode pickup pincode
     */
    public void setPickupPincode(String pickupPincode) { this.pickupPincode = pickupPincode; }
    /**
     * Returns default weight.
     * @return the double
     */
    public Double getDefaultWeight() { return defaultWeight; }
    /**
     * Sets default weight.
     *
     * @param defaultWeight default weight
     */
    public void setDefaultWeight(Double defaultWeight) { this.defaultWeight = defaultWeight; }
    /**
     * Returns active provider.
     * @return the string
     */
    public String getActiveProvider() { return activeProvider; }
    /**
     * Sets active provider.
     *
     * @param activeProvider active provider
     */
    public void setActiveProvider(String activeProvider) { this.activeProvider = activeProvider; }
}
