/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03mooespinosap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Condiciones {

    private ArrayList<String> errores = new ArrayList();
    private ArrayList<String> correcto = new ArrayList();

    public Condiciones() {
        this.errores.addAll(List.of("ERROR: Número de paràmetres incorrecte.\n Ús: addCasa [nif] [nom] [superficie]", "ERROR: Superficie incorrecta. Ha de ser més gran de 10.", "ERROR: Ja hi ha una casa registrada amb aquest nif", "ERROR: Número de paràmetres incorrecte.\n Ús: addPlaca [nif] [superficie] [preu] [potència]",
                "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: Superfície incorrecta. Ha de ser més gran de 0.", "ERROR: No hi ha espai disponible per a instal·lar aquesta placa.",
                "ERROR: Preu incorrecte. Ha de ser més gran de 0.", "ERROR: Potència incorrecte. Ha de ser més gran de 0.", "ERROR: Número de paràmetres incorrecte.\n Ús: addAparell [nif] [descripció] [potència]",
                "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.", "ERROR: Potència incorrecte. Ha de ser més gran de 0.",
                "ERROR: Número de paràmetres incorrecte.\n Ús: onCasa [nif]", "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: La casa ja té l'interruptor encès.", "ERROR: Número de paràmetres incorrecte \n Ús: onAparell [nif] [descripció aparell]",
                "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.", "ERROR: L'aparell ja està encès.",
                "ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.", "ERROR: Han saltat els ploms. La casa ha quedat completament apagada.", "ERROR: Número de paràmetres incorrecte.\n Ús: offAparell [nif] [descripció aparell]",
                "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.", "ERROR: L'aparell ja està apagat.", "ERROR: Número de paràmetres incorrecte.\n Ús: list",
                "ERROR: Número de paràmetres incorrecte.\n Ús: info [nif]", "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: Número de paràmetres incorrecte.\n Ús: quit"));

        this.correcto.addAll(List.of("OK: Casa registrada.", "OK: Placa afegida a la casa.", "OK: Aparell afegit a la casa.", "OK: Aparell encès.", "OK: Aparell apagat.", "OK: Interruptor general activat."));
    }

    public void getError(int indice) {
        System.out.println(this.errores.get(indice));;
    }

    public void getCorrecto(int indice) {
        System.out.println(this.correcto.get(indice)); ;
    }
}
