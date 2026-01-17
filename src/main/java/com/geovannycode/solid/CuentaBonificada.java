package com.geovannycode.solid;

public final class CuentaBonificada implements TipoCuenta {

    private final int transacciones;

    public CuentaBonificada(int transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public double calcularInteres(double saldo) {
        return transacciones > 100 ? saldo * 0.05 : 0;
    }

    @Override public String code() { return "bonificada"; }
}

