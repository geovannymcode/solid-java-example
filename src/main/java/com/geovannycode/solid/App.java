package com.geovannycode.solid;

import java.util.Map;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCARIO - DEMO PRINCIPIOS SOLID ===\n");
        
        // 1. Demo de procesamiento de transacciones con diferentes tipos de cuentas
        demoTransacciones();
        
        // 2. Demo de generación de informes
        demoInformes();
        
        // 3. Demo de cálculo de impuestos
        demoImpuestos();
        
        // 4. Demo de funcionalidades existentes
        demoFuncionalidadesExistentes();
    }
    
    private static void demoTransacciones() {
        System.out.println("\n--- Procesamiento de Transacciones ---");
        
        // Crear cuentas
        Transaccionable cuentaCorriente = new CuentaCorriente(1000);
        Transaccionable cuentaAhorros = new CuentaDeAhorros(500);
        
        // Realizar transacciones
        cuentaCorriente.procesarTransaccion(500);
        cuentaAhorros.procesarTransaccion(200);
        
        System.out.println("Saldo en cuenta corriente: " + ((CuentaCorriente)cuentaCorriente).saldo());
        System.out.println("Saldo en cuenta de ahorros: " + ((CuentaDeAhorros)cuentaAhorros).saldo());
    }
    
    private static void demoInformes() {
        System.out.println("\n--- Generación de Informes ---");
        
        // Crear cuenta de ahorros que implementa InformeGenerable
        CuentaDeAhorros cuentaAhorros = new CuentaDeAhorros(1500);
        cuentaAhorros.procesarTransaccion(300);
        
        System.out.println("Informe de cuenta de ahorros: " + cuentaAhorros.generarInforme());
    }
    
    private static void demoImpuestos() {
        System.out.println("\n--- Cálculo de Impuestos ---");
        
        // Crear cuenta corriente que implementa ImpuestoCalculable
        CuentaCorriente cuentaCorriente = new CuentaCorriente(10000);
        cuentaCorriente.procesarTransaccion(5000);
        
        System.out.println("Impuestos a pagar: " + cuentaCorriente.calcularImpuestos());
    }
    
    private static void demoFuncionalidadesExistentes() {
        System.out.println("\n--- Funcionalidades Existentes ---");
        
        // Demo de usuario y transacciones populares
        var usuario = new Usuario(1L, "Geovanny Mendoza", List.of(
                new Transaccion(60, 30, 1000),
                new Transaccion(10, 5, 100),
                new Transaccion(80, 40, 2000)
        ));
        System.out.println("Transacciones populares: " + usuario.transaccionesPopulares().size());
        
        // Demo de registro de tipos de cuenta
        var registry = new TipoCuentaRegistry(Map.of(
                "ahorro", ctx -> new CuentaAhorro(),
                "cheques", ctx -> new CuentaCheques(),
                "bonificada", ctx -> new CuentaBonificada(ctx.transacciones())
        ));
        var tipo = registry.crear("bonificada", new TipoCuentaContext(150));
        System.out.println("Interés calculado: " + tipo.calcularInteres(1000));
        
        // Demo de procesamiento de pagos
        var cuenta = new Cuenta(1000);
        try {
            new ProcesadorMastercard().procesarPago(cuenta, 100);
            System.out.println("Pago procesado. Saldo restante: " + cuenta.getSaldo());
        } catch (ProcesamientoPagoException e) {
            System.err.println("Error al procesar pago: " + e.getMessage());
        }
        
        // Demo de evaluación de crédito
        var service = new EvaluacionCreditoService(new EquifaxProveedor());
        System.out.println("Score crediticio: " + service.evaluar("123"));
    }
}
