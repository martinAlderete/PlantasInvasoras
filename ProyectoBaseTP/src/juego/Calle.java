package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Calle {
	
	public double x; 
    public double y;
    
    public double ancho;
    public double alto;
    
    
    public Calle(double x, double y,double ancho,double alto) {
    	this.x = x;
    	this.y = y;
    	this.ancho = ancho;
    	this.alto = alto;
    	
    	

    	
    }
    
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.DARK_GRAY);
    	
        
    	
    	
    }
    
    

}
