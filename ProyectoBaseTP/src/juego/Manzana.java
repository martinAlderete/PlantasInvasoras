package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Manzana {
	
	public double x; 
    public double y; 
    public double ancho;
    public double alto;
    private Image imagen;
    public double escala;
    
    public Manzana(double x, double y) {
    	this.x = x;
    	this.y = y;
    	this.imagen = Herramientas.cargarImagen("manzana.png");
    	this.escala = 0.37;
    	this.ancho = imagen.getWidth(null)*escala;
        this.alto = imagen.getHeight(null)*escala;
        
     
    }
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(this.imagen,this.x,this.y,0,this.escala);

    }
    
    
    
	
	

}
