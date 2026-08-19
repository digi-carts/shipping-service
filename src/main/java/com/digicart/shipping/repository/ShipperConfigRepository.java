package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShipperConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ShipperConfigRepository extends JpaRepository<ShipperConfig, String> {
    Optional<ShipperConfig> findByStoreId(String storeId);
}
