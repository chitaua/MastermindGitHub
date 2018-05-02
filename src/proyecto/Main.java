package proyecto;

import static utilidades.Constantes.*;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		System.out.printf("1.%s   2.%s   3.%s   4.%s   5.%s%n", GRIS, NEGRO, AZUL, ROJO, AMARILLO);
		System.out.printf("6.%s   7.%s   8.%s   9.%s  10.%s%n", LIMA, TURQUESA, ROSA, CELESTE, MORADO);
		Menu menu = new Menu();
		menu.configurarPartida().comenzarPartida();

//		Combinacion c = new Combinacion(4);
//		c.anadirFicha(Color.ROJO, 0);
//		c.anadirFicha(Color.AZUL, 1);
//		c.anadirFicha(Color.LIMA, 2);
//		c.anadirFicha(Color.ROJO, 3);
//
//		Respuesta r = new Respuesta(4);
//		r.anadirFicha(Color.ROJO, 0);
//		r.anadirFicha(Color.ROJO, 1);
//		r.anadirFicha(Color.ROJO, 2);
//		r.anadirFicha(Color.ROJO, 3);
//
//		Jugada j = new Jugada(c, Modo.FACIL);
//		j.setRespuesta(r);
//
//		Tablero t = new Tablero(Modo.FACIL);
//
//		t.anadirJugada(j);
//		t.dibujar();

	}

	
}
