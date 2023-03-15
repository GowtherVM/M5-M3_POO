/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import condiciones.Condiciones;
import datos.Placa;
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

    public double getMm() {
        return this.m2;
    }

    public int getSizeplacas() {
        return placas.size();
    }

    public int getSizeaparells() {
        return aparatos.size();
    }
    
    public ArrayList getPlacas(){
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
    
    public void offCasa(){
        this.interruptor = false;
    }


    
    public Aparato findAparato(String descripcion){
        for(Aparato aparell: aparatos){
            if(aparell.getDescripcion().equalsIgnoreCase(descripcion)){
                return aparell;
            }
        }
        return null;
    }
    
    public double potenciaTotal(){
        double potenciatotal = 0;
        for(Placa laplaca: placas){
            potenciatotal = potenciatotal + laplaca.getPotencia();
        }
        return potenciatotal;
    }
    
    public double consumTotal(){
        double consumtotal = 0;
        for (Aparato aparell:  aparatos){
            if(aparell.getInterruptor() == true){
                consumtotal = consumtotal + aparell.getGasto();
            }
        }
        return consumtotal;
    }
    
    public double getResta(){
         double resta;


        resta = this.m2;
        for (Placa laplaca : placas) {
            resta = resta - laplaca.getSuperficie();
        }
        
        return resta;
    }
    
    public boolean getInterruptor(){
        return this.interruptor;
    }
    
    public void offAparells(){
        for(Aparato elaparell: aparatos){
            if (elaparell.getInterruptor() == true){
                elaparell.changeOff();
            }
        }
    }


    public void getInfo() {
        double potenciatotal = 0;
        double preciototal = 0;
        double consum = 0;

        for (Placa laplaca : placas) {
            potenciatotal = potenciatotal + laplaca.getPotencia();
            preciototal = preciototal + laplaca.getPrecio();
        }

        for (Aparato elaparato : aparatos) {
            if (elaparato.getInterruptor() == true) {
                consum = consum + elaparato.getGasto();
            }
        }

        System.out.println("Cliente: " + this.nif + " - " + this.nom);
        System.out.println("Plaques solars instal·lades: " + placas.size());
        System.out.println("Potencia total: " + potenciatotal);
        System.out.println("Inversió total: " + preciototal);
        System.out.println("Aparells registrats: " + aparatos.size());
        System.out.println("Consum actual: " + consum + "\n");

        if (consum > 0) {
            System.out.println("Aparells encesos:");
            for (Aparato elaparato : aparatos) {
                if (elaparato.getInterruptor() == true) {
                    System.out.println("    - " + elaparato.getDescripcion());
                }
            }
        }
    }
}
