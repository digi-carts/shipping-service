package com.digicart.shipping.dto;

import jakarta.validation.constraints.NotBlank;

public class ShippingProviderConfigRequest {

    @NotBlank
    private String storeId;

    @NotBlank
    private String provider;

    private Boolean enabled = false;

    private String credentials = "{}";

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public String getCredentials() { return credentials; }
    public void setCredentials(String credentials) { this.credentials = credentials; }
}
