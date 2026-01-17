package com.geovannycode.solid;

public final class CuentaCorriente implements Transaccionable, ImpuestoCalculable {

    private double saldo;

    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    @Override
    public void procesarTransaccion(double monto) {
        this.saldo += monto;
    }

    @Override
    public double calcularImpuestos() {
        return this.saldo * 0.003;
    }

    public double saldo() { return saldo; }
}
