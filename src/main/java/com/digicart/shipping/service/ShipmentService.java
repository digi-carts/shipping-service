package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipmentRequest;
import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing shipment use cases for <em>shipping-service</em>.
 */
@Service
public class ShipmentService {

    private final ShipmentRepository repository;

    /**
     * Creates a new {@code ShipmentService}.
     *
     * @param repository repository
     */
    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<Shipment> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the shipment
     */
    public Shipment findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found: " + id));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    public List<Shipment> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    /**
     * Finds by order id.
     *
     * @param orderId order identifier
     * @return the shipment
     */
    public Shipment findByOrderId(String orderId) {
        return repository.findByOrderId(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found for order: " + orderId));
    }

    /**
     * Creates a new record.
     *
     * @param req request payload
     * @return the shipment
     */
    public Shipment create(ShipmentRequest req) {
        Shipment entity = new Shipment();
        entity.setStoreId(req.getStoreId());
        entity.setOrderId(req.getOrderId());
        entity.setProvider(req.getProvider());
        entity.setAwbNumber(req.getAwbNumber());
        entity.setLabelUrl(req.getLabelUrl());
        entity.setTrackingStatus(req.getTrackingStatus());
        entity.setTrackingUrl(req.getTrackingUrl());
        if (req.getStatus() != null) entity.setStatus(req.getStatus());
        return repository.save(entity);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param req request payload
     * @return the shipment
     */
    public Shipment update(String id, ShipmentRequest req) {
        Shipment entity = findById(id);
        if (req.getProvider() != null) entity.setProvider(req.getProvider());
        if (req.getAwbNumber() != null) entity.setAwbNumber(req.getAwbNumber());
        if (req.getLabelUrl() != null) entity.setLabelUrl(req.getLabelUrl());
        if (req.getTrackingStatus() != null) entity.setTrackingStatus(req.getTrackingStatus());
        if (req.getTrackingUrl() != null) entity.setTrackingUrl(req.getTrackingUrl());
        if (req.getStatus() != null) entity.setStatus(req.getStatus());
        return repository.save(entity);
    }

    /**
     * Deletes the record.
     *
     * @param id resource identifier
     */
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
