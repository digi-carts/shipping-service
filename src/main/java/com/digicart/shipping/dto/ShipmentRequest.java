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
     * Returns order id.
     * @return the string
     */
    public String getOrderId() { return orderId; }
    /**
     * Sets order id.
     *
     * @param orderId order identifier
     */
    public void setOrderId(String orderId) { this.orderId = orderId; }
    /**
     * Returns provider.
     * @return the string
     */
    public String getProvider() { return provider; }
    /**
     * Sets provider.
     *
     * @param provider provider
     */
    public void setProvider(String provider) { this.provider = provider; }
    /**
     * Returns awb number.
     * @return the string
     */
    public String getAwbNumber() { return awbNumber; }
    /**
     * Sets awb number.
     *
     * @param awbNumber awb number
     */
    public void setAwbNumber(String awbNumber) { this.awbNumber = awbNumber; }
    /**
     * Returns label url.
     * @return the string
     */
    public String getLabelUrl() { return labelUrl; }
    /**
     * Sets label url.
     *
     * @param labelUrl label url
     */
    public void setLabelUrl(String labelUrl) { this.labelUrl = labelUrl; }
    /**
     * Returns tracking status.
     * @return the string
     */
    public String getTrackingStatus() { return trackingStatus; }
    /**
     * Sets tracking status.
     *
     * @param trackingStatus tracking status
     */
    public void setTrackingStatus(String trackingStatus) { this.trackingStatus = trackingStatus; }
    /**
     * Returns tracking url.
     * @return the string
     */
    public String getTrackingUrl() { return trackingUrl; }
    /**
     * Sets tracking url.
     *
     * @param trackingUrl tracking url
     */
    public void setTrackingUrl(String trackingUrl) { this.trackingUrl = trackingUrl; }
    /**
     * Returns status.
     * @return the string
     */
    public String getStatus() { return status; }
    /**
     * Sets status.
     *
     * @param status status
     */
    public void setStatus(String status) { this.status = status; }
}
