package proyecto;

import java.util.HashMap;

public abstract class Jugador {
	protected Tablero tablero;
	protected Modo modo;

	Jugador(Modo modo) {
		tablero = new Tablero(modo);
		this.modo = modo;
	}

	public Tablero getTablero() {
		return tablero;
	}

	int[] comprobarJugada(Combinacion combinacion) { // Comprobar ganador.
		HashMap<Color,Integer> mapa = new HashMap<>();
		int arrayRespuestas[] = new int[3];
		Color color = null;
		int posicion = 0;
		boolean salir = false;

		for (int i = 0; i < modo.getNumCasillas(); i++) {
			for (int j = 0; j < modo.getNumCasillas() && !salir; j++) {
				if (combinacion.getFichas()[i].equals(tablero.getCombinacionOcultaPropia().getFichas()[j])) {
					if (i == j) {
						arrayRespuestas[0]++;
						salir = true;
						if (mapa.containsKey(combinacion.getFichas()[i].getColor())) {
							arrayRespuestas[1]--;
						}
					} else {
						if (!mapa.containsKey(combinacion.getFichas()[i].getColor())) {
							arrayRespuestas[1]++;
							mapa.put(combinacion.getFichas()[i].getColor(), i);
						}
					}
				}
			}
			salir = false;
		}

		if (arrayRespuestas[0] + arrayRespuestas[1] < modo.getNumCasillas()) {
			arrayRespuestas[2] = modo.getNumCasillas() - (arrayRespuestas[0] + arrayRespuestas[1]);
		}

		for (int i = 0; i < arrayRespuestas.length; i++) {
			for (int j = 0; j < arrayRespuestas[i]; j++) {
				if (i == 0) {
					color = Color.ROJO;
				} else if (i == 1) {
					color = Color.GRIS;
				} else {
					color = Color.NEGRO;
				}
				posicion++;
			}
		}

		return arrayRespuestas;
	}

	Respuesta crearRespuesta(int[] arrayRespuestas) {
		Respuesta respuesta = new Respuesta(modo.getNumCasillas());
		Color color = null;
		int posicion = 0;

		for (int i = 0; i < arrayRespuestas.length; i++) {
			for (int j = 0; j < arrayRespuestas[i]; j++) {
				if (i == 0) {
					color = Color.ROJO;
				} else if (i == 1) {
					color = Color.GRIS;
				} else {
					color = Color.NEGRO;
				}
				respuesta.anadirFicha(color, posicion);
				posicion++;
			}
		}
		
		return respuesta;
	}

	abstract Jugada anadirRespuesta(Combinacion combinacion);

	abstract Combinacion anadirCombinacion();

	abstract Combinacion anadirCombinacionOculta();

}
