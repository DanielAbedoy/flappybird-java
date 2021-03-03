/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author Alumno
 */
public class Bird {
    
    private int posicionX;
    private int posicionY;
    private int tamaño;
    private boolean arriba = false;
    
    public Bird(int x , int y, int tamaño){
        this.posicionX = x;
        this.posicionY = y;
        this.tamaño = tamaño;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void saltaPajaro(){
        if (arriba) {
            this.posicionY -= 2;
        }else{
            this.posicionY += 2;
        }
 
    }

    /**
     * @return the arriba
     */
    public boolean isArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }
    
    
}
