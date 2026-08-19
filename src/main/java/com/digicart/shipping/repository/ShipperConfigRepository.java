package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShipperConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * Spring Data JPA repository for shipper config  persistence.
 */
@Repository
public interface ShipperConfigRepository extends JpaRepository<ShipperConfig, String> {
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return the value if present
     */
    Optional<ShipperConfig> findByStoreId(String storeId);
}
