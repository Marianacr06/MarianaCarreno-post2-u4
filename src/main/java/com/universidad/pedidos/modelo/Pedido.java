package com.universidad.pedidos.modelo;

public class Pedido {

    private String id;
    private String estado;

    public Pedido(String id) {
        this.id = id;
        this.estado = "CREADO";
    }

    public String getId() { return id; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}