package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request/response DTO: Shipment Request.
 */
public class ShipmentRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String orderId;

    private String provider;
    private String awbNumber;
    private String labelUrl;
    private String trackingStatus;
    private String trackingUrl;
    private String status = "CREATED";

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getAwbNumber() { return awbNumber; }
    public void setAwbNumber(String awbNumber) { this.awbNumber = awbNumber; }

    public String getLabelUrl() { return labelUrl; }
    public void setLabelUrl(String labelUrl) { this.labelUrl = labelUrl; }

    public String getTrackingStatus() { return trackingStatus; }
    public void setTrackingStatus(String trackingStatus) { this.trackingStatus = trackingStatus; }

    public String getTrackingUrl() { return trackingUrl; }
    public void setTrackingUrl(String trackingUrl) { this.trackingUrl = trackingUrl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
