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

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private Modo modo;

	Partida(Jugador jugador1, Jugador jugador2, Modo modo) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.modo = modo;
	}

	void comenzarPartida() {
		int intento, intentosConsumidos = 0;
		boolean salir = false;
		int[] array;

		if (modo == Modo.FACIL) {
			if (jugador1 instanceof Usuario) { // Si en el modo facil el jugador 1 es el usuario, la maquina hace la
												// combOculta.
				jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());
				System.out.println("La máquina ha elegido una combinación oculta. Ahora te toca a ti acertarla.\n");
				for (intento = 1; intento <= modo.getNumIntentos() && !salir; intento++) {
					System.out.printf("INTENTO Nº %d. ", intento);
					System.out.printf("Elige el color de las %d fichas:%n", modo.getNumCasillas());
					if (modo != Modo.DIFICIL) {
						System.out.printf("1.%s   2.%s   3.%s   4.%s%n", GRIS, NEGRO, AZUL, ROJO);
						System.out.printf("5.%s   6.%s   7.%s   8.%s%n", AMARILLO, LIMA, TURQUESA, ROSA);
					} else {
						System.out.printf("1.%s   2.%s   3.%s   4.%s   5.%s%n", GRIS, NEGRO, AZUL, ROJO, AMARILLO);
						System.out.printf("6.%s   7.%s   8.%s   9.%s  10.%s%n", LIMA, TURQUESA, ROSA, CELESTE, MORADO);
					}
					jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
					array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
					if (array[0] == 4) {
						salir = true;
						System.out.println("¡HAS GANADO!");
					} else {
						salir = false;
						intentosConsumidos++;
					}
					jugador1.getTablero().dibujar();
					if (intentosConsumidos == modo.getNumIntentos()) {
						System.out.println("¡HAS PERDIDO!");
					}
				}
			} else {

			}
		}
	}
	

	
}
