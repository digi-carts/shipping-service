package com.digicart.shipping.repository;

import com.digicart.shipping.entity.PincodeFallback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for pincode fallback  persistence.
 */
@Repository
public interface PincodeFallbackRepository extends JpaRepository<PincodeFallback, String> {
    List<PincodeFallback> findByStoreId(String storeId);
    Optional<PincodeFallback> findByStoreIdAndPincode(String storeId, String pincode);
}
