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

    public int onCasa() {
        if (interruptor != true) {
            interruptor = true;
            return 2;
        } else {
            return 1;
        }

    }

    public int onAparell(String descripcion) {
        for (Aparato aparato : aparatos) {
            if (descripcion == aparato.getDescripcion()) {
                if (aparato.getInterruptor() == true) {
                    return 7;
                } else {
                    aparato.changeOn();
                    return 8;
                }
            } else {
                return 6;
            }
        }
        return 0;
    }

    public int offAparell(String descripcion) {
        for (Aparato aparato : aparatos) {
            if (descripcion == aparato.getDescripcion()) {
                if (aparato.getInterruptor() == false) {
                    return 9;
                } else {
                    aparato.changeOff();
                    return 10;
                }
            } else {
                return 6;
            }
        }
        return 0;
    }

}
