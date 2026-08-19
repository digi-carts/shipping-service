package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipmentRequest;
import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public List<Shipment> findAll() {
        return repository.findAll();
    }

    public Shipment findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found: " + id));
    }

    public List<Shipment> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public Shipment findByOrderId(String orderId) {
        return repository.findByOrderId(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found for order: " + orderId));
    }

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

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
