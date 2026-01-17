package com.geovannycode.solid;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class TipoCuentaRegistryTest {

    @Test
    void creaTipoCuentaRegistrado_sinModificarCodigoExistente_OCP() {
        var registry = new TipoCuentaRegistry(Map.of(
                "ahorro", ctx -> new CuentaAhorro(),
                "cheques", ctx -> new CuentaCheques(),
                "bonificada", ctx -> new CuentaBonificada(ctx.transacciones())
        ));

        var tipo = registry.crear("bonificada", new TipoCuentaContext(150));

        assertThat(tipo).isInstanceOf(CuentaBonificada.class);
        assertThat(tipo.calcularInteres(1000)).isEqualTo(50.0);
    }

    @Test
    void tipoDesconocido_fallaConMensajeClaro() {
        var registry = new TipoCuentaRegistry(Map.of());
        assertThatThrownBy(() -> registry.crear("x", new TipoCuentaContext(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Tipo de cuenta desconocido");
    }
}
