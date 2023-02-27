/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03mooespinosap;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Cliente {

    private String nif;
    private String nom;
    private double mm;
    private boolean interruptor = true;
    private ArrayList<Placa> placas = new ArrayList();
    private ArrayList<Aparato> aparatos = new ArrayList();

    public Cliente(String nif, String nom, double mm) {
        this.nif = nif;
        this.nom = nom;
        this.mm = mm;
    }

    public void addPlaca(Placa nuevaplaca) {
        placas.add(nuevaplaca);

    }

    public void addAparato(Aparato nuevoaparato) {
        aparatos.add(nuevoaparato);
    }

    public String getNif() {
        return this.nif;
    }

    public String getNom() {
        return this.nom;
    }

    public double getMm() {
        return this.mm;
    }

    public int onCasa() {
        if (interruptor != true) {
            interruptor = true;
            return 2;
        } else {
            return 1;
        }

    }

    public void onAparell(String descripcion, Condiciones condicion) {

        for (Aparato aparato : aparatos) {
            if (descripcion.equalsIgnoreCase(aparato.getDescripcion())) {
                if (aparato.getInterruptor() == true) {

                    condicion.getError(19);

                } else {
                    aparato.changeOn();
                    condicion.getCorrecto(3);
                }
            } else {
                condicion.getError(24);
            }
        }

    }

    public void offAparell(String descripcion, Condiciones condicion) {
        for (Aparato aparato : aparatos) {
            if (descripcion.equalsIgnoreCase(aparato.getDescripcion())) {
                if (aparato.getInterruptor() == false) {
                   condicion.getError(25);
                } else {
                    aparato.changeOff();
                    condicion.getCorrecto(4);
                }
            } else {
                condicion.getError(24);
            }
        }
    }

}
