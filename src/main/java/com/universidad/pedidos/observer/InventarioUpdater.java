package com.universidad.pedidos.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventarioUpdater {

    @EventListener
    public void onConfirmado(PedidoConfirmadoEvent e) {
        System.out.println("[INVENTARIO] Reservando stock: " + e.getPedido().getId());
    }

    @EventListener
    public void onCancelado(PedidoCanceladoEvent e) {
        System.out.println("[INVENTARIO] Liberando stock: " + e.getPedido().getId());
    }
}