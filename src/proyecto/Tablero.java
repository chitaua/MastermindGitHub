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
			jugadas.get(i).dibujar();
		}
		System.out.println();
		combinacionOcultaContrario.dibujar();
		System.out.println();
	}
	
}
