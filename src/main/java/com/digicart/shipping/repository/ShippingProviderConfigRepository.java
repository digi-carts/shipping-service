package com.digicart.shipping.repository;

import com.digicart.shipping.entity.ShippingProviderConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingProviderConfigRepository extends JpaRepository<ShippingProviderConfig, String> {
    List<ShippingProviderConfig> findByStoreId(String storeId);
    Optional<ShippingProviderConfig> findByStoreIdAndProvider(String storeId, String provider);
}
