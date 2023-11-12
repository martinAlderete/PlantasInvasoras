package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	
	public double x; 
    public double y; ; 
    private Image[] imagen;
    public double escala;
    public int direccion;
    
    public Auto(double x, double y,int direccion) {
    	this.x = x;
    	this.y = y;
    	this.direccion = direccion;
    	this.escala = 0.10;
    	this.imagen = new Image[4];
    	
    	for (int i = 0; i < imagen.length; i++) {

            imagen[i] = Herramientas.cargarImagen("auto" + i + ".png");

        }
    }
    
    public void dibujarse(Entorno entorno) {
    	entorno.dibujarImagen(this.imagen[this.direccion],this.x,this.y,0,this.escala);
    }
    
    public void mover(Entorno entorno) {


		if (this.direccion == 0) {
			y -= 1;
			if (y < 25) {
				y = entorno.alto() - 25;
			}
		}
		if (this.direccion == 1) {
			x += 1;
			if(x > entorno.ancho()) {
				x = 25;
			}
		}
		if (this.direccion == 2) {
			y += 1;
			if(y > entorno.alto()) {
				y = 25;
			}
		}
		if (this.direccion == 3) {
			x -= 1;
			
			if(x < 25) {
				x = entorno.ancho()-25;
			}
		}

	}

}
