package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShippingProviderConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for shipping provider config  persistence.
 */
@Repository
public interface ShippingProviderConfigRepository extends JpaRepository<ShippingProviderConfig, UUID> {
    List<ShippingProviderConfig> findByStoreId(String storeId);
    Optional<ShippingProviderConfig> findByStoreIdAndProvider(String storeId, String provider);
}
