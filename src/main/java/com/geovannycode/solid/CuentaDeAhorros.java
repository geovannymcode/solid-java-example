package com.geovannycode.solid;

public final class CuentaDeAhorros implements Transaccionable, InformeGenerable {

    private double saldo;

    public CuentaDeAhorros(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    @Override
    public void procesarTransaccion(double monto) {
        this.saldo += monto;
    }

    @Override
    public String generarInforme() {
        return "Informe generado para la cuenta con saldo: " + this.saldo;
    }

    public double saldo() { return saldo; }
}
