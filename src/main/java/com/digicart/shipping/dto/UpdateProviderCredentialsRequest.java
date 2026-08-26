package com.digicart.shipping.dto;

import java.util.Map;

/**
 * Request body for POST /api/shipping/providers/{provider}.
 */
public class UpdateProviderCredentialsRequest {

    private Map<String, Object> credentials;

    public Map<String, Object> getCredentials() { return credentials; }
    public void setCredentials(Map<String, Object> credentials) { this.credentials = credentials; }
}
