package com.geovannycode.solid;

// DIP: depende de la abstracción ProveedorDatosCredito.
public final class EvaluacionCreditoService {

    private final ProveedorDatosCredito proveedor;

    public EvaluacionCreditoService(ProveedorDatosCredito proveedor) {
        this.proveedor = proveedor;
    }

    public double evaluar(String idCliente) {
        return proveedor.obtenerPuntuacionCredito(idCliente);
    }
}
