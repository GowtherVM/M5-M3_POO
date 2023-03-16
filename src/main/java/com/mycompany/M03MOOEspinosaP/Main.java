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

        do {
            System.out.print("> ");
            comando = inputConsola.readLine();
            String[] partes = comando.split(" ");

            switch (partes[0].toLowerCase()) {

                case "addcasa":

                    if (partes.length == 4) {
                        añadirCasa(partes[1], partes[2], partes[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDCASA);
                    }

                    break;

                case "addplaca":

                    if (partes.length == 5) {
                        añadirPlaca(partes[1], partes[2], partes[3], partes[4]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDPLACA);
                    }

                    break;

                case "addaparell":
                    if (partes.length == 4) {
                        añadirAparato(partes[1], partes[2], partes[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDAPARELL);
                    }

                    break;

                case "oncasa":
                    if (partes.length == 2) {
                        onCasa(partes[1]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ONCASA);
                    }

                    break;
                case "onaparell":
                    if (partes.length == 3) {
                        onAparato(partes[1], partes[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ONAPARELL);
                    }

                    break;

                case "offaparell":
                    if (partes.length == 3) {
                        offAparato(partes[1], partes[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.OFFAPARELL);
                    }
                    break;

                case "list":
                    if (partes.length == 1) {
                        getList();
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.LIST);
                    }

                    break;

                case "info":
                    if (partes.length == 2) {
                        getInfo(partes[1]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.INFO);
                    }
                    break;

                case "quit":
                    if (partes.length > 1) {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.QUIT);
                    }
                    break;

                default:
                    System.out.println(Condiciones.COMANDA);
                    break;
            }

        } while (!comando.equalsIgnoreCase("quit"));

    }

    public static void añadirCasa(String nif, String nom, String superficie) {
        casa = null;
        if (!basededatos.getDb().isEmpty()) {
            casa = basededatos.buscarCasa(nif);
        }
        if (casa == null) {
            if (Double.parseDouble(superficie) > 10) {
                Cliente nuevacasa = new Cliente(nif, nom, Double.parseDouble(superficie));
                basededatos.addCliente(nuevacasa);
                System.out.println("OK: Casa registrada.");
            } else {
                System.out.println(Condiciones.SUPERFICIE_CASA);
            }
        } else {
            System.out.println(Condiciones.CASA_REGISTRADA);
        }
    }

    public static void añadirPlaca(String nif, String superficie, String precio, String potencia) {
        casa = basededatos.buscarCasa(nif);
        if (!basededatos.getDb().isEmpty() && casa != null) {
            if (Double.parseDouble(superficie) > 0) {
                if (casa.calcularSuperficie(Double.parseDouble(superficie)) < casa.getMm()) {
                    if (Double.parseDouble(precio) > 0) {
                        if (Double.parseDouble(potencia) > 0) {

                            Placa nuevo2 = new Placa(Double.parseDouble(superficie), Double.parseDouble(precio), Double.parseDouble(potencia));
                            casa.addPlaca(nuevo2);
                            System.out.println("OK: Placa afegida a la casa.");
                        } else {
                            System.out.println(Condiciones.POTENCIA);
                        }
                    } else {
                        System.out.println(Condiciones.PREU_PLACA);
                    }
                } else {
                    System.out.println(Condiciones.ESPAI_PLACA);
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
                    System.out.println("OK: Aparell afegit a la casa.");
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
                System.out.println("OK: Interruptor general activat.");
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
                        } else {
                            System.out.println("OK: Aparell encès.");
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
                    System.out.println("OK: Aparell apagat.");
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
            System.out.println("--- Endolls Solars, S.L ---");
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
                System.out.println(" ");
                contador++;
            }
        } else {
            System.out.println("No hi ha casas registrades");
        }
    }

    public static void getInfo(String nif) {
        casa = basededatos.buscarCasa(nif);

        if (casa != null && !basededatos.getDb().isEmpty()) {
            ArrayList<Aparato> aparells = casa.getAparells();
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

}
