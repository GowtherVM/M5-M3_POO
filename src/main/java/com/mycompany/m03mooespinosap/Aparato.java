/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03mooespinosap;

/**
 *
 * @author Admin
 */
public class Aparato {

    private String descripcion;
    private float gasto;
    private boolean interruptor = true;

    public Aparato(String descripcion, float gasto) {
        this.descripcion = descripcion;
        this.gasto = gasto;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public boolean getInterruptor() {
        return this.interruptor;
    }
    public void changeOn(){
        this.interruptor = true;
    }
    public void changeOff(){
        this.interruptor = false;
    }
}
