/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg1.recursividad.grupo.pkg7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class Pantalla extends JFrame {

    private JButton[] botonesAsientos = new JButton[30];
    private JTextField txtNombrePasajero;
    private JTextArea areaConsola;

    private JButton btnSellTicket;
    private JButton btnCancelTicket;
    private JButton btnDispatch;
    private JButton btnPrintPassengers;
    private JButton btnViewIncome;
    private JButton btnSearchPassenger;

    private final Color COLOR_DISPONIBLE = new Color(46, 204, 113);
    private final Color COLOR_OCUPADO = new Color(231, 76, 60);
    private final Color COLOR_PALINDROMO = new Color(241, 196, 15);
    
    private PalindromoAir Vuelo;

    public Pantalla() {
        Vuelo = new PalindromoAir();
        setTitle("Sistema de Reservas de Boletos de Avion ");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        iniciarIU();
    }

    private void iniciarIU() {
        JPanel panelAsientos = new JPanel(new GridLayout(6, 5, 8, 8));
        panelAsientos.setBorder(BorderFactory.createTitledBorder("Mapa de Asientos del Avion "));

        for (int i = 0; i < 30; i++) {
            botonesAsientos[i] = new JButton("Asiento " + (i + 1));
            botonesAsientos[i].setBackground(COLOR_DISPONIBLE);
            botonesAsientos[i].setForeground(Color.WHITE);
            botonesAsientos[i].setFont(new Font("Arial", Font.BOLD, 11));
            botonesAsientos[i].setFocusPainted(false);

            final int numeroAsiento = i + 1;
            botonesAsientos[i].addActionListener(e -> {
                Ticket ticket = Vuelo.getPosicion()[numeroAsiento-1];
                if (ticket != null){
                    areaConsola.append("Asiento #" + numeroAsiento + ": Ocupado por: "+ticket.getNombre()+" ($."+ticket.getFinalAmount()+")\n");
                } else {
                    areaConsola.append("Asiento #" + numeroAsiento + ": DISPONIBLE\n");
                }
                });
            panelAsientos.add(botonesAsientos[i]);
        }
        
        JPanel panelComandos = new JPanel(new GridLayout(8, 1, 5, 8));
        panelComandos.setBorder(BorderFactory.createTitledBorder("Operaciones de Vuelo"));

        txtNombrePasajero = new JTextField();
        txtNombrePasajero.setBorder(BorderFactory.createTitledBorder("Nombre del Pasajero"));

        btnSellTicket = new JButton("Sell Ticket");
        btnSellTicket.addActionListener(e -> {
            String nombre = txtNombrePasajero.getText().trim();
            if (nombre.isEmpty()){
                areaConsola.append("Por favor ingrese el nombre del pasajero.\n");
                return;
            }
            
            int asientoVenta = Vuelo.sellTicket(nombre);
            if (asientoVenta != -1){
                Ticket ticket = Vuelo.getPosicion()[asientoVenta];
                areaConsola.append("Asiento Vendido! Pasajero: "+nombre+" / Asiento #: "+(asientoVenta+1)+"\n");
                if (ticket.isEsPalin()){
                    areaConsola.append("El nombre es Palindromo! Descuento del 20% aplicado, Total a Pagar: $"+ticket.getFinalAmount()+"\n");
                } else {
                    areaConsola.append("Total a Pagar: $" + ticket.getFinalAmount() + "\n");
                }
                txtNombrePasajero.setText("");
                actualizarAsientos();
            } else {
                areaConsola.append("No hay asientos disponibles en el vuelo.\n");
            }   
        });
        btnCancelTicket = new JButton("Cancel Ticket");
        btnCancelTicket.addActionListener(e -> {
            String nombre = txtNombrePasajero.getText().trim();
            if (nombre.isEmpty()) {
                areaConsola.append("Por favor ingrese el nombre del pasajero a cancelar.\n");
                return;
            }

            boolean cancelado = Vuelo.cancelTicket(nombre);
            if (cancelado) {
                areaConsola.append("El boleto de '" + nombre + "' se ha cancelado.\n");
                txtNombrePasajero.setText("");
                actualizarAsientos();
            } else {
                areaConsola.append("Pasajero con nombre '" + nombre + "' no encontrado\n");
            }
        });
        btnDispatch = new JButton("Dispatch");
        btnDispatch.addActionListener(e -> {
            double total = Vuelo.dispatch();
            areaConsola.append("VUELO DESPACHADO, BUEN VIAJE ------\n");
            areaConsola.append("Ingresos generado por el vuelo: $" + total + "\n");
            areaConsola.append("Asientos liberados.\n");
            actualizarAsientos();
        });
        btnPrintPassengers = new JButton("Print Passengers");
        btnPrintPassengers.addActionListener(e -> {
            areaConsola.append("LISTA DE PASAJEROS ------\n");
            String lista = Vuelo.printPassengers(0);
            if (lista.isEmpty()) {
                areaConsola.append("No hay pasajeros registrados\n");
            } else {
                areaConsola.append(lista);
            }
        });
        btnViewIncome = new JButton("View Income");
        btnViewIncome.addActionListener(e -> {
            double income = Vuelo.income(0);
            areaConsola.append("Ingresos acumulados actuales: $" + income + "\n");
        });
        btnSearchPassenger = new JButton("Search Passenger");
        btnSearchPassenger.addActionListener(e -> {
            String nombre = txtNombrePasajero.getText().trim();
            if (nombre.isEmpty()) {
                areaConsola.append("Por favor ingrese el nombre a buscar.\n");
                return;
            }
            int posicion = Vuelo.searchPassenger(nombre, 0);
            if (posicion != -1) {
                areaConsola.append("El Pasajero '" + nombre + "' esta en el Asiento " + (posicion + 1) + "\n");
            } else {
                areaConsola.append("El Pasajero '" + nombre + "' no esta en el vuelo.\n");
            }
        });
      
        panelComandos.add(txtNombrePasajero);
        panelComandos.add(btnSellTicket);
        panelComandos.add(btnCancelTicket);
        panelComandos.add(btnDispatch);
        panelComandos.add(btnPrintPassengers);
        panelComandos.add(btnViewIncome);
        panelComandos.add(btnSearchPassenger);

       
        areaConsola = new JTextArea(8, 50);
        areaConsola.setEditable(false);
        areaConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaConsola.setBackground(new Color(245, 245, 245));

        JScrollPane consola = new JScrollPane(areaConsola);
        consola.setBorder(BorderFactory.createTitledBorder("Consola de Estado del Vuelo"));

        
        add(panelAsientos, BorderLayout.CENTER);
        add(panelComandos, BorderLayout.EAST);
        add(consola, BorderLayout.SOUTH);

        areaConsola.append("Sistema de Vuelo preparado y listo para continuar.\n");
    }
    
    private void actualizarAsientos() {
        Ticket[] asientos = Vuelo.getPosicion();
        for (int i = 0; i < 30; i++) {
            if (asientos[i] == null) {
                botonesAsientos[i].setBackground(COLOR_DISPONIBLE);
                botonesAsientos[i].setText("Asiento " + (i + 1));
            } else if (asientos[i].isEsPalin()) {
                botonesAsientos[i].setBackground(COLOR_PALINDROMO);
                botonesAsientos[i].setText("Asiento " + (i + 1) + " (P)");
            } else {
                botonesAsientos[i].setBackground(COLOR_OCUPADO);
                botonesAsientos[i].setText("Asiento " + (i + 1));
            }
        }
    }
    
}
