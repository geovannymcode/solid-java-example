package com.geovannycode.solid;

public final class ProcesadorVisa extends ProcesadorDePagos {
    @Override
    public void procesarPago(Cuenta cuenta, double monto) throws ProcesamientoPagoException {
        verificarFondos(cuenta, monto);
        cuenta.decrementarSaldo(monto);
    }
}
