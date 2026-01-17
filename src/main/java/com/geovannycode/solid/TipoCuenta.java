package com.geovannycode.solid;

public sealed interface TipoCuenta permits CuentaAhorro, CuentaCheques, CuentaBonificada {
    double calcularInteres(double saldo);
    String code();
}
