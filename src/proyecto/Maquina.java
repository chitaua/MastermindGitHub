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

import java.util.Arrays;
import java.util.Random;

import utilidades.Teclado;
import utilidades.Teclado.Incluido;
import utilidades.Teclado.Tipo;

public class Maquina extends Jugador {

	Maquina(Modo modo) {
		super(modo);
	}

	@Override
	Combinacion anadirCombinacion() {
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccion;

		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			eleccion = rnd.nextInt(modo.getNumColores()) + 1;

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

			combinacion.anadirFicha(color, posicionFicha);
		}
		return combinacion;

	}

	@Override
	Combinacion anadirCombinacionOculta() {
		Random rnd = new Random();
		Combinacion combinacionOculta = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccionAleatoria, contador = 0;
		int elecciones[] = new int[modo.getNumCasillas()];
		boolean salir = false;
		
		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			do {
				salir = false;
				eleccionAleatoria = rnd.nextInt(modo.getNumColores()) + 1;
				for (int i = 0; i < elecciones.length && !salir; i++) {
					if (eleccionAleatoria != elecciones[i]) 
						contador++;	
					else {
						contador = 0;
						salir = true;
					}
				}
			} while (contador != modo.getNumCasillas());
			
			contador = 0;
			elecciones[posicionFicha] = eleccionAleatoria;

			switch (eleccionAleatoria) {
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

			combinacionOculta.anadirFicha(color, posicionFicha);
		}

		tablero.setCombinacionOcultaPropia(combinacionOculta);

		return combinacionOculta;
	}

	Jugada anadirRespuesta(Combinacion combinacion) {
		Respuesta respuesta = new Respuesta(modo.getNumCasillas());
		int [] respuestas = comprobarJugada(combinacion);
		int aciertos;
		boolean correcto = true;

		return new Jugada(combinacion, crearRespuesta(respuestas), modo);
	}

	

}
