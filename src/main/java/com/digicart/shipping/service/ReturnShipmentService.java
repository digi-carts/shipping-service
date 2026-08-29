package com.digicart.shipping.service;

import com.digicart.shipping.dto.ReturnShipmentRequest;
import com.digicart.shipping.entity.ReturnShipment;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ReturnShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Application service implementing return shipment use cases for <em>shipping-service</em>.
 */
@Service
public class ReturnShipmentService {

    private final ReturnShipmentRepository repository;

    public ReturnShipmentService(ReturnShipmentRepository repository) {
        this.repository = repository;
    }

    public List<ReturnShipment> findAll() {
        return repository.findAll();
    }

    public ReturnShipment findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("ReturnShipment not found: " + id));
    }

    public List<ReturnShipment> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public List<ReturnShipment> findByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    public ReturnShipment create(ReturnShipmentRequest req) {
        ReturnShipment entity = new ReturnShipment();
        entity.setStoreId(req.getStoreId());
        entity.setOrderId(req.getOrderId());
        entity.setReturnId(req.getReturnId());
        entity.setProvider(req.getProvider());
        entity.setAwbNumber(req.getAwbNumber());
        if (req.getStatus() != null) entity.setStatus(req.getStatus());
        return repository.save(entity);
    }

    public ReturnShipment update(String id, ReturnShipmentRequest req) {
        ReturnShipment entity = findById(id);
        if (req.getProvider() != null) entity.setProvider(req.getProvider());
        if (req.getAwbNumber() != null) entity.setAwbNumber(req.getAwbNumber());
        if (req.getStatus() != null) entity.setStatus(req.getStatus());
        return repository.save(entity);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(UUID.fromString(id));
    }
}
