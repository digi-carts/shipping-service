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

    /**
     * Creates a new {@code ShipperConfigService}.
     *
     * @param repository repository
     */
    public ShipperConfigService(ShipperConfigRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<ShipperConfig> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the shipper config
     */
    public ShipperConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found: " + id));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return the shipper config
     */
    public ShipperConfig findByStoreId(String storeId) {
        return repository.findByStoreId(storeId)
                .orElseThrow(() -> new EntityNotFoundException("ShipperConfig not found for store: " + storeId));
    }

    /**
     * Creates a new record.
     *
     * @param req request payload
     * @return the shipper config
     */
    public ShipperConfig create(ShipperConfigRequest req) {
        ShipperConfig entity = new ShipperConfig();
        entity.setStoreId(req.getStoreId());
        entity.setPickupPincode(req.getPickupPincode());
        if (req.getDefaultWeight() != null) entity.setDefaultWeight(req.getDefaultWeight());
        entity.setActiveProvider(req.getActiveProvider());
        return repository.save(entity);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param req request payload
     * @return the shipper config
     */
    public ShipperConfig update(String id, ShipperConfigRequest req) {
        ShipperConfig entity = findById(id);
        if (req.getPickupPincode() != null) entity.setPickupPincode(req.getPickupPincode());
        if (req.getDefaultWeight() != null) entity.setDefaultWeight(req.getDefaultWeight());
        if (req.getActiveProvider() != null) entity.setActiveProvider(req.getActiveProvider());
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
