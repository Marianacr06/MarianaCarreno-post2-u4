package com.universidad.pedidos.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier {

    @EventListener
    public void onConfirmado(PedidoConfirmadoEvent e) {
        System.out.println("[EMAIL] Pedido confirmado: " + e.getPedido().getId());
    }

    @EventListener
    public void onCancelado(PedidoCanceladoEvent e) {
        System.out.println("[EMAIL] Pedido cancelado: " + e.getPedido().getId());
    }
}