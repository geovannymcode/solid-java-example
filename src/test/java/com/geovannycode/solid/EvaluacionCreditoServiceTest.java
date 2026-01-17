package com.geovannycode.solid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluacionCreditoServiceTest {

    @Test
    void dependeDeAbstraccion_ySeTesteaConFake_DIP() {
        ProveedorDatosCredito fake = id -> 777.0;

        var service = new EvaluacionCreditoService(fake);

        assertThat(service.evaluar("abc")).isEqualTo(777.0);
    }
}
