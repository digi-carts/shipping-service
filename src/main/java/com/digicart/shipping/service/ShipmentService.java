package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipmentRequest;
import com.digicart.shipping.dto.ShippingRateResponse;
import com.digicart.shipping.entity.PincodeFallback;
import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.PincodeFallbackRepository;
import com.digicart.shipping.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Application service implementing shipment use cases for <em>shipping-service</em>.
 */
@Service
public class ShipmentService {

    private final ShipmentRepository repository;
    private final PincodeFallbackRepository pincodeFallbackRepository;

    public ShipmentService(ShipmentRepository repository, PincodeFallbackRepository pincodeFallbackRepository) {
        this.repository = repository;
        this.pincodeFallbackRepository = pincodeFallbackRepository;
    }

    public List<Shipment> findAll() {
        return repository.findAll();
    }

    public Shipment findById(String id) {
        return repository.findById(UUID.fromString(id))
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
        repository.deleteById(UUID.fromString(id));
    }

    public Shipment findByAwbNumber(String awbNumber) {
        return repository.findByAwbNumber(awbNumber)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found for AWB: " + awbNumber));
    }

    public ShippingRateResponse calculateRates(String storeId, String pincode) {
        Optional<PincodeFallback> fallback = pincodeFallbackRepository.findByStoreIdAndPincode(storeId, pincode);
        double prepaidAmount = fallback.map(PincodeFallback::getCharge).orElse(50.0);
        double codAmount = prepaidAmount + 10.0;
        String prepaidLabel = fallback
                .map(PincodeFallback::getLabel)
                .filter(l -> l != null && !l.isBlank())
                .orElse("Standard Delivery");

        ShippingRateResponse response = new ShippingRateResponse();
        response.setPincode(pincode);
        response.setPrepaid(new ShippingRateResponse.RateOption(true, prepaidAmount, prepaidLabel));
        response.setCod(new ShippingRateResponse.RateOption(true, codAmount, "Cash on Delivery"));
        return response;
    }
}
