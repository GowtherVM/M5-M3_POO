/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03mooespinosap;



/**
 *
 * @author Admin
 */
public class Condiciones {

 // errors casa
    public static final String CASA_ENCESA = "ERROR: La casa ja té l'interruptor encès.";
    public static final String SUPERFICIE_CASA = "ERROR: Superficie incorrecta. Ha de ser més gran de 10.";
    public static final String CASA_REGISTRADA = "ERROR: Ja hi ha una casa registrada amb aquest nif";
    public static final String CASA_NOREGISTRADA = "ERROR: No hi ha cap casa registrada amb aquest nif.";
    
    // errors placa
    public static final String SUPERFICIE_PLACA = "ERROR: Superfície incorrecta. Ha de ser més gran de 0.";
    public static final String PREU_PLACA = "ERROR: Preu incorrecte. Ha de ser més gran de 0.";
    public static final String ESPAI_PLACA = "ERROR: No hi ha espai disponible per a instal·lar aquesta placa.";
    
    // errors aparell
    public static final String APARELL_REGISTRAT = "ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.";
    public static final String APARELL_NOREGISTRAT = "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.";
    public static final String APARELL_ENCES = "ERROR: L'aparell ja està encès.";
    public static final String APARELL_APAGAT =  "ERROR: L'aparell ja està apagat.";
    
    // errors potencia
    public static final String INTERRUPTOR_APAGAT = "ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.";
    public static final String PLOMS_SALTATS = "ERROR: Han saltat els ploms. La casa ha quedat completament apagada.";
    public static final String POTENCIA = "ERROR: Potència incorrecte. Ha de ser més gran de 0.";
    
    // errors parametres
    public static final String PARAMETRES = "ERROR: Número de paràmetres incorrecte d'ús.";
    public static final String COMANDA = "ERROR: Comanda incorrecta.";
    public static final String ADDCASA = "Ús: addCasa [nif] [nom] [superficie]";
    public static final String ADDPLACA = "Ús: addPlaca [nif] [superficie] [preu] [potència]";
    public static final String ADDAPARELL = "Ús: addAparell [nif] [descripció] [potència]";
    public static final String ONCASA = "Ús: onCasa [nif]";
    public static final String ONAPARELL = "Ús: onAparell [nif] [descripció aparell]";
    public static final String OFFAPARELL = "Ús: offAparell [nif] [descripció aparell]";
    public static final String LIST = "Ús: list";
    public static final String INFO = "Ús: info [nif]";
    public static final String QUIT = "Ús: quit";
}

