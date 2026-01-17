package com.geovannycode.solid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProcesadorDePagosLspTest {

    @Test
    void cualquierProcesador_respetaContratoLSP() throws Exception {
        var cuenta = new Cuenta(1000);

        ProcesadorDePagos visa = new ProcesadorVisa();
        visa.procesarPago(cuenta, 100);

        assertThat(cuenta.getSaldo()).isEqualTo(900);
    }

    @Test
    void fondosInsuficientes_esConsistenteEnTodaImplementacion() {
        var cuenta = new Cuenta(50);

        ProcesadorDePagos mastercard = new ProcesadorMastercard();

        assertThatThrownBy(() -> mastercard.procesarPago(cuenta, 100))
                .isInstanceOf(ProcesamientoPagoException.class)
                .hasMessageContaining("Fondos insuficientes");
    }
}
