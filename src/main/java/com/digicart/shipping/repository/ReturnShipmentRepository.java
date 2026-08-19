package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ReturnShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for return shipment  persistence.
 */
@Repository
public interface ReturnShipmentRepository extends JpaRepository<ReturnShipment, String> {
    List<ReturnShipment> findByStoreId(String storeId);
    List<ReturnShipment> findByOrderId(String orderId);
    Optional<ReturnShipment> findByReturnId(String returnId);
}
