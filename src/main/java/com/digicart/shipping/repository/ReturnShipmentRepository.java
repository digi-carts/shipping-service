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
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<ReturnShipment> findByStoreId(String storeId);
    /**
     * Finds by order id.
     *
     * @param orderId order identifier
     * @return matching records
     */
    List<ReturnShipment> findByOrderId(String orderId);
    /**
     * Finds by return id.
     *
     * @param returnId return id
     * @return the value if present
     */
    Optional<ReturnShipment> findByReturnId(String returnId);
}
