package com.digicart.shipping.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * JPA entity mapped in this service schema (Shipper Config).
 */
@Entity
@Table(name = "shipper_config", schema = "shipping_svc")
@EntityListeners(AuditingEntityListener.class)
public class ShipperConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "store_id", nullable = false, unique = true)
    private String storeId;

    @Column(name = "pickup_pincode", nullable = false)
    private String pickupPincode;

    @Column(name = "default_weight")
    private Double defaultWeight = 0.5;

    @Column(name = "active_provider")
    private String activeProvider;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /**
     * Creates a new {@code ShipperConfig}.
     */
    public ShipperConfig() {}
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
