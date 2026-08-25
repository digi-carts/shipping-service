package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipperConfigRequest;
import com.digicart.shipping.entity.ShipperConfig;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShipperConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found: " + id));
    }

    public ShipperConfig findByStoreId(String storeId) {
        return repository.findByStoreId(storeId)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found for store: " + storeId));
    }

    public java.util.Optional<ShipperConfig> findByStoreIdOptional(String storeId) {
        return repository.findByStoreId(storeId);
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

    public ShipperConfig upsertByStoreId(String storeId, String pickupPincode, Double defaultWeight) {
        ShipperConfig entity = repository.findByStoreId(storeId).orElseGet(ShipperConfig::new);
        entity.setStoreId(storeId);
        if (pickupPincode != null) entity.setPickupPincode(pickupPincode);
        if (defaultWeight != null) entity.setDefaultWeight(defaultWeight);
        return repository.save(entity);
    }

    public ShipperConfig activateProvider(String storeId, String provider) {
        ShipperConfig entity = repository.findByStoreId(storeId)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found for store: " + storeId));
        entity.setActiveProvider(provider);
        return repository.save(entity);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(UUID.fromString(id));
    }
}
