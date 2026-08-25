package com.digicart.shipping.controller;

import com.digicart.shipping.dto.ShipmentRequest;
import com.digicart.shipping.dto.ShippingRateRequest;
import com.digicart.shipping.dto.ShippingRateResponse;
import com.digicart.shipping.dto.UpsertShipperConfigRequest;
import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.entity.ShipperConfig;
import com.digicart.shipping.service.ShipmentService;
import com.digicart.shipping.service.ShipperConfigService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller exposing shipment HTTP APIs for <em>shipping-service</em>.
 */
@RestController
@RequestMapping("/api/shipping")
public class ShipmentController {

    private final ShipmentService service;
    private final ShipperConfigService shipperConfigService;

    public ShipmentController(ShipmentService service, ShipperConfigService shipperConfigService) {
        this.service = service;
        this.shipperConfigService = shipperConfigService;
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> findAll(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> findById(
            @PathVariable String id,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Shipment>> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Shipment> findByOrderId(
            @PathVariable String orderId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }

    @PostMapping
    public ResponseEntity<Shipment> create(
            @Valid @RequestBody ShipmentRequest request,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> update(
            @PathVariable String id,
            @Valid @RequestBody ShipmentRequest request,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/rates")
    public ResponseEntity<ShippingRateResponse> calculateRates(
            @RequestBody ShippingRateRequest request,
            @RequestHeader("X-Store-Id") String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.calculateRates(storeId, request.getPincode()));
    }

    @GetMapping("/track/{trackingId}")
    public ResponseEntity<Map<String, Object>> trackShipment(
            @PathVariable String trackingId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        Shipment shipment = service.findByAwbNumber(trackingId);
        String status = shipment.getTrackingStatus() != null ? shipment.getTrackingStatus() : "IN_TRANSIT";
        return ResponseEntity.ok(Map.of(
                "trackingId", trackingId,
                "status", status,
                "events", List.of()
        ));
    }

    @PostMapping("/config")
    public ResponseEntity<ShipperConfig> upsertConfig(
            @RequestBody UpsertShipperConfigRequest request,
            @RequestHeader("X-Store-Id") String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        ShipperConfig updated = shipperConfigService.upsertByStoreId(
                storeId, request.getPickupPincode(), request.getDefaultWeight());
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/config")
    public ResponseEntity<Map<String, Object>> getConfig(
            @RequestHeader("X-Store-Id") String storeId) {
        return shipperConfigService.findByStoreIdOptional(storeId)
                .map(c -> {
                    Map<String, Object> cfg = new java.util.LinkedHashMap<>();
                    cfg.put("id", c.getId().toString());
                    cfg.put("storeId", c.getStoreId());
                    cfg.put("pickupPincode", c.getPickupPincode());
                    cfg.put("activeProvider", c.getActiveProvider());
                    cfg.put("defaultWeight", c.getDefaultWeight());
                    return ResponseEntity.ok(Map.of("config", cfg));
                })
                .orElse(ResponseEntity.ok(Map.of("config", (Object) null)));
    }
}
