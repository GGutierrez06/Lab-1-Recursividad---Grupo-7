/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg1.recursividad.grupo.pkg7;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author gabri
 */
public class Pantalla {
    
    public void iniciarVentana(){
        JFrame ventana = new JFrame("Hola mundo!");
        ventana.setSize(1000,800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(5,5));
        
        
        JLabel titulo = new JLabel("Palindromo Air");        
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(titulo);     
        
        JButton boton1 = new JButton("Sell Ticket");
        JButton boton2 = new JButton("Cancel Ticket");
        JButton boton3 = new JButton("Dispatch");
        JButton boton4 = new JButton("Print Passengers");
        JButton boton5 = new JButton("View Income");
        JButton boton6 = new JButton("Search Passenger");
        JPanel panelBotones = new JPanel(new GridLayout(2,3,5,5));
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);
        
        
        JTextArea consola = new JTextArea(6,50);
        consola.setEditable(false);
        consola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        consola.setBackground(new Color(30, 30, 30));
        consola.setForeground(Color.GREEN);
        JScrollPane panelConsola = new JScrollPane();
        panelConsola.setBorder(BorderFactory.createTitledBorder("Consola"));
        panelConsola.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelConsola.setPreferredSize(new Dimension(0, 180));
        
        JPanel panelInferior = new JPanel(new BorderLayout(0,10));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        
        ventana.add(panelSuperior, BorderLayout.NORTH);
        ventana.add(panelBotones, BorderLayout.SOUTH);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ventana.setVisible(true);
    }
    
}
