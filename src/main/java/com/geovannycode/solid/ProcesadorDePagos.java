package com.geovannycode.solid;

public abstract class ProcesadorDePagos {

    public abstract void procesarPago(Cuenta cuenta, double monto) throws ProcesamientoPagoException;

    protected final void verificarFondos(Cuenta cuenta, double monto) throws ProcesamientoPagoException {
        if (monto > cuenta.getSaldo()) {
            throw new ProcesamientoPagoException("Fondos insuficientes");
        }
    }
}
