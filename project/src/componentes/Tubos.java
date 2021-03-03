/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author Daniel Abedoy
 */
public class Tubos {

    private int posicionX;
    private int posicionArribaY;
    private int posicionAbajoY;
    private int tamañoX;
    private int tamañoY;

    public Tubos(int x, int arribaY,int abajoY, int tamañoX,int tamañoY) {
        this.posicionX = x;
        this.posicionArribaY = arribaY;
        this.posicionAbajoY = abajoY;
        this.tamañoX = tamañoX;
        this.tamañoY = tamañoY;
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public void setPosicionX(int posX) {
        this.posicionX = posX;
    }

    
    //Metodo para irmoviendo los Tubos
    public void moverTubos(){
        posicionX -= 1;
    }

    /**
     * @return the posicionArribaY
     */
    public int getPosicionArribaY() {
        return posicionArribaY;
    }

    /**
     * @param posicionArribaY the posicionArribaY to set
     */
    public void setPosicionArribaY(int posicionArribaY) {
        this.posicionArribaY = posicionArribaY;
    }

    /**
     * @return the posicionAbajoY
     */
    public int getPosicionAbajoY() {
        return posicionAbajoY;
    }

    /**
     * @param posicionAbajoY the posicionAbajoY to set
     */
    public void setPosicionAbajoY(int posicionAbajoY) {
        this.posicionAbajoY = posicionAbajoY;
    }

   
}
