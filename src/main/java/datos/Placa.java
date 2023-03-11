/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Admin
 */
public class Placa {

    private double superficie;
    private double precio;
    private double potencia;

    public Placa(double superficie, double precio, double potencia) {
        this.superficie = superficie;
        this.precio = precio;
        this.potencia = potencia;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public double getPrecio() {
        return this.precio;
    }

}
