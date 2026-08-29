package com.digicart.shipping.controller;

import com.digicart.shipping.dto.PincodeFallbackRequest;
import com.digicart.shipping.entity.PincodeFallback;
import com.digicart.shipping.service.PincodeFallbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing pincode fallback HTTP APIs for <em>shipping-service</em>.
 */
@RestController
@RequestMapping("/api/shipping/pincodes")
public class PincodeFallbackController {

    private final PincodeFallbackService service;

    public PincodeFallbackController(PincodeFallbackService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PincodeFallback>> findAll(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PincodeFallback> findById(
            @PathVariable String id,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<PincodeFallback>> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    @PostMapping
    public ResponseEntity<PincodeFallback> create(
            @Valid @RequestBody PincodeFallbackRequest request,
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-User-Role") String userRole) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PincodeFallback> update(
            @PathVariable String id,
            @Valid @RequestBody PincodeFallbackRequest request,
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
