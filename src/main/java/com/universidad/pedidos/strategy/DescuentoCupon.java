package com.universidad.pedidos.strategy;

import org.springframework.stereotype.Service;

@Service
public class DescuentoCupon implements EstrategiaDescuento {

    public double calcular(double subtotal) {
        return Math.min(subtotal, 15000.0);
    }

    public String getNombre() {
        return "Cupon";
    }
}