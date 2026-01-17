package com.geovannycode.solid;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CuentaCorrienteTest {

    @Test
    void procesarTransaccion_aumentaElSaldo() {
        // Arrange
        CuentaCorriente cuenta = new CuentaCorriente(1000);
        
        // Act
        cuenta.procesarTransaccion(500);
        
        // Assert
        assertThat(cuenta.saldo()).isEqualTo(1500);
    }
    
    @Test
    void calcularImpuestos_retornaTresPorMilDelSaldo() {
        // Arrange
        CuentaCorriente cuenta = new CuentaCorriente(10000);
        
        // Act
        double impuestos = cuenta.calcularImpuestos();
        
        // Assert
        assertThat(impuestos).isEqualTo(30.0); // 10,000 * 0.003 = 30
    }
    
    @Test
    void cuentaCorriente_implementaInterfacesRequeridas() {
        // Arrange
        CuentaCorriente cuenta = new CuentaCorriente(1000);
        
        // Assert
        assertThat(cuenta).isInstanceOf(Transaccionable.class);
        assertThat(cuenta).isInstanceOf(ImpuestoCalculable.class);
    }
}
