package com.digicart.shipping.controller;

import com.digicart.shipping.dto.ActivateProviderRequest;
import com.digicart.shipping.dto.ShippingProviderConfigRequest;
import com.digicart.shipping.dto.UpdateProviderCredentialsRequest;
import com.digicart.shipping.entity.ShipperConfig;
import com.digicart.shipping.entity.ShippingProviderConfig;
import com.digicart.shipping.service.ShipperConfigService;
import com.digicart.shipping.service.ShippingProviderConfigService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ShipperConfigService shipperConfigService;
    private final ObjectMapper objectMapper;

    public ShippingProviderConfigController(ShippingProviderConfigService service,
                                            ShipperConfigService shipperConfigService,
                                            ObjectMapper objectMapper) {
        this.service = service;
        this.shipperConfigService = shipperConfigService;
        this.objectMapper = objectMapper;
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

    @PatchMapping("/{provider}/toggle")
    public ResponseEntity<ShippingProviderConfig> toggleProvider(
            @PathVariable String provider,
            @RequestHeader("X-Store-Id") String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.toggleEnabled(storeId, provider));
    }

    @PatchMapping("/activate")
    public ResponseEntity<ShipperConfig> activateProvider(
            @RequestBody ActivateProviderRequest request,
            @RequestHeader("X-Store-Id") String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(shipperConfigService.activateProvider(storeId, request.getProvider()));
    }

    @PostMapping("/{provider}")
    public ResponseEntity<ShippingProviderConfig> saveProviderCredentials(
            @PathVariable String provider,
            @RequestBody UpdateProviderCredentialsRequest request,
            @RequestHeader("X-Store-Id") String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        String credentialsJson;
        try {
            credentialsJson = request.getCredentials() != null
                    ? objectMapper.writeValueAsString(request.getCredentials())
                    : "{}";
        } catch (JsonProcessingException e) {
            credentialsJson = "{}";
        }
        return ResponseEntity.ok(service.upsertCredentials(storeId, provider, credentialsJson));
    }
}
