/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.M03MOOEspinosaP;

import condiciones.Condiciones;
import datos.Aparato;
import datos.BDD;
import datos.Cliente;
import datos.Placa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Pau Espinosa Fernandez
 */
public class Main {

    static Cliente casa;
    static BDD basededatos = new BDD();

    public static void main(String[] args) throws IOException {
        BufferedReader inputConsola = new BufferedReader(new InputStreamReader(System.in));


        String comando;
        setPrueba();

        do {
            System.out.print("> ");
            comando = inputConsola.readLine();
            String[] partes = comando.split(" ");

            switch (partes[0]) {

                case "addCasa":

                    if (partes.length == 4) {
                        añadirCasa(partes[1], partes[2], partes[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDCASA);
                    }

                    break;

                case "addPlaca":

                    if (partes.length == 5) {
                        añadirPlaca(partes[1], partes[2], partes[3], partes[4]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDPLACA);
                    }

                    break;

                case "addAparell":
                    if (partes.length == 4) {
                        añadirAparato(partes[1], partes[2], partes[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDAPARELL);
                    }

                    break;

                case "onCasa":
                    if (partes.length == 2) {
                        onCasa(partes[1]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ONCASA);
                    }

                    break;
                case "onAparell":
                    if (partes.length == 3) {
                        onAparato(partes[1], partes[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ONAPARELL);
                    }

                    break;

                case "offAparell":
                    if (partes.length == 3) {
                        offAparato(partes[1], partes[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.OFFAPARELL);
                    }
                    break;

                case "list":
                    if (partes.length == 1){
                        getList();
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.LIST);
                    }
                    
                    break;

                case "info":
                    if (partes.length == 2){
                        getInfo(partes[1]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.INFO);
                    }
                    break;
                    
                case "quit":
                    if (partes.length > 1){
                        System.out.println(Condiciones.PARAMETRES + Condiciones.QUIT);
                    }
                    break;
                    
                default:
                    System.out.println(Condiciones.COMANDA);
                    break;
            }

        } while (!comando.equalsIgnoreCase("quit"));

    }

    public static void añadirCasa(String parte1, String parte2, String parte3) {
        casa = null;
        if (!basededatos.getDb().isEmpty()) {
            casa = basededatos.buscarCasa(parte1);
        }
        if (casa == null) {
            if (Double.parseDouble(parte3) > 10) {
                Cliente nuevacasa = new Cliente(parte1, parte2, Double.parseDouble(parte3));
                basededatos.addCliente(nuevacasa);
            } else {
                System.out.println(Condiciones.SUPERFICIE_CASA);
            }
        } else {
            System.out.println(Condiciones.CASA_REGISTRADA);
        }
    }

    public static void añadirPlaca(String parte1, String parte2, String parte3, String parte4) {
        casa = basededatos.buscarCasa(parte1);
        if (!basededatos.getDb().isEmpty() && casa != null) {
            if (Double.parseDouble(parte2) > 0) {
                if (Double.parseDouble(parte3) > 0) {
                    if (Double.parseDouble(parte4) > 0) {

                        Placa nuevo2 = new Placa(Double.parseDouble(parte2), Double.parseDouble(parte3), Double.parseDouble(parte4));
                        casa.addPlaca(nuevo2);

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
    }

    public static void añadirAparato(String nif, String descripcion, String potencia) {
        casa = basededatos.buscarCasa(nif);
        if (casa != null && !basededatos.getDb().isEmpty()) {
            if (casa.findAparato(descripcion) == null) {
                if (Double.parseDouble(potencia) > 0) {
                    Aparato nuevo3 = new Aparato(descripcion, Double.parseDouble(potencia));
                    casa.addAparato(nuevo3);
                } else {
                    System.out.println(Condiciones.POTENCIA);
                }
            } else {
                System.out.println(Condiciones.APARELL_REGISTRAT);
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }

    }

    public static void onCasa(String nif) {
        casa = basededatos.buscarCasa(nif);
        if (casa != null && !basededatos.getDb().isEmpty()) {
            if (casa.getInterruptor() == false) {
                casa.onCasa();
            } else {
                System.out.println(Condiciones.CASA_ENCESA);
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }

    }

    public static void onAparato(String nif, String aparell) {
        casa = basededatos.buscarCasa(nif);
        Aparato aparato;
        if (casa != null && !basededatos.getDb().isEmpty()) {
            aparato = casa.findAparato(aparell);
            if (aparato != null && !casa.getAparells().isEmpty()) {
                if (aparato.getInterruptor() == false) {
                    if (casa.getInterruptor() == true) {
                        aparato.changeOn();
                        if (casa.consumTotal() > casa.potenciaTotal()) {
                            casa.offAparells();
                            casa.offCasa();
                            System.out.println(Condiciones.PLOMS_SALTATS);
                        }
                    } else {
                        System.out.println(Condiciones.INTERRUPTOR_APAGAT);
                    }
                } else {
                    System.out.println(Condiciones.APARELL_ENCES);
                }

            } else {
                System.out.println(Condiciones.APARELL_NOREGISTRAT);
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }

    }

    public static void offAparato(String nif, String aparell) {
        casa = basededatos.buscarCasa(nif);
        Aparato aparato;

        if (casa != null && !basededatos.getDb().isEmpty()) {
            aparato = casa.findAparato(aparell);
            if (aparato != null) {
                if (aparato.getInterruptor() == true) {
                    aparato.changeOff();
                } else {
                    System.out.println(Condiciones.APARELL_APAGAT);
                }
            } else {
                System.out.println(Condiciones.APARELL_NOREGISTRAT);
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }
    }

    public static void getList() {

        String estado;
        int contador = 1;
        ArrayList<Cliente> clientes = basededatos.getDb();
        
        if (!clientes.isEmpty()) {
            for (Cliente elcliente : clientes) {

                if (elcliente.getInterruptor() == true) {
                    estado = "encès";
                } else {
                    estado = "apagat";
                }

                System.out.println("Casa " + contador);
                System.out.println("Cliente: " + elcliente.getNif() + " - " + elcliente.getNom());
                System.out.println("Superficie de teulada: " + elcliente.getMm());
                System.out.println("Superficie disponible: " + elcliente.getResta());
                System.out.println("Interruptor general: " + estado);

                if (elcliente.getPlacas().isEmpty()) {
                    System.out.println("No té plaques solars instal·lades.");
                } else {
                    System.out.println("Plaques solars instal·lades: " + elcliente.getPlacas().size());
                }
                if (elcliente.getAparells().isEmpty()) {
                    System.out.println("No té cap aparell elèctric registrat.");
                } else {
                    System.out.println("Aparells registrats: " + elcliente.getAparells().size());
                }

                contador++;
            }
        } else {
            System.out.println("No hi ha casas registrades");
        }
    }

    public static void getInfo(String nif) {
        casa = basededatos.buscarCasa(nif);
        ArrayList <Aparato> aparells = casa.getAparells();
        
        if (casa != null && !basededatos.getDb().isEmpty()) {
            double potenciatotal = casa.potenciaTotal();
            double preciototal = casa.precioTotal();
            double consum = casa.consumTotal();

            System.out.println("Cliente: " + casa.getNif() + " - " + casa.getNom());
            System.out.println("Plaques solars instal·lades: " + casa.getPlacas().size());
            System.out.println("Potencia total: " + potenciatotal);
            System.out.println("Inversió total: " + preciototal);
            System.out.println("Aparells registrats: " + casa.getAparells().size());
            System.out.println("Consum actual: " + consum + "\n");

            if (consum > 0) {
                System.out.println("Aparells encesos:");
                for (Aparato elaparato : aparells) {
                    if (elaparato.getInterruptor() == true) {
                        System.out.println("    - " + elaparato.getDescripcion());
                    }
                }
            }
        }

    }
    
    public static void setPrueba(){
        añadirCasa("1234", "pau", "50");
        añadirCasa("4321", "pau", "70");
        añadirPlaca("4321", "10", "10", "50");
    }

}
