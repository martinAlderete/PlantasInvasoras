package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rayo {
	
	public double x; 
    public double y; ; 
    private Image[] imagen;
    public double escala;
    public int direccion;
    
    public Rayo(double x, double y,int direccion) {
    	this.direccion = direccion;
    	this.x = x;
    	this.y = y;
    	this.escala = 0.1;
    	this.imagen = new Image[4];
    	
    	for (int i = 0; i < imagen.length; i++) {

            imagen[i] = Herramientas.cargarImagen("rayo" + i + ".png");

        }
    }
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(this.imagen[this.direccion],this.x,this.y,0,this.escala);
    }
    
    public void mover(Entorno entorno) {

   

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

}
}
