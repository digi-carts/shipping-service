package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShippingProviderConfigRequest;
import com.digicart.shipping.entity.ShippingProviderConfig;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShippingProviderConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing shipping provider config use cases for <em>shipping-service</em>.
 */
@Service
public class ShippingProviderConfigService {

    private final ShippingProviderConfigRepository repository;

    /**
     * Creates a new {@code ShippingProviderConfigService}.
     *
     * @param repository repository
     */
    public ShippingProviderConfigService(ShippingProviderConfigRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<ShippingProviderConfig> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the shipping provider config
     */
    public ShippingProviderConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShippingProviderConfig not found: " + id));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    public List<ShippingProviderConfig> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    /**
     * Creates a new record.
     *
     * @param req request payload
     * @return the shipping provider config
     */
    public ShippingProviderConfig create(ShippingProviderConfigRequest req) {
        ShippingProviderConfig entity = new ShippingProviderConfig();
        entity.setStoreId(req.getStoreId());
        entity.setProvider(req.getProvider());
        if (req.getEnabled() != null) entity.setEnabled(req.getEnabled());
        if (req.getCredentials() != null) entity.setCredentials(req.getCredentials());
        return repository.save(entity);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param req request payload
     * @return the shipping provider config
     */
    public ShippingProviderConfig update(String id, ShippingProviderConfigRequest req) {
        ShippingProviderConfig entity = findById(id);
        if (req.getEnabled() != null) entity.setEnabled(req.getEnabled());
        if (req.getCredentials() != null) entity.setCredentials(req.getCredentials());
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
