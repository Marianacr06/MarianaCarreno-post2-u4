package com.universidad.pedidos;

import com.universidad.pedidos.strategy.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    private CarritoService build() {
        return new CarritoService(List.of(
                new DescuentoTemporada(),
                new DescuentoVIP(),
                new DescuentoCupon()
        ));
    }

    @Test
    void testTemporada() {
        var c = build();
        c.activarDescuento("Temporada");
        assertEquals(80000, c.calcularTotal(100000), 0.01);
    }

    @Test
    void testVIP() {
        var c = build();
        c.activarDescuento("VIP");
        assertEquals(70000, c.calcularTotal(100000), 0.01);
    }

    @Test
    void testCupon() {
        var c = build();
        c.activarDescuento("Cupon");
        assertEquals(85000, c.calcularTotal(100000), 0.01);
    }
}