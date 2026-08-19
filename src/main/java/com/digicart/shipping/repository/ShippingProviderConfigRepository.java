package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShippingProviderConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for shipping provider config  persistence.
 */
@Repository
public interface ShippingProviderConfigRepository extends JpaRepository<ShippingProviderConfig, String> {
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<ShippingProviderConfig> findByStoreId(String storeId);
    /**
     * Finds by store id and provider.
     *
     * @param storeId store (tenant) identifier
     * @param provider provider
     * @return the value if present
     */
    Optional<ShippingProviderConfig> findByStoreIdAndProvider(String storeId, String provider);
}
