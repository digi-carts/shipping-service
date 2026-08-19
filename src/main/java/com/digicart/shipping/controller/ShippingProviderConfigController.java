package com.digicart.shipping.controller;

import com.digicart.shipping.dto.ShippingProviderConfigRequest;
import com.digicart.shipping.entity.ShippingProviderConfig;
import com.digicart.shipping.service.ShippingProviderConfigService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing shipping provider config HTTP APIs for <em>shipping-service</em>.
 */
@RestController
@RequestMapping("/api/shipping/providers")
public class ShippingProviderConfigController {

    private final ShippingProviderConfigService service;

    public ShippingProviderConfigController(ShippingProviderConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShippingProviderConfig>> findAll(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingProviderConfig> findById(
            @PathVariable String id,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ShippingProviderConfig>> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    @PostMapping
    public ResponseEntity<ShippingProviderConfig> create(
            @Valid @RequestBody ShippingProviderConfigRequest request,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingProviderConfig> update(
            @PathVariable String id,
            @Valid @RequestBody ShippingProviderConfigRequest request,
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
