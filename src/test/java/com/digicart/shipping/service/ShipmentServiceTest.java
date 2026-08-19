package com.digicart.shipping.service;

import com.digicart.shipping.dto.ShipmentRequest;
import com.digicart.shipping.entity.Shipment;
import com.digicart.shipping.exception.EntityNotFoundException;
import com.digicart.shipping.repository.ShipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShipmentServiceTest {

    @Mock
    private ShipmentRepository repository;

    @InjectMocks
    private ShipmentService service;

    @Test
    void createDefaultsStatus() {
        ShipmentRequest req = new ShipmentRequest();
        req.setStoreId("s1");
        req.setOrderId("o1");
        req.setProvider("shiprocket");
        when(repository.save(any(Shipment.class))).thenAnswer(i -> i.getArgument(0));
        Shipment s = service.create(req);
        assertThat(s.getStatus()).isEqualTo("CREATED");
        assertThat(s.getProvider()).isEqualTo("shiprocket");
    }

    @Test
    void findByOrderIdThrows() {
        when(repository.findByOrderId("x")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.findByOrderId("x")).isInstanceOf(EntityNotFoundException.class);
    }
}
