package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class PlantaMutante {

	public double x;
	public double y;
	private Image imagen;
	public double escala;
	public int direccion;
	public boolean disparo;

	public PlantaMutante(double x, double y) {
		this.x = x;
		this.y = y;
		this.disparo = false;
		this.direccion = 1;
		this.escala = 0.10;
		imagen = Herramientas.cargarImagen("planta_mutante.png");
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0, this.escala);
	}

	public void mover(int direccion, Entorno entorno) {

		this.direccion = direccion;

		if (direccion == 0) {
			y -= 1;
			if (y < 25) {
				y = entorno.alto() - 25;
			}
		}
		if (direccion == 1) {
			x += 1;
			if(x > entorno.ancho()) {
				x = 25;
			}
		}
		if (direccion == 2) {
			y += 1;
			if(y > entorno.alto()) {
				y = 25;
			}
		}
		if (direccion == 3) {
			x -= 1;
			
			if(x < 25) {
				x = entorno.ancho()-25;
			}
		}

	}
	
	
}
