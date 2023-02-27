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
        String nif;
        String nom;
        float mm;
        String puntero;
        Cliente buscado;
        int opcion;

        do {
            System.out.print("> ");
            comando = inputConsola.readLine();
            String[] partes = comando.split(" ");


            switch (partes[0]) {

                case "addCasa":

                    Cliente nuevacasa = new Cliente(partes[1], partes[2], Double.parseDouble(partes[3]));
                    clientes.add(nuevacasa);
                    nuevacondicion.getCorrecto(0);
                    break;

                case "addPlaca":

                    float superficie = Float.valueOf(partes[2]);
                    float precio = Float.valueOf(partes[3]);
                    float potencia = Float.valueOf(partes[4]);

                    Placa nuevo2 = new Placa(superficie, precio, potencia);

                    buscado = buscarcasa(partes[1]);
                    buscado.addPlaca(nuevo2);

                    nuevacondicion.getCorrecto(1);
                    break;

                case "addAparell":

                    String descripcion = partes[2];
                    float gasto = Float.valueOf(partes[3]);

                    Aparato nuevo3 = new Aparato(descripcion, gasto);
                    buscado = buscarcasa(partes[1]);
                    buscado.addAparato(nuevo3);

                    nuevacondicion.getCorrecto(2);
                    break;

                case "onCasa":
                    buscado = buscarcasa(partes[1]);
                    opcion = buscado.onCasa();

                    break;
                case "onAparell":

                    buscado = buscarcasa(partes[1]);
                    buscado.onAparell(partes[2], nuevacondicion);

                    break;

                case "offAparell":
                    buscado = buscarcasa(partes[1]);
                    buscado.offAparell(partes[2], nuevacondicion);

                    break;

                case "list":
                    int indice;
                    indice = 1;

                    for (Cliente elcliente : clientes) {

                        System.out.println("Casa " + indice);
                        elcliente.getList();
                        indice++;
                    }
                    break;

                case "info":
                    buscado = buscarcasa(partes[1]);
                    buscado.getInfo();
                    break;
            }

        } while (!comando.equalsIgnoreCase("quit"));

    }

    public static Cliente buscarcasa(String NIF) {

        for (Cliente elcliente : clientes) {
            if (elcliente != null && NIF.equalsIgnoreCase(elcliente.getNif())) {
                return elcliente;
            }

        }
        return null;
    }
}
