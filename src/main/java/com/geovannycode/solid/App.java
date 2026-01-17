package com.geovannycode.solid;

public class App {
    public static void main(String[] args) throws Exception {
        var usuario = new Usuario(1L, "Geovanny Mendoza", java.util.List.of(
                new Transaccion(60, 30, 1000),
                new Transaccion(10, 5, 100),
                new Transaccion(80, 40, 2000)
        ));
        System.out.println("Populares: " + usuario.transaccionesPopulares().size());
    }
}
