package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Layka {
	public double x; 
    public double y;												
    int direccion;
    private Image[] img;
    public double escala;

    public Layka(double x, double y) {
        this.x = x;
        this.y = y;
        this.escala = 0.15;
        this.direccion = 0;
        this.img = new Image[4];
        
        for (int i = 0; i < img.length; i++) {

            img[i] = Herramientas.cargarImagen("layka" + i + ".png");

        }
      }
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(this.img[this.direccion],this.x,this.y,0,this.escala);
    }

    public void mover(int direccion, Entorno entorno) {

        this.direccion = direccion;

        if (direccion == 0) {
            y -= 2.5;
        }
        if (direccion == 1) {
            x += 2.5;
        }
        if (direccion == 2) {
            y += 2.5;
        }
        if (direccion == 3) {
            x -= 2.5;
        }


        if (x > entorno.ancho() - 20) {
            this.x = entorno.ancho() - 20;
        }
        if (x < 20) {
            this.x = 20;
        }
        if (y > entorno.alto() - 30) {
            this.y = entorno.alto() - 30;
        }
        if (y < 30) {
            this.y = 30;
        }
    }
    
    
    

  
}
