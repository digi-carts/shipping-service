package com.digicart.shipping.controller;

import com.digicart.shipping.dto.ShipperConfigRequest;
import com.digicart.shipping.entity.ShipperConfig;
import com.digicart.shipping.service.ShipperConfigService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller exposing shipper config HTTP APIs for <em>shipping-service</em>.
 */
@RestController
@RequestMapping("/api/shipping/shippers")
public class ShipperConfigController {

    private final ShipperConfigService service;

    public ShipperConfigController(ShipperConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShipperConfig>> findAll(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipperConfig> findById(
            @PathVariable String id,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<ShipperConfig> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    @PostMapping
    public ResponseEntity<ShipperConfig> create(
            @Valid @RequestBody ShipperConfigRequest request,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipperConfig> update(
            @PathVariable String id,
            @Valid @RequestBody ShipperConfigRequest request,
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
}
