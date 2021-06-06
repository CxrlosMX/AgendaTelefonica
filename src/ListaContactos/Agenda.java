/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaContactos;

import agendacontactos.Clase.Contacto;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 3/06/2021
 *
 */
public class Agenda {

    //Creamos el arreglo de tipo Objeto
    private Contacto[] arreglo;

    public Agenda(int size) {
        arreglo = new Contacto[size];
    }

    //Contructor que asignara por defecto el tamaño de la agenda
    public Agenda() {
        arreglo = new Contacto[10];
    }

    //Metodo para pedir los valores de un Contacto
    public Contacto rellenarContacto() {
        Contacto c = null;
        String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del Contacto", "Introduciendo Nombre", 3);
        if (!seRepite(nombre)) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduciendo Numero Telefonico", "Introduciendo numero telefonico", 3));
            c = new Contacto(nombre, numero);
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un contacto con ese nombre", "Error", 0);
            return null;
        }
        return c;
    }

    //Metodo para agregar un contacto
    public void agregarContacto(Contacto c) {
        int n=0;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = c;
                n=i;
                encontrado = true;
            }
        }
        if(encontrado && arreglo[n]!=null){
        JOptionPane.showMessageDialog(null,"Contacto Agregado Correctamente","Contacto Agregado",1);
        }

    }

    //Metodo para Mostrar contactos
    public void mostrarAgenda() {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + (i + 1) + ": " + arreglo[i].toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, cadena, "Mostrando Contactos", 1);
    }

    //Metodo para buscar un contacto
    public void buscarContacto(String nombre) {
        int c = 0;
        
            boolean encontrado = false;
            for (int i = 0; i < arreglo.length && !encontrado; i++) {
                if (arreglo[i] != null) {
                    if (arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                        c = i;
                        encontrado = true;
                    }
                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, arreglo[c].toString(), "Contacto encontrado", 1);
            } else {
                JOptionPane.showConfirmDialog(null, "Contacto No encontrado", "No encontrado", 0);
            }
       
    }

    //Metodo para verificar si existe un contacto
    public void verificarContacto(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null) {
                if (arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El contacto se encuentra en la agenda", "Contacto encontrado", 1);
        } else {
            JOptionPane.showConfirmDialog(null, "Contacto No existente en su agenda", "No encontrado", 0);
        }

    }

    //Metodo para eliminar Contacto
    public void eliminarContacto(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null) {
                if (arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                    arreglo[i] = null;
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El contacto fue eliminado", "Contacto Eliminado", 1);
        } else {
            JOptionPane.showConfirmDialog(null, "Contacto No Encontrado en su agenda", "No encontrado", 0);
        }

    }

    //Metodo para ver cuantos espacios disponibles tenemos
    public void espaciosDisponibles() {
       
            JOptionPane.showMessageDialog(null, espaciosLibres(), "Espacios disponibles en la agenda", 1);
       
    }

    //Metodo que nos dice si la agenda esta llena o no
    public void mensajeAgenda() {
        if (noEstaLlena()) {
            JOptionPane.showMessageDialog(null, "Agenda NO llena", "Agenda Con espacios", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Agenda Llena", "Agenda Llena", 1);
        }
    }

    //Metodo para verificar que un nombre no se repita
    public boolean seRepite(String nombre) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                if (arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Metodo para verificar que la lista no este llena
    public boolean noEstaLlena() {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                return true;
            }
        }
        return false;
    }

    //Metodo que nos retornara el numero de espacios disponibles en nuestra agenda
    public int espaciosLibres() {
        int c = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                c+=1;
            }
        }
        return c;
    }

    //Metodo para verificar si la agenda esta completamente vacia
    public boolean agendaVacia() {
        int c = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                c++;
            }
        }
        if (c == arreglo.length) {
            return true;
        }
        return false;
    }

}
