package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request/response DTO: Return Shipment Request.
 */
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
     * Returns return id.
     * @return the string
     */
    public String getReturnId() { return returnId; }
    /**
     * Sets return id.
     *
     * @param returnId return id
     */
    public void setReturnId(String returnId) { this.returnId = returnId; }
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
