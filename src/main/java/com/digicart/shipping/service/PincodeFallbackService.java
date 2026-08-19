package com.digicart.shipping.service;

import com.digicart.shipping.dto.PincodeFallbackRequest;
import com.digicart.shipping.entity.PincodeFallback;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.PincodeFallbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PincodeFallbackService {

    private final PincodeFallbackRepository repository;

    public PincodeFallbackService(PincodeFallbackRepository repository) {
        this.repository = repository;
    }

    public List<PincodeFallback> findAll() {
        return repository.findAll();
    }

    public PincodeFallback findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PincodeFallback not found: " + id));
    }

    public List<PincodeFallback> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public PincodeFallback create(PincodeFallbackRequest req) {
        PincodeFallback entity = new PincodeFallback();
        entity.setStoreId(req.getStoreId());
        entity.setPincode(req.getPincode());
        entity.setCharge(req.getCharge());
        entity.setLabel(req.getLabel());
        return repository.save(entity);
    }

    public PincodeFallback update(String id, PincodeFallbackRequest req) {
        PincodeFallback entity = findById(id);
        if (req.getPincode() != null) entity.setPincode(req.getPincode());
        if (req.getCharge() != null) entity.setCharge(req.getCharge());
        if (req.getLabel() != null) entity.setLabel(req.getLabel());
        return repository.save(entity);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
