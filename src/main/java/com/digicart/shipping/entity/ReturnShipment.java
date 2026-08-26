package com.digicart.shipping.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

/**
 * JPA entity mapped in this service schema (Return Shipment).
 */
@Entity
@Table(name = "return_shipment", schema = "shipping_svc")
@EntityListeners(AuditingEntityListener.class)
public class ReturnShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "return_id", nullable = false, unique = true)
    private String returnId;

    @Column(name = "provider")
    private String provider;

    @Column(name = "awb_number")
    private String awbNumber;

    @Column(name = "status", nullable = false)
    private String status = "CREATED";

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public ReturnShipment() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
