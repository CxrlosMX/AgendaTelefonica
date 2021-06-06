/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import ListaContactos.Agenda;
import agendacontactos.Clase.Contacto;
import javax.swing.JOptionPane;

/**
 *
 * @author CxrlosMX
 */
public class AgendaContactos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0, a = 0;
        String nombre;
        Agenda agenda = new Agenda(10);
        Contacto c;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "-*-*AGENDA*-*-"
                        + "\n1.-Añadir Contacto"
                        + "\n2.-Listar Contacto"
                        + "\n3.-Buscar Contacto"
                        + "\n4.-Existe Contacto"
                        + "\n5.-Eliminar Contacto"
                        + "\n6.-Contactos Disponibles"
                        + "\n7.-Agenda Llena"
                        + "\n8.-Salir"
                        + "\n¿Que desea realizar?", "AGENDA", 3));
                switch (op) {
                    case 1: {
                        if (agenda.noEstaLlena()) {
                            c = agenda.rellenarContacto();
                            agenda.agregarContacto(c);
                        } else {
                            JOptionPane.showMessageDialog(null, "La agenda esta llena", "Agenda Llena", 0);
                        }
                        break;
                    }
                    case 2: {
                        if (!agenda.agendaVacia()) {
                            agenda.mostrarAgenda();
                        } else {
                            JOptionPane.showMessageDialog(null, "La agenda esta Vacia", "Agenda Vacia", 0);
                        }
                        break;
                    }
                    case 3: {
                        if (!agenda.agendaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Buscando Contacto", 1);
                            agenda.buscarContacto(nombre);
                        } else {
                            JOptionPane.showMessageDialog(null, "La agenda esta Vacia", "Agenda Vacia", 0);
                        }
                        break;
                    }
                    case 4: {
                        if (!agenda.agendaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Buscando Contacto", 1);
                            agenda.verificarContacto(nombre);
                        } else {
                            JOptionPane.showMessageDialog(null, "La agenda esta Vacia", "Agenda Vacia", 0);
                        }
                        break;
                    }
                    case 5: {
                        if (!agenda.agendaVacia()) {
                            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del contacto", "Buscando Contacto", 1);
                            agenda.eliminarContacto(nombre);
                        } else {
                            JOptionPane.showMessageDialog(null, "La agenda esta Vacia", "Agenda Vacia", 0);
                        }
                        break;
                    }
                    case 6: {
                        //  agenda.espaciosDisponibles();
                        a = agenda.espaciosLibres();
                        JOptionPane.showMessageDialog(null, "Espacios Disponibles: " + a, "Espacios disponibles", 1);
                        break;
                    }
                    case 7: {
                        if (agenda.noEstaLlena()) {
                            JOptionPane.showMessageDialog(null, "Agenda Con Espacios", "No llena", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agenda Llena", "Agenda Llena", 0);
                        }
                        break;
                    }
                    case 8: {
                        JOptionPane.showMessageDialog(null, "Cerrando agenda", "Agenda Cerrando", 2);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null,"Introduce valores validos por favor","Opcion Incorrecta",0);

                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro " + e.getMessage(), "Error", 0);
            }
        } while (op != 8);

    }

}
