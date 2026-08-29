package com.digicart.shipping.dto;

/**
 * Request body for PATCH /api/shipping/providers/activate.
 */
public class ActivateProviderRequest {

    private String provider;

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }
}
