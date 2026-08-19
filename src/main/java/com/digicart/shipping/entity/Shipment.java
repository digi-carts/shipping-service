package com.digicart.shipping.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * JPA entity mapped in this service schema (Shipment).
 */
@Entity
@Table(name = "shipment", schema = "shipping_svc")
@EntityListeners(AuditingEntityListener.class)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "order_id", nullable = false, unique = true)
    private String orderId;

    @Column(name = "provider")
    private String provider;

    @Column(name = "awb_number")
    private String awbNumber;

    @Column(name = "label_url")
    private String labelUrl;

    @Column(name = "tracking_status")
    private String trackingStatus;

    @Column(name = "tracking_url")
    private String trackingUrl;

    @Column(name = "status", nullable = false)
    private String status = "CREATED";

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /**
     * Creates a new {@code Shipment}.
     */
    public Shipment() {}
    /**
     * Returns id.
     * @return the string
     */
    public String getId() { return id; }
    /**
     * Sets id.
     *
     * @param id resource identifier
     */
    public void setId(String id) { this.id = id; }
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
    /**
     * Returns created at.
     * @return the instant
     */
    public Instant getCreatedAt() { return createdAt; }
    /**
     * Sets created at.
     *
     * @param createdAt created at
     */
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    /**
     * Returns updated at.
     * @return the instant
     */
    public Instant getUpdatedAt() { return updatedAt; }
    /**
     * Sets updated at.
     *
     * @param updatedAt updated at
     */
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
