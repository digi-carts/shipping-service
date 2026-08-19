package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipperConfigRequest;
import com.digicart.shipping.entity.ShipperConfig;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShipperConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing shipper config use cases for <em>shipping-service</em>.
 */
@Service
public class ShipperConfigService {

    private final ShipperConfigRepository repository;

    public ShipperConfigService(ShipperConfigRepository repository) {
        this.repository = repository;
    }

    public List<ShipperConfig> findAll() {
        return repository.findAll();
    }

    public ShipperConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found: " + id));
    }

    public ShipperConfig findByStoreId(String storeId) {
        return repository.findByStoreId(storeId)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found for store: " + storeId));
    }

    public ShipperConfig create(ShipperConfigRequest req) {
        ShipperConfig entity = new ShipperConfig();
        entity.setStoreId(req.getStoreId());
        entity.setPickupPincode(req.getPickupPincode());
        if (req.getDefaultWeight() != null) entity.setDefaultWeight(req.getDefaultWeight());
        entity.setActiveProvider(req.getActiveProvider());
        return repository.save(entity);
    }

    public ShipperConfig update(String id, ShipperConfigRequest req) {
        ShipperConfig entity = findById(id);
        if (req.getPickupPincode() != null) entity.setPickupPincode(req.getPickupPincode());
        if (req.getDefaultWeight() != null) entity.setDefaultWeight(req.getDefaultWeight());
        if (req.getActiveProvider() != null) entity.setActiveProvider(req.getActiveProvider());
        return repository.save(entity);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
