package juego;

import java.awt.Color;

import entorno.Entorno;

public class Linea {
	
	public double x;
	public double y;
	public double ancho;
	public double alto;

	
	public Linea(double x,double y,double ancho,double alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		
	}
	
	public void dibujarseHorizontal(Entorno entorno) {
		for(int i = 0;i<entorno.ancho();i+=50) {
			entorno.dibujarRectangulo(i, this.y, this.ancho, this.alto, 0, Color.WHITE);
			
		}
		
	}
	
	public void dibujarseVertical(Entorno entorno) {
		for(int i = 0;i<entorno.alto();i+=50) {
			entorno.dibujarRectangulo(this.x, i, this.ancho, this.alto, 0, Color.WHITE);
			
		}
		
	}
}
