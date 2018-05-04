package proyecto;

import java.util.LinkedList;

public class Tablero implements Dibujable{
	private LinkedList<Jugada> jugadas = new LinkedList <Jugada>();
	private Combinacion combinacionOcultaPropia;
	private Combinacion combinacionOcultaContrario;
	private Modo modo;
	
	Tablero(Modo modo) {
		this.modo = modo;
	}

	public LinkedList<Jugada> getJugadas() {
		return jugadas;
	}

	public Combinacion getCombinacionOcultaPropia() {
		return combinacionOcultaPropia;
	}

	public void setCombinacionOcultaPropia(Combinacion combinacionOcultaPropia) {
		this.combinacionOcultaPropia = combinacionOcultaPropia;
	}

	public Combinacion getCombinacionOcultaContrario() {
		return combinacionOcultaContrario;
	}

	public void setCombinacionOcultaContrario(Combinacion combinacionOcultaContrario) {
		this.combinacionOcultaContrario = combinacionOcultaContrario;
	}

	public void anadirJugada(Jugada jugada) {
		this.jugadas.addLast(jugada);
	}
	
	public void dibujar() {		
		for (int i = 0; i < jugadas.size(); i++) {
			if (i<10) {
				System.out.printf("Intento %d:   ", i+1);
			} else {
				System.out.printf("Intento %d:  ", i+1);
			}
			jugadas.get(i).dibujar();
		}
		System.out.print("Combinación oculta: ");
		combinacionOcultaContrario.dibujar();
		System.out.printf("%n-------------------------%n");
	}
	
}
