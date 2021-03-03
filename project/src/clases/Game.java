/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import componentes.Tubos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import ventanas.Flapy_Bird;

/**
 *
 * @author Daniel Abedoy
 */
public class Game {

    private Flapy_Bird home;
    private Timer tubosTimer, birdTimer;

    public Game(Flapy_Bird home) {
        this.home = home;

        timerTubos();
        timerBird();
        eventos();
    }

    public void timerTubos() {
        //Timer para mover los Tubos
        tubosTimer = new Timer(12, (ae) -> {

            //Instancia para acabar el juego
            home.gameOver();

            int posY = new Random().nextInt(200) - 150;
            //Sentencia para insertar nuevos tubos de Arriba
            if (home.tuboArriba.get(home.contadorTubosArriba - 1).getPosicionX() < 210) {

                home.tuboArriba.add(new Tubos(420, posY, 0, 60, 300));
                home.tubosArriba.add(new JLabel(home.imgTuboArriba));
                home.tubosArriba.get(home.contadorTubosArriba).setBounds(home.tuboArriba.get(home.contadorTubosArriba).getPosicionX(), home.tuboArriba.get(home.contadorTubosArriba).getPosicionArribaY(), 60, 300);
                home.tubosArriba.get(home.contadorTubosArriba).setVisible(true);
                home.fondo.add(home.tubosArriba.get(home.contadorTubosArriba));
                home.contadorTubosArriba++;
            }

            //Sentencia para insertar nuevos tubos de Abajo
            if (home.tuboAbajo.get(home.contadorTubosAbajo - 1).getPosicionX() < 210) {

                home.tuboAbajo.add(new Tubos(420, 0, posY + 420, 60, 300));
                home.tubosAbajo.add(new JLabel(home.imgTuboAbajo));
                home.tubosAbajo.get(home.contadorTubosAbajo).setBounds(home.tuboAbajo.get(home.contadorTubosAbajo).getPosicionX(), home.tuboAbajo.get(home.contadorTubosAbajo).getPosicionArribaY(), 60, 300);
                home.tubosAbajo.get(home.contadorTubosAbajo).setVisible(true);
                home.fondo.add(home.tubosAbajo.get(home.contadorTubosAbajo));
                home.contadorTubosAbajo++;
            }

            //For para mover los tubos que halla en la Ventana
            for (int i = 0; i < home.tuboArriba.size(); i++) {
                home.tuboAbajo.get(i).moverTubos();
                home.tuboArriba.get(i).moverTubos();

                home.tubosArriba.get(i).setBounds(home.tuboArriba.get(i).getPosicionX(), home.tuboArriba.get(i).getPosicionArribaY(), 60, 300);
                home.tubosAbajo.get(i).setBounds(home.tuboAbajo.get(i).getPosicionX(), home.tuboAbajo.get(i).getPosicionAbajoY(), 60, 300);
            }

            //fondo.update(ventana.getGraphics());
        });
        tubosTimer.start();

    }

    public void timerBird() {

        birdTimer = new Timer(10, (ae) -> {

            if (home.colibri.isArriba()) {
                //ave.setIcon(imgColibriArriba);
                home.contadorArribaPajaro++;
            }
            if (home.contadorArribaPajaro == 25) {
                home.colibri.setArriba(false);
                //ave.setIcon(imgColibriAbajo);

                home.sonidoArriba.stop();
                home.contadorArribaPajaro = 0;
            } else {

                home.colibri.saltaPajaro();
                home.ave.setBounds(home.colibri.getPosicionX(), home.colibri.getPosicionY(), home.colibri.getTamaño(), home.colibri.getTamaño());
                //fondo.update(ventana.getGraphics());
            }
        });
        birdTimer.start();
    }

    public void eventos() {
        this.home.ventana.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    home.colibri.setArriba(true);
                    home.sonidoArriba.play();
                }

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
    }
    
    public void stop(){
        this.tubosTimer.stop();
        this.birdTimer.stop();
    }
}
