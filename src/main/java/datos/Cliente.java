/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import condiciones.Condiciones;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Cliente {

    private String nif;
    private String nom;
    private double m2;
    private boolean interruptor = true;
    private ArrayList<Placa> placas = new ArrayList();
    private ArrayList<Aparato> aparatos = new ArrayList();

    public Cliente(String nif, String nom, double mm) {
        this.nif = nif;
        this.nom = nom;
        this.m2 = mm;
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

    public double getM2() {
        return this.m2;
    }

    public ArrayList getPlacas() {
        return placas;
    }

    public void onCasa() {
        if (interruptor != true) {
            interruptor = true;
            System.out.println("OK: Interruptor general activat.");
        } else {
            System.out.println(Condiciones.CASA_ENCESA);
        }
    }

    public void offCasa() {
        this.interruptor = false;
    }

    public Aparato findAparato(String descripcion) {
        if (!aparatos.isEmpty()) {
            for (Aparato aparell : aparatos) {
                if (aparell.getDescripcion().equalsIgnoreCase(descripcion)) {
                    return aparell;
                }
            }
        }
        return null;
    }

    public double potenciaTotal() {
        double potenciatotal = 0;
        for (Placa laplaca : placas) {
            potenciatotal = potenciatotal + laplaca.getPotencia();
        }
        return potenciatotal;
    }

    public double consumTotal() {
        double consumtotal = 0;
        for (Aparato aparell : aparatos) {
            if (aparell.getInterruptor() == true) {
                consumtotal = consumtotal + aparell.getGasto();
            }
        }
        return consumtotal;
    }

    public double getResta() {
        double resta;

        resta = this.m2;
        for (Placa laplaca : placas) {
            resta = resta - laplaca.getSuperficie();
        }

        return resta;
    }

    public boolean getInterruptor() {
        return this.interruptor;
    }
    
    public double calcularSuperficie(double nuevaplaca){
        double superficieplacas = 0;
        for(Placa laplaca: placas){
            superficieplacas = superficieplacas + laplaca.getSuperficie();
        }
        superficieplacas = superficieplacas + nuevaplaca;
        return superficieplacas;
    }

    public void offAparells() {
        for (Aparato elaparell : aparatos) {
            if (elaparell.getInterruptor() == true) {
                elaparell.changeOff();
            }
        }
    }

    public ArrayList getAparells() {
        return aparatos;
    }

    public double precioTotal() {
        double preciototal = 0;
        for (Placa laplaca : placas) {
            preciototal = preciototal + laplaca.getPrecio();
        }
        return preciototal;
    }

}
