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
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<PincodeFallback> findByStoreId(String storeId);
    /**
     * Finds by store id and pincode.
     *
     * @param storeId store (tenant) identifier
     * @param pincode pincode
     * @return the value if present
     */
    Optional<PincodeFallback> findByStoreIdAndPincode(String storeId, String pincode);
}
