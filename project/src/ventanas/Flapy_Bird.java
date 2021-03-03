/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import componentes.Tubos;
import componentes.Bird;
import java.awt.Color;
import javax.swing.*;
import clases.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.applet.AudioClip;
import java.awt.Image;
import sun.applet.AppletAudioClip;

/**
 *
 * @author Alumno
 */
public class Flapy_Bird extends JFrame{

    public JFrame ventana;
    //ImageIcon imgColibriAbajo = new ImageIcon(getClass().getResource("/imagenes/aveAbajo.png"));
    //ImageIcon imgColibriArriba = new ImageIcon(getClass().getResource("/imagenes/aveArriba.png"));
    
    ImageIcon co = new ImageIcon(getClass().getResource("/imagenes/pajaro.png"));
    Icon imgColibriAbajo = new ImageIcon(co.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    
    public ImageIcon imgTuboAbajo = new ImageIcon(getClass().getResource("/imagenes/tuboAbajo.png"));
    public ImageIcon imgTuboArriba = new ImageIcon(getClass().getResource("/imagenes/tuboArriba.png"));
    ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
    public JLabel fondo;
    
    public Bird colibri;
    public JLabel ave;
    public ArrayList<JLabel> tubosArriba = new ArrayList<JLabel>();
    public int contadorTubosArriba = 0;

    public ArrayList<JLabel> tubosAbajo = new ArrayList<JLabel>();
    public int contadorTubosAbajo = 0;

    public ArrayList<Tubos> tuboArriba = new ArrayList<Tubos>();
    public ArrayList<Tubos> tuboAbajo = new ArrayList<Tubos>();

    public boolean arriba = false;
    public int contadorArribaPajaro = 0;
    
    Random Y = new Random();
    int pasos = 0;
    
    public JLabel marcador;
    public AudioClip sonidoArriba = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/arriba.wav"));
    public AudioClip sonidoMuerte = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/muerte.wav"));
    public AudioClip sonidoCoin = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/coin.wav"));
    
    Game game;

    public Flapy_Bird() {

        //Creacion de la ventana
        ventana = new JFrame("FLAPY BIRD");
        ventana.setBounds(10, 10, 420, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(0, 0, 0));
        ventana.setVisible(true);
        
        
        fondo = new JLabel();
        fondo.setBounds(0, 0, 420, 600);
        Image imgScale = imgFondo.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(imgScale));
        fondo.setVisible(true);
        ventana.add(fondo);

        //Creacion del objeto Bird
        colibri = new Bird(100, 300, 50);
        //Creacion de BIRD
        ave = new JLabel(imgColibriAbajo);
        ave.setBounds(colibri.getPosicionX(), colibri.getPosicionY(), colibri.getTamaño(), colibri.getTamaño());
        ave.setVisible(true);
        fondo.add(ave);
        
        //Label para Marcador
        marcador = new JLabel(pasos+"");
        marcador.setBounds(190, 30, 70, 70);
        marcador.setFont(new Font("Arial",1,70));
        marcador.setVisible(true);
        fondo.add(marcador);

        //Random para los tubos
        int posY = Y.nextInt(200)-150;
        
        //Label de los tubos 
        //Creacion de los dosprimeros  objetos Tubo
        tuboArriba.add(new Tubos(420, posY, 0, 60, 500));
        tubosArriba.add(new JLabel(imgTuboArriba));
        tubosArriba.get(contadorTubosArriba).setBounds(tuboArriba.get(0).getPosicionX(), tuboArriba.get(0).getPosicionArribaY(), 60, 300);
        tubosArriba.get(contadorTubosArriba).setVisible(true);
        fondo.add(tubosArriba.get(contadorTubosArriba));
        contadorTubosArriba++;
        
        
        tuboAbajo.add(new Tubos(420, 0, posY + 420, 60, 300));//Objeto tubo
        tubosAbajo.add(new JLabel(imgTuboAbajo));
        tubosAbajo.get(contadorTubosAbajo).setBounds(tuboAbajo.get(0).getPosicionX(), tuboAbajo.get(0).getPosicionAbajoY(), 60, 300);
        tubosAbajo.get(contadorTubosAbajo).setVisible(true);
        fondo.add(tubosAbajo.get(contadorTubosAbajo));
        contadorTubosAbajo++;
        
        
        game = new Game(this);


        //fondo.update(ventana.getGraphics());

    }

    
    
    public void gameOver(){
        
        
        //Sentencia para acabar el juego cuado choque col los tubos
        if (tuboArriba.get(pasos).getPosicionX() <= colibri.getPosicionX() + 50) {
            if (colibri.getPosicionY() < tuboArriba.get(pasos).getPosicionArribaY() + 300 ||colibri.getPosicionY() + 50 > tuboAbajo.get(pasos).getPosicionAbajoY()) {
                this.game.stop();
                sonidoMuerte.play();
                new Reinicio(ventana);
            }
        }
        if (tuboArriba.get(pasos).getPosicionX() == 49) {
            pasos++;
            sonidoCoin.play();
            marcador.setText(pasos+"");
        }
        
        //Sentencia para acabar el juego cuado choque con el piso
        if (colibri.getPosicionY() > 520) {
            this.game.stop();
            sonidoMuerte.play();
            new Reinicio(ventana);
        }
        
    }
    
}
