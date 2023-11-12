package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BolaDeFuego {
	
	public double x; 
    public double y; ; 
    private Image imagen;
    public double escala;
    public int direccion;
    
    public BolaDeFuego(double x, double y,int direccion) {
    	this.x = x;
    	this.y = y;
    	this.direccion = direccion;
    	this.escala = 0.18;
    	this.imagen = Herramientas.cargarImagen("bola_de_fuego.png");
    }
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(this.imagen,this.x,this.y,0,this.escala);
    }
    
    
    public void mover(Entorno entorno) {

    	   

        if (direccion == 0) {
            y -= 0.7;
            
        }
        if (direccion == 1) {
            x += 0.7;
        }
        if (direccion == 2) {
            y += 0.7;
        }
        if (direccion == 3) {
            x -= 0.7;
        }

}

}
