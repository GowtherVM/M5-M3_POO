/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Admin
 */
public class Aparato {

    private String descripcion;
    private double gasto;
    private boolean interruptor = false;

    public Aparato(String descripcion, double gasto) {
        this.descripcion = descripcion;
        this.gasto = gasto;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public boolean getInterruptor() {
        return this.interruptor;
    }
    public double getGasto(){
        return this.gasto;
    }
    public void changeOn(){
        this.interruptor = true;
    }
    public void changeOff(){
        this.interruptor = false;
    }
}
