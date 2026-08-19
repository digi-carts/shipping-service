package com.digicart.shipping.cucumber;

import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.service.ShipmentService;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;

public class ShipmentStepDefinitions {
    @Autowired
    ShipmentService shipmentService;

    @Before
    public void stubs() {
        when(shipmentService.findAll()).thenReturn(List.of(new Shipment()));
    }
}
