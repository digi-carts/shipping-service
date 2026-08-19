package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

public class ReturnShipmentRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String orderId;

    @NotBlank
    private String returnId;

    private String provider;
    private String awbNumber;
    private String status = "CREATED";

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getReturnId() { return returnId; }
    public void setReturnId(String returnId) { this.returnId = returnId; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getAwbNumber() { return awbNumber; }
    public void setAwbNumber(String awbNumber) { this.awbNumber = awbNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
