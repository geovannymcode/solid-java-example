package com.geovannycode.solid;


import java.util.Comparator;
import java.util.List;

public final class Usuario {

    private final long id;
    private final String nombreCompleto;
    private final List<Transaccion> transacciones;

    public Usuario(long id, String nombreCompleto, List<Transaccion> transacciones) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.transacciones = List.copyOf(transacciones);
    }

    public long id() { return id; }
    public String nombreCompleto() { return nombreCompleto; }
    public List<Transaccion> transacciones() { return transacciones; }

    // SRP: Regla de negocio vive en el dominio, no en la capa de representación.
    public List<Transaccion> transaccionesPopulares() {
        return transacciones.stream()
                .filter(t -> t.conteoLikes() > 50 && t.conteoCompartidos() > 25)
                .sorted(Comparator.comparingInt(Transaccion::visitas).reversed())
                .limit(10)
                .toList();
    }
}
