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

    public ShippingProviderConfigService(ShippingProviderConfigRepository repository) {
        this.repository = repository;
    }

    public List<ShippingProviderConfig> findAll() {
        return repository.findAll();
    }

    public ShippingProviderConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShippingProviderConfig not found: " + id));
    }

    public List<ShippingProviderConfig> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public ShippingProviderConfig create(ShippingProviderConfigRequest req) {
        ShippingProviderConfig entity = new ShippingProviderConfig();
        entity.setStoreId(req.getStoreId());
        entity.setProvider(req.getProvider());
        if (req.getEnabled() != null) entity.setEnabled(req.getEnabled());
        if (req.getCredentials() != null) entity.setCredentials(req.getCredentials());
        return repository.save(entity);
    }

    public ShippingProviderConfig update(String id, ShippingProviderConfigRequest req) {
        ShippingProviderConfig entity = findById(id);
        if (req.getEnabled() != null) entity.setEnabled(req.getEnabled());
        if (req.getCredentials() != null) entity.setCredentials(req.getCredentials());
        return repository.save(entity);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
