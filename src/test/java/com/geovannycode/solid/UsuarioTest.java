package com.geovannycode.solid;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UsuarioTest {

    @Test
    void transaccionesPopulares_filtraOrdenaYLImitaSinRomperSRP() {
        var u = new Usuario(1L, "Test", List.of(
                new Transaccion(60, 30, 100),
                new Transaccion(60, 30, 500),
                new Transaccion(10, 1, 999),
                new Transaccion(80, 40, 300)
        ));

        var populares = u.transaccionesPopulares();

        assertThat(populares).hasSize(3);
        assertThat(populares.getFirst().visitas()).isEqualTo(500);
    }
}
