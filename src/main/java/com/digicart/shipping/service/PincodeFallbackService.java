package com.digicart.shipping.service;

import com.digicart.shipping.dto.PincodeFallbackRequest;
import com.digicart.shipping.entity.PincodeFallback;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.PincodeFallbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing pincode fallback use cases for <em>shipping-service</em>.
 */
@Service
public class PincodeFallbackService {

    private final PincodeFallbackRepository repository;

    /**
     * Creates a new {@code PincodeFallbackService}.
     *
     * @param repository repository
     */
    public PincodeFallbackService(PincodeFallbackRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<PincodeFallback> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the pincode fallback
     */
    public PincodeFallback findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PincodeFallback not found: " + id));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    public List<PincodeFallback> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    /**
     * Creates a new record.
     *
     * @param req request payload
     * @return the pincode fallback
     */
    public PincodeFallback create(PincodeFallbackRequest req) {
        PincodeFallback entity = new PincodeFallback();
        entity.setStoreId(req.getStoreId());
        entity.setPincode(req.getPincode());
        entity.setCharge(req.getCharge());
        entity.setLabel(req.getLabel());
        return repository.save(entity);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param req request payload
     * @return the pincode fallback
     */
    public PincodeFallback update(String id, PincodeFallbackRequest req) {
        PincodeFallback entity = findById(id);
        if (req.getPincode() != null) entity.setPincode(req.getPincode());
        if (req.getCharge() != null) entity.setCharge(req.getCharge());
        if (req.getLabel() != null) entity.setLabel(req.getLabel());
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
