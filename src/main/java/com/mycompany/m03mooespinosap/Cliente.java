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

    public void getList() {
        double resta;
        String estado;

        resta = this.mm;
        for (Placa laplaca : placas) {
            resta = resta - laplaca.getSuperficie();
        }
        if (this.interruptor == true) {
            estado = "encès";
        } else {
            estado = "apagat";
        }

        System.out.println("Cliente: " + this.nif + " - " + this.nom);
        System.out.println("Superficie de teulada: " + this.mm);
        System.out.println("Superficie disponible: " + resta);
        System.out.println("Interruptor general: " + estado);
        System.out.println("Plaques solars instal·lades: " + placas.size());
        System.out.println("Aparells registrats: " + aparatos.size());
    }

    public void getInfo() {
        double potenciatotal = 0;
        double preciototal = 0;
        double consum = 0;

        for (Placa laplaca : placas) {
            potenciatotal = potenciatotal + laplaca.getPotencia();
        }

        for (Placa laplaca : placas) {
           preciototal = preciototal + laplaca.getPrecio();
        }
        
        for(Aparato elaparato: aparatos){
            consum = consum + elaparato.getGasto();
        }

        System.out.println("Cliente: " + this.nif + " - " + this.nom);
        System.out.println("Plaques solars instal·lades: " + placas.size());
        System.out.println("Potencia total: " + potenciatotal);
        System.out.println("Inversió total: " + preciototal);
        System.out.println("Aparells registrats: "+ aparatos.size());
        System.out.println("Consum actual: "+ consum + "\n");
    }

}
