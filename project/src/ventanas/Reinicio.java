/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Daniel Abedoy
 */
public class Reinicio extends JFrame implements ActionListener{
    
    JFrame ventana;
    JButton bt_Reinicio,bt_Salir;
    JFrame venta;
    
    public Reinicio(JFrame venta){
        
        this.venta = venta;
        ventana = new JFrame("REINICIAR");
        ventana.setBounds(10, 10, 300, 140);
        ventana.setLocationRelativeTo(venta);
        ventana.setUndecorated(true);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(Color.black);
        ventana.setVisible(true);
        
        bt_Reinicio = new JButton("Reiniciar");
        bt_Reinicio.setBounds(150, 50, 120, 40);
        bt_Reinicio.addActionListener(this);
        bt_Reinicio.setVisible(true);
        bt_Reinicio.setBackground(Color.white);
        ventana.add(bt_Reinicio);
        
        bt_Salir = new JButton("Salir");
        bt_Salir.setBounds(20, 50, 120, 40);
        bt_Salir.addActionListener(this);
        bt_Salir.setBackground(Color.white);
        bt_Salir.setVisible(true);
        ventana.add(bt_Salir);
       
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reiniciar")) {
            venta.dispose();
            ventana.dispose();
            new Flapy_Bird();
        }
        if (ae.getActionCommand().equals("Salir")) {
            System.exit(0);
        }
    }
    
}
