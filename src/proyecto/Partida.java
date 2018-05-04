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
			if (jugador1 instanceof Usuario) { // Si en el modo facil el jugador 1 es el usuario, la maquina hace la combOculta.
				jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());
				System.out.println("La máquina ha elegido una combinación oculta. Ahora te toca a ti adivinarla.\n");
				for (intento = 1; intento <= modo.getNumIntentos() && !salir; intento++) {
					System.out.printf("INTENTO Nº %d. ", intento);
					jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
					array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
					salir = comprobarJugada(array, intento);
				}
			} else {
				System.out.println("Elige una combinación oculta para que la máquina la intente adivinar.");
				System.out.printf("Elige los colores de las %d fichas: %n", modo.getNumCasillas());
				jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());
				for (intento = 1; intento <= modo.getNumIntentos() && !salir; intento++) {
					System.out.printf("INTENTO Nº %d%n", intento);
					System.out.printf("Combinación oculta: ");
					jugador1.getTablero().getCombinacionOcultaContrario().dibujar();
					jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
					array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
					salir = comprobarJugada(array, intento);
				}
			}
		}
	}
	
	boolean comprobarJugada(int[] array, int intentosConsumidos) {
		boolean salir = false;
		
		jugador1.getTablero().dibujar();
		
		if (array[0] == 4) {
			salir = true;
			System.out.println("¡HAS GANADO!");
		} else {
			salir = false;
			if (intentosConsumidos == modo.getNumIntentos()) {
				System.out.println("¡HAS PERDIDO!");
			}
		}
		
		return salir;
	}

	
}
