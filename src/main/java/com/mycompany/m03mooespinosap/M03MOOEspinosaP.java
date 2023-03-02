/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.m03mooespinosap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Pau Espinosa Fernandez
 */
public class M03MOOEspinosaP {

    static ArrayList<Cliente> clientes = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader inputConsola = new BufferedReader(new InputStreamReader(System.in));
        Condiciones nuevacondicion = new Condiciones();

        String comando;
        Cliente buscado;
        int indice;

        do {
            System.out.print("> ");
            comando = inputConsola.readLine();
            String[] partes = comando.split(" ");

            if (partes[0].equalsIgnoreCase("addCasa") || partes[0].equalsIgnoreCase("addPlaca") || partes[0].equalsIgnoreCase("addAparell") || partes[0].equalsIgnoreCase("onCasa")
                    || partes[0].equalsIgnoreCase("onAparell") || partes[0].equalsIgnoreCase("offAparell") || partes[0].equalsIgnoreCase("list") || partes[0].equalsIgnoreCase("info")
                    || partes[0].equalsIgnoreCase("quit")) {

                switch (partes[0]) {

                    case "addCasa":
                        indice = buscarExistencia(partes[1]);

                        if (partes.length == 4) {
                            if (indice == clientes.size()) {
                                if (Double.parseDouble(partes[3]) > 10) {
                                    Cliente nuevacasa = new Cliente(partes[1], partes[2], Double.parseDouble(partes[3]));
                                    clientes.add(nuevacasa);
                                } else {
                                    System.out.println(Condiciones.SUPERFICIE_CASA);
                                }
                            } else {
                                System.out.println(Condiciones.CASA_REGISTRADA);
                            }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ADDCASA);
                        }
                        break;

                    case "addPlaca":
                        indice = buscarExistencia(partes[1]);

                        float superficie = Float.valueOf(partes[2]);
                        float precio = Float.valueOf(partes[3]);
                        float potencia = Float.valueOf(partes[4]);

                        if (partes.length == 5) {
                            if (indice < clientes.size()) {
                                if (superficie > 0) {
                                    if (precio > 0) {
                                        if (potencia > 0) {

                                            Placa nuevo2 = new Placa(superficie, precio, potencia);
                                            buscado = buscarCasa(partes[1]);
                                            buscado.addPlaca(nuevo2);

                                        } else {
                                            System.out.println(Condiciones.POTENCIA);
                                        }
                                    } else {
                                        System.out.println(Condiciones.PREU_PLACA);
                                    }
                                } else {
                                    System.out.println(Condiciones.SUPERFICIE_PLACA);
                                }
                            } else {
                                System.out.println(Condiciones.CASA_NOREGISTRADA);
                            }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ADDPLACA);
                        }

                        break;

                    case "addAparell":

                        String descripcion = partes[2];
                        float gasto = Float.valueOf(partes[3]);

                        Aparato nuevo3 = new Aparato(descripcion, gasto);
                        buscado = buscarCasa(partes[1]);
                        buscado.addAparato(nuevo3);

                        break;

                    case "onCasa":
                        buscado = buscarCasa(partes[1]);
                        buscado.onCasa();

                        break;
                    case "onAparell":

                        buscado = buscarCasa(partes[1]);
                        buscado.onAparell(partes[2], nuevacondicion);

                        break;

                    case "offAparell":
                        buscado = buscarCasa(partes[1]);
                        buscado.offAparell(partes[2], nuevacondicion);

                        break;

                    case "list":
                        indice = 1;

                        for (Cliente elcliente : clientes) {

                            System.out.println("Casa " + indice);
                            elcliente.getList();
                            indice++;
                        }
                        break;

                    case "info":
                        buscado = buscarCasa(partes[1]);
                        buscado.getInfo();
                        break;
                }

            } else {
                System.out.println(Condiciones.COMANDA);
            }
        } while (!comando.equalsIgnoreCase("quit"));

    }

    public static Cliente buscarCasa(String nif) {

        for (Cliente elcliente : clientes) {
            if (elcliente != null && nif.equalsIgnoreCase(elcliente.getNif())) {
                return elcliente;
            }

        }
        return null;
    }

    public static int buscarExistencia(String nif) {
        int indice = 0;
        for (Cliente contador : clientes) {
            if (!(contador.getNif()).equalsIgnoreCase(nif)) {
                indice++;
            }
        }
        return indice;

    }

}
