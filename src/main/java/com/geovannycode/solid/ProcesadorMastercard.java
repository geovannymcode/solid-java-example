package com.geovannycode.solid;

public final class ProcesadorMastercard extends ProcesadorDePagos {
    private static final double COMISION = 1.1;

    @Override
    public void procesarPago(Cuenta cuenta, double monto) throws ProcesamientoPagoException {
        double total = monto * COMISION;
        verificarFondos(cuenta, total);
        cuenta.decrementarSaldo(total);
    }
}
