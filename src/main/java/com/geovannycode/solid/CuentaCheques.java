package com.geovannycode.solid;

public final class CuentaCheques implements TipoCuenta {
    @Override public double calcularInteres(double saldo) { return 0; }
    @Override public String code() { return "cheques"; }
}
