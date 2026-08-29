package com.digicart.shipping.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import com.digicart.shipping.exception.GlobalExceptionHandler;
import com.digicart.shipping.controller.HealthController;
import com.digicart.shipping.controller.ShipmentController;
import com.digicart.shipping.service.ShipmentService;

@CucumberContextConfiguration
@WebMvcTest(controllers = { HealthController.class, ShipmentController.class })
@AutoConfigureMockMvc(addFilters = false)
@Import(GlobalExceptionHandler.class)
public class CucumberSpringConfiguration {
    @MockBean
    ShipmentService shipmentService;

}
