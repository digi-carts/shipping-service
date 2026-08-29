package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShipperConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

/**
 * Spring Data JPA repository for shipper config  persistence.
 */
@Repository
public interface ShipperConfigRepository extends JpaRepository<ShipperConfig, UUID> {
    Optional<ShipperConfig> findByStoreId(String storeId);
}
