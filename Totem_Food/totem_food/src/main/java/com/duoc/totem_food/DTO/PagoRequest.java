package com.duoc.totem_food.DTO;

public class PagoRequest {
    private String metodoPago; 
    private boolean pagarAhora;

    // Getters y Setters
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public boolean isPagarAhora() { return pagarAhora; }
    public void setPagarAhora(boolean pagarAhora) { this.pagarAhora = pagarAhora; }
}