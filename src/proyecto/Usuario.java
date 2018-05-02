package proyecto;

import static utilidades.Constantes.AMARILLO;
import static utilidades.Constantes.AZUL;
import static utilidades.Constantes.CELESTE;
import static utilidades.Constantes.GRIS;
import static utilidades.Constantes.LIMA;
import static utilidades.Constantes.MORADO;
import static utilidades.Constantes.NEGRO;
import static utilidades.Constantes.ROJO;
import static utilidades.Constantes.ROSA;
import static utilidades.Constantes.TURQUESA;

import java.util.HashMap;

import utilidades.Teclado;
import utilidades.Teclado.Incluido;
import utilidades.Teclado.Tipo;

public class Usuario extends Jugador {

	Usuario(Modo modo) {
		super(modo);
	}

	Combinacion anadirCombinacion() {
		Combinacion c = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccion;

		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
//			System.out.printf("Elige el color de la ficha %d:%n", posicionFicha + 1);
//			if (modo != Modo.DIFICIL) {
//				System.out.printf("1.%s   2.%s   3.%s   4.%s%n", GRIS, NEGRO, AZUL, ROJO);
//				System.out.printf("5.%s   6.%s   7.%s   8.%s%n", AMARILLO, LIMA, TURQUESA, ROSA);
//			} else {
//				System.out.printf("1.%s   2.%s   3.%s   4.%s   5.%s%n", GRIS, NEGRO, AZUL, ROJO, AMARILLO);
//				System.out.printf("6.%s   7.%s   8.%s   9.%s  10.%s%n", LIMA, TURQUESA, ROSA, CELESTE, MORADO);
//			}

			eleccion = Teclado.leerEntre(1, modo.getNumColores(), Incluido.TODOS, Tipo.INT);

			switch (eleccion) {
			case 1:
				color = Color.GRIS;
				break;
			case 2:
				color = Color.NEGRO;
				break;
			case 3:
				color = Color.AZUL;
				break;
			case 4:
				color = Color.ROJO;
				break;
			case 5:
				color = Color.AMARILLO;
				break;
			case 6:
				color = Color.LIMA;
				break;
			case 7:
				color = Color.TURQUESA;
				break;
			case 8:
				color = Color.ROSA;
				break;
			case 9:
				color = Color.CELESTE;
				break;
			case 10:
				color = Color.MORADO;
				break;
			}

			c.anadirFicha(color, posicionFicha);
		}
		return c;
	}

	void anadirRespuesta(Respuesta respuesta) {
		// esto seguramente irá en combinacion oculta HashMap<String, Integer> mapa =
		// new HashMap<>();
		Respuesta r;

	}

	Combinacion anadirCombinacionOculta() {
		return new Combinacion(0);
	}

	Jugada anadirRespuesta(Combinacion combinacion) {
//		Respuesta respuesta = new Respuesta(modo.getNumCasillas());
		int[] respuestas = comprobarJugada(combinacion);
		int aciertos;
		boolean correcto = true;

		do {
			System.out.println("¿Cuántos rojos hay?:");
			aciertos = Teclado.leerEntre(1, 4, Incluido.TODOS, Tipo.INT);
			if (aciertos != respuestas[0]) {
				System.out.println("Te has equivocado al poner los aciertos rojos.");
				correcto = false;
			} else
				correcto = true;
		} while (!correcto);

		do {
			System.out.println("¿Cuántos blancos hay?:");
			aciertos = Teclado.leerEntre(1, 4, Incluido.TODOS, Tipo.INT);
			if (aciertos != respuestas[1]) {
				System.out.println("Te has equivocado al poner los aciertos blancos.");
				correcto = false;
			} else
				correcto = true;
		} while (!correcto);

		return new Jugada(combinacion, crearRespuesta(respuestas), modo);
	}

}
