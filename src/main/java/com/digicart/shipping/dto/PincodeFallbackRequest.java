package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request/response DTO: Pincode Fallback Request.
 */
public class PincodeFallbackRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String pincode;

    @NotNull
    private Double charge;

    private String label;

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
