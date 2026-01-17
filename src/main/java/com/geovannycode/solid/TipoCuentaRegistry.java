package com.geovannycode.solid;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

// OCP: para agregar un nuevo TipoCuenta, se registra; no se modifica lógica existente.
public final class TipoCuentaRegistry {

    private final Map<String, Function<TipoCuentaContext, TipoCuenta>> factories;

    public TipoCuentaRegistry(Map<String, Function<TipoCuentaContext, TipoCuenta>> factories) {
        this.factories = Map.copyOf(factories);
    }

    public TipoCuenta crear(String tipo, TipoCuentaContext ctx) {
        var factory = factories.get(tipo);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de cuenta desconocido: " + tipo);
        }
        return factory.apply(Objects.requireNonNull(ctx));
    }
}
