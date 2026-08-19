package com.digicart.shipping.repository;

import com.digicart.shipping.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    List<Shipment> findByStoreId(String storeId);
    Optional<Shipment> findByOrderId(String orderId);
}
