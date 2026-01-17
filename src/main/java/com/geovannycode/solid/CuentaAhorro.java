package com.geovannycode.solid;

public final class CuentaAhorro implements TipoCuenta {
    @Override public double calcularInteres(double saldo) { return saldo * 0.02; }
    @Override public String code() { return "ahorro"; }
}
