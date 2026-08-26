package com.digicart.shipping.dto;

/**
 * Response body for POST /api/shipping/rates.
 */
public class ShippingRateResponse {

    private String pincode;
    private RateOption prepaid;
    private RateOption cod;

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public RateOption getPrepaid() { return prepaid; }
    public void setPrepaid(RateOption prepaid) { this.prepaid = prepaid; }

    public RateOption getCod() { return cod; }
    public void setCod(RateOption cod) { this.cod = cod; }

    public static class RateOption {
        private boolean available;
        private double amount;
        private String label;

        public RateOption() {}

        public RateOption(boolean available, double amount, String label) {
            this.available = available;
            this.amount = amount;
            this.label = label;
        }

        public boolean isAvailable() { return available; }
        public void setAvailable(boolean available) { this.available = available; }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }

        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
    }
}
