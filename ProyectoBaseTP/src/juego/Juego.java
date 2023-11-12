package juego;

import java.awt.Color;
import java.awt.Image;
import java.math.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Image fondo;
	private Layka layka;
	private Manzana[] manzanas;
	private Calle[] calles;
	private PlantaMutante[] plantas;
	private Auto[] autos;
	private int puntaje;
	private Linea[] lineas;
	private Rayo rayo;
	private BolaDeFuego bolaDeFuego;
	private boolean hayDisparoR;
	private Image gameOver;
	private Image ganaste;
	private boolean juegoActivo;
	
	

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo 1 - v1", 1024, 768);
		layka = new Layka(this.entorno.ancho() / 2, this.entorno.alto() - 50);

		calles = new Calle[7];
		lineas = new Linea[7];
		// Calles Horizontales
		calles[0] = new Calle(this.entorno.ancho() / 2, this.entorno.alto() / 2, this.entorno.ancho(), 100); // Segunda
		// calle
		// horizontal
		lineas[0] = new Linea(this.entorno.ancho() / 2, this.entorno.alto() / 2, 20, 3);
		calles[1] = new Calle(this.entorno.ancho() / 2, 50, this.entorno.ancho(), 100); // Primera calle horizontal
		lineas[1] = new Linea(this.entorno.ancho() / 2, 50, 20, 3);
		calles[2] = new Calle(this.entorno.ancho() / 2, this.entorno.alto() - 50, this.entorno.ancho(), 100); // Tercera
		// calle
		// horizontal
		lineas[2] = new Linea(this.entorno.ancho() / 2, this.entorno.alto() - 50, 20, 3);

		// Calles Verticales
		calles[3] = new Calle(50, this.entorno.alto() / 2, 100, this.entorno.alto()); // Primera calle vertical
		lineas[3] = new Linea(50, this.entorno.alto() / 2, 3, 20);
		calles[4] = new Calle(this.entorno.ancho() - 50, this.entorno.alto() / 2, 100, this.entorno.alto()); // Ultima
		// calle
		// vertical
		lineas[4] = new Linea(this.entorno.ancho() - 50, this.entorno.alto() / 2, 3, 20);
		calles[5] = new Calle((this.entorno.ancho() / 3) + 50 / 3, this.entorno.alto() / 2, 100, this.entorno.alto()); // Segunda
		// calle
		// vertical
		lineas[5] = new Linea((this.entorno.ancho() / 3) + 50 / 3, this.entorno.alto() / 2, 3, 20);
		calles[6] = new Calle(((this.entorno.ancho() * 2) / 3) - 50 / 3, this.entorno.alto() / 2, 100,this.entorno.alto()); // Tercera calle vertical
		lineas[6] = new Linea(((this.entorno.ancho() * 2) / 3) - 50 / 3, this.entorno.alto() / 2, 3,20);

		manzanas = new Manzana[6];
		manzanas[0] = new Manzana(calcularDistancia(calles[3].x, calles[5].x) / 2,
				calcularDistancia(calles[0].y, calles[1].y) / 2);
		manzanas[1] = new Manzana(calcularDistancia(calles[3].x, calles[5].x) / 2,
				calcularDistancia(calles[0].y, calles[2].y) / 2);

		manzanas[2] = new Manzana(calcularDistancia(calles[6].x, calles[5].x) / 2,
				calcularDistancia(calles[0].y, calles[2].y) / 2);
		manzanas[3] = new Manzana(calcularDistancia(calles[4].x, calles[6].x) / 2,
				calcularDistancia(calles[0].y, calles[2].y) / 2);

		manzanas[4] = new Manzana(calcularDistancia(calles[6].x, calles[5].x) / 2,
				calcularDistancia(calles[0].y, calles[1].y) / 2);
		manzanas[5] = new Manzana(calcularDistancia(calles[6].x, calles[4].x) / 2,
				calcularDistancia(calles[0].y, calles[1].y) / 2);

		plantas = new PlantaMutante[4];
		plantas[0] = new PlantaMutante(calles[3].x, calles[0].y);
		plantas[1] = new PlantaMutante(calles[4].x,calles[6].y);
		plantas[2] = new PlantaMutante(calles[5].x,calles[4].y);
		plantas[3] = new PlantaMutante(calles[6].x,calles[5].y);
		hayDisparoR = false;

		



		autos = new Auto[3];
		autos[0] = new Auto(calles[3].x/2,calles[1].y/2,1);
		autos[1] = new Auto(calles[5].x-calles[5].ancho/3,calles[2].y,0);
		autos[2] = new Auto(calles[4].x,calles[0].y-(calles[0].alto/2),3);






		puntaje = 0;
		this.juegoActivo = true;
		
		this.gameOver = Herramientas.cargarImagen("game_over.png");
		this.ganaste = Herramientas.cargarImagen("ganaste.png");
		

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		if(juegoActivo) {
			
		
		int randomCalleVertical = (int) (Math.random() * 4) + 3;
		int randomCalleHorizontal = (int)(Math.random()*3);
		
		

		entorno.dibujarRectangulo(entorno.ancho()/2, entorno.alto()/2,entorno.ancho() ,entorno.alto() ,0 ,Color.DARK_GRAY );
		
		for(int i = 0; i<calles.length;i++) {
			calles[i].dibujarse(this.entorno);
		}
		
		for(int i = 0;i<3;i++) {
			lineas[i].dibujarseHorizontal(this.entorno);
		}

		for(int i= 3; i<7;i++) {
			lineas[i].dibujarseVertical(this.entorno);
		}
	



		for(int i = 0;i<plantas.length;i++) {

			if(plantas[i] != null) {
				plantas[i].dibujarse(this.entorno);
				plantas[i].mover(i,this.entorno);

				if(colisionPlantaLayka(plantas[i])) {
					plantas[i] = null;
					this.layka = null;

				}

				if(colisionRayoPlanta(plantas[i]) ) {
					this.rayo = null;
					plantas[i] = null;
					puntaje++;


				}
			}

			if(plantas[i] == null && i == 0) {
				plantas[i] = new PlantaMutante(calles[randomCalleVertical].x,calles[randomCalleVertical].y);
				plantas[i].dibujarse(this.entorno);
				plantas[i].mover(i,this.entorno);
			}
			if(plantas[i] == null && i == 1 ) {

				plantas[i] = new PlantaMutante(calles[randomCalleVertical].x, calles[randomCalleHorizontal].y);
				plantas[i].dibujarse(this.entorno);
				plantas[i].mover(i,this.entorno);
			}
			if(plantas[i] == null && i == 2 ) {

				plantas[i] = new PlantaMutante(calles[randomCalleVertical].x, calles[randomCalleVertical].y);
				plantas[i].dibujarse(this.entorno);
				plantas[i].mover(i,this.entorno);
			}
			if(plantas[i] == null && i == 3) {
				plantas[i] = new PlantaMutante(calles[randomCalleVertical].x,calles[randomCalleVertical].y);
				plantas[i].dibujarse(this.entorno);
				plantas[i].mover(i,this.entorno);
			}
		}



		for(int i = 0; i< manzanas.length;i++) {
			manzanas[i].dibujarse(this.entorno);
		}


		for(int i = 0;i<autos.length;i++) {
			if(autos[i] != null) {
				autos[i].dibujarse(this.entorno);
				autos[i].mover(this.entorno);

				if(colisionAutoLayka(autos[i])) {
					autos[i] = null;
					this.layka = null;
				}
				if(colisionRayoAuto(autos[i])) {
					this.rayo = null;
				}
				
				
				if(colisionBolaAuto(autos[i])) {
					autos[i] = null;
					}
				
			}

			if(autos[i] == null && i == 0) {
				autos[i] = new Auto(calles[randomCalleVertical].x,calles[randomCalleHorizontal].y-(calles[randomCalleHorizontal].alto/2),3);
				autos[i].dibujarse(this.entorno);
				autos[i].mover(this.entorno);
			}
			if(autos[i] == null && i == 1 ) {

				autos[i] = new Auto(calles[randomCalleVertical].x,calles[randomCalleHorizontal].y-(calles[randomCalleHorizontal].alto/2),1);
				autos[i].dibujarse(this.entorno);
				autos[i].mover(this.entorno);
			}
			if(autos[i] == null && i == 2 ) {

				autos[i] = new Auto(calles[randomCalleVertical].x-calles[randomCalleVertical].ancho/3,calles[randomCalleHorizontal].y,0);
				autos[i].dibujarse(this.entorno);
				autos[i].mover(this.entorno);
			}


		}

		if (layka != null ) {
			layka.dibujarse(this.entorno);
			if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && restriccionManzanasMultiples(manzanas, layka) != 0) {
				layka.mover(0, this.entorno);
			}
			if (entorno.estaPresionada(entorno.TECLA_DERECHA) && restriccionManzanasMultiples(manzanas, layka) != 1) {
				layka.mover(1, this.entorno);
			}
			if (entorno.estaPresionada(entorno.TECLA_ABAJO) && restriccionManzanasMultiples(manzanas, layka) != 2) {
				layka.mover(2, this.entorno);
			}
			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && restriccionManzanasMultiples(manzanas, layka) != 3) {
				layka.mover(3, this.entorno);
			}
			if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && !hayDisparoR && this.rayo == null ) {
				rayo = new Rayo(layka.x,layka.y,layka.direccion);
				hayDisparoR = true;
			}
			if(hayDisparoR && !esNullRayo()) {
				rayo.dibujarse(this.entorno);
				rayo.mover(this.entorno);

			}

			if(esNullRayo()) {
				hayDisparoR = false;
			}






			for(int i = 0;i<this.plantas.length;i++) {

				if(this.bolaDeFuego == null && plantas[i] != null) {
					this.bolaDeFuego = new BolaDeFuego(plantas[i].x, plantas[i].y, plantas[i].direccion);


				}

				if(this.bolaDeFuego != null) {
					this.bolaDeFuego.dibujarse(this.entorno);
					this.bolaDeFuego.mover(this.entorno);



				}
				if(colisionLaykaBola()) {
					this.layka = null;
					this.bolaDeFuego = null;
				}

				if(esNullBolaDeFuego()) {
					this.bolaDeFuego = null;

				}
				if(colisionRayoBola()) {
					this.bolaDeFuego = null;
					this.rayo = null;

				}



			}

			this.entorno.cambiarFont("Arial",24, Color.YELLOW);
			this.entorno.escribirTexto("Puntaje: " + puntaje, 0, 25);
			
		}
	}
			if(this.puntaje == 10 && juegoActivo) {
				this.entorno.dibujarRectangulo(this.entorno.ancho()/2, this.entorno.alto()/2, this.entorno.ancho(), this.entorno.alto(), 0, Color.darkGray);
				this.entorno.dibujarImagen(this.ganaste,this.entorno.ancho()/2, this.entorno.alto()/2, 0,0.6);
				
			}
			
			



		else if(this.layka == null){
			this.entorno.dibujarRectangulo(this.entorno.ancho()/2, this.entorno.alto()/2, this.entorno.ancho(), this.entorno.alto(), 0, Color.darkGray);
			this.entorno.dibujarImagen(this.gameOver, this.entorno.ancho()/2, this.entorno.alto()/2, 0,1.5);
			juegoActivo = false;
			
		}
		
		
		
		

	}
	
	

	public int restriccionManzana(Manzana m, Layka k, int limite) {

		double zonaIzq = m.x - (m.ancho / 2);
		double zonaDer = m.x + (m.ancho / 2);
		double zonaArrib = m.y - (m.alto / 2);
		double zonaAbaj = m.y + (m.alto / 2);

		if (k.x > zonaIzq - limite && k.x < zonaDer && k.y > zonaArrib && k.y < zonaAbaj) {
			return 1;
		}
		if (k.x < zonaDer + limite && k.x > zonaIzq && k.y > zonaArrib && k.y < zonaAbaj) {
			return 3;
		}
		if (k.x < zonaDer && k.x > zonaIzq && k.y > zonaArrib - limite && k.y < zonaAbaj) {
			return 2;
		}
		if (k.x < zonaDer && k.x > zonaIzq && k.y < zonaAbaj + limite && k.y > zonaArrib) {
			return 0;
		}

		return 5;
	}
	
	

	public int restriccionManzanasMultiples(Manzana[] m, Layka k) {

		for (int i = 0; i < m.length; i++) {
			if (restriccionManzana(m[i], k, 30) < 5) {
				return restriccionManzana(m[i], k, 30);
			}
		}
		return 5;
	}

	public double calcularDistancia(double a, double b) {

		return Math.abs(a + b);

	}

	public boolean esNullRayo() {
		if (this.rayo == null) {
			return true; // Si rayo es null, considerarlo como que ha pasado los límites.
		}

		if (this.rayo.x > this.entorno.ancho() || this.rayo.x < 0 ||
				this.rayo.y > this.entorno.alto()  || this.rayo.y < 0 ) {
			this.rayo = null; // Si el rayo está fuera de los límites, establecerlo como null
			return true;
		}

		return false;
	}

	public boolean esNullBolaDeFuego() {
		if (bolaDeFuego == null) {
			return true; 
		}

		if (bolaDeFuego.x > this.entorno.ancho() || bolaDeFuego.x < 0 ||
				bolaDeFuego.y > this.entorno.alto()  || bolaDeFuego.y < 0 ) {
			bolaDeFuego = null; 
			return true;
		}




		return false;
	}

	public boolean colisionLaykaBola() {
		if(bolaDeFuego != null && this.layka != null) {
			if(bolaDeFuego.x > this.layka.x-40 && bolaDeFuego.x < this.layka.x+40 && bolaDeFuego.y > this.layka.y-40 && bolaDeFuego.y < this.layka.y+40) {
				return true;
			}

		}
		return false;
	}

	public boolean colisionPlantaLayka(PlantaMutante p) {
		if(p != null && this.layka != null) {
			if(p.x > this.layka.x-40 && p.x < this.layka.x+40 && p.y > this.layka.y-40 && p.y < this.layka.y+40) {
				return true;
			}

		}
		return false;
	}

	public boolean colisionAutoLayka(Auto a) {
		if(a != null && this.layka != null) {
			if(a.x > this.layka.x-40 && a.x < this.layka.x+40 && a.y > this.layka.y-40 && a.y < this.layka.y+40) {
				return true;
			}

		}
		return false;
	}

	public boolean colisionRayoPlanta(PlantaMutante p) {


		if(this.rayo != null && p != null) {
			if(this.rayo.x > p.x-40 && this.rayo.x < p.x+40 && this.rayo.y > p.y-40 && this.rayo.y < p.y+40) {
				return true;
			}

		}

		return false;
	}

	public boolean colisionRayoBola() {
		if(this.rayo != null && bolaDeFuego != null) {
			if(this.rayo.x > bolaDeFuego.x-40 && this.rayo.x < bolaDeFuego.x+40 && this.rayo.y > bolaDeFuego.y-40 && this.rayo.y < bolaDeFuego.y+40) {
				return true;
			}

		}

		return false;
	}

	public boolean colisionRayoAuto(Auto a) {
		if(this.rayo != null && a != null) {
			if(this.rayo.x > a.x-40 && this.rayo.x < a.x+40 && this.rayo.y > a.y-40 && this.rayo.y < a.y+40) {
				return true;
			}

		}

		return false;
	}
	
	public boolean colisionBolaAuto(Auto a) {
		if(bolaDeFuego != null && a != null) {
			if(bolaDeFuego.x > a.x-55 && bolaDeFuego.x < a.x+55 && bolaDeFuego.y > a.y-55 && bolaDeFuego.y < a.y+55) {
				return true;
			}

		}

		return false;
	}




	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
