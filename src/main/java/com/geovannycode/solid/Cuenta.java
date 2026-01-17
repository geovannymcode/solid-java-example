package com.geovannycode.solid;

public final class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void decrementarSaldo(double monto) {
        this.saldo -= monto;
    }
}
