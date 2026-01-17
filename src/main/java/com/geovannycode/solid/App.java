package com.geovannycode.solid;

import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        var usuario = new Usuario(1L, "Geovanny Mendoza", java.util.List.of(
                new Transaccion(60, 30, 1000),
                new Transaccion(10, 5, 100),
                new Transaccion(80, 40, 2000)
        ));
        System.out.println("Populares: " + usuario.transaccionesPopulares().size());

        var registry = new TipoCuentaRegistry(Map.of(
                "ahorro", ctx -> new CuentaAhorro(),
                "cheques", ctx -> new CuentaCheques(),
                "bonificada", ctx -> new CuentaBonificada(ctx.transacciones())
        ));
        var tipo = registry.crear("bonificada", new TipoCuentaContext(150));
        System.out.println("Interés: " + tipo.calcularInteres(1000));
    }
}
