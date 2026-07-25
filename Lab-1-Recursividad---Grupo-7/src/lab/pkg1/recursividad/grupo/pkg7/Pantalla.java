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

    public Pantalla() {
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
                areaConsola.append("Seleccionado el Asiento " + numeroAsiento + "\n");
            });
            panelAsientos.add(botonesAsientos[i]);
        }
        
    }
    
}
