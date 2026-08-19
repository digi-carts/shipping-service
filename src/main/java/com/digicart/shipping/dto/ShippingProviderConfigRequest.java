package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request/response DTO: Shipping Provider Config Request.
 */
public class ShippingProviderConfigRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String provider;

    private Boolean enabled = false;

    private String credentials = "{}";

    /**
     * Returns store id.
     * @return the string
     */
    public String getStoreId() { return storeId; }
    /**
     * Sets store id.
     *
     * @param storeId store (tenant) identifier
     */
    public void setStoreId(String storeId) { this.storeId = storeId; }
    /**
     * Returns provider.
     * @return the string
     */
    public String getProvider() { return provider; }
    /**
     * Sets provider.
     *
     * @param provider provider
     */
    public void setProvider(String provider) { this.provider = provider; }
    /**
     * Returns enabled.
     * @return the boolean
     */
    public Boolean getEnabled() { return enabled; }
    /**
     * Sets enabled.
     *
     * @param enabled enabled
     */
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    /**
     * Returns credentials.
     * @return the string
     */
    public String getCredentials() { return credentials; }
    /**
     * Sets credentials.
     *
     * @param credentials credentials
     */
    public void setCredentials(String credentials) { this.credentials = credentials; }
}
