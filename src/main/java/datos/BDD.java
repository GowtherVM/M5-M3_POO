/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BDD {

    private ArrayList<Cliente> clientes = new ArrayList();

    
    
    public Cliente buscarCasa(String nif) {

        for (Cliente elcliente : clientes) {
            if (elcliente != null && nif.equalsIgnoreCase(elcliente.getNif())) {
                return elcliente;
            }

        }
        return null;
    }
    
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public ArrayList getDb(){
        return clientes;
    }
    
}
