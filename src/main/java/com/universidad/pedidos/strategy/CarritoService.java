package com.universidad.pedidos.strategy;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarritoService {

    private final List<EstrategiaDescuento> estrategias;
    private EstrategiaDescuento activa;

    public CarritoService(List<EstrategiaDescuento> estrategias) {
        this.estrategias = estrategias;
    }

    public void activarDescuento(String nombre) {
        this.activa = estrategias.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe"));

        System.out.println("[CARRITO] Estrategia: " + activa.getNombre());
    }

    public double calcularTotal(double subtotal) {
        if (activa == null) return subtotal;

        double descuento = activa.calcular(subtotal);
        double total = subtotal - descuento;

        System.out.println("[CARRITO] Total: " + total);
        return total;
    }
}