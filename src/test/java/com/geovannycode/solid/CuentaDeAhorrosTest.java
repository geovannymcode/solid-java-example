package com.geovannycode.solid;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CuentaDeAhorrosTest {

    @Test
    void procesarTransaccion_aumentaElSaldo() {
        // Arrange
        CuentaDeAhorros cuenta = new CuentaDeAhorros(1000);
        
        // Act
        cuenta.procesarTransaccion(500);
        
        // Assert
        assertThat(cuenta.saldo()).isEqualTo(1500);
    }
    
    @Test
    void generarInforme_muestraElSaldoActual() {
        // Arrange
        CuentaDeAhorros cuenta = new CuentaDeAhorros(1500);
        
        // Act
        String informe = cuenta.generarInforme();
        
        // Assert
        assertThat(informe).contains("1500.0");
        assertThat(informe).startsWith("Informe generado");
    }
    
    @Test
    void cuentaDeAhorros_implementaInterfacesRequeridas() {
        // Arrange
        CuentaDeAhorros cuenta = new CuentaDeAhorros(1000);
        
        // Assert
        assertThat(cuenta).isInstanceOf(Transaccionable.class);
        assertThat(cuenta).isInstanceOf(InformeGenerable.class);
    }
}
