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

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public Double getCharge() { return charge; }
    public void setCharge(Double charge) { this.charge = charge; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
}
