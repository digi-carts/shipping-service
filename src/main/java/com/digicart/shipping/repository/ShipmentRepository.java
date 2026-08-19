package com.digicart.shipping.repository;

import com.digicart.shipping.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for shipment  persistence.
 */
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<Shipment> findByStoreId(String storeId);
    /**
     * Finds by order id.
     *
     * @param orderId order identifier
     * @return the value if present
     */
    Optional<Shipment> findByOrderId(String orderId);
}
