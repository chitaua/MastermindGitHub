package utilidades;

public final class Constantes {
	// No puede tener descendencia (por el final)

	// Evita que se creen objetos de esta clase (solo es para las constantes)
	private Constantes() {
	}

	// CUADRADOS DE COLORES.
	//private static final char CUADRADO1 = 9608;
	public static final char CUADRADO = 9632;
	public static final char CIRCULO = 11044;
	//private static final String CUADRADO = Character.toString(CUADRADO1) + Character.toString(CUADRADO1);
	
	

	public static final String NEGRO = Colores.NEGRO + CUADRADO + Colores.RESET;
	public static final String BLANCO = Colores.BLANCO + CUADRADO + Colores.RESET;
	public static final String GRIS = Colores.GRIS + CUADRADO + Colores.RESET;
	public static final String ROSA = Colores.ROSA + CUADRADO + Colores.RESET;
	public static final String ROJO = Colores.ROJO + CUADRADO + Colores.RESET;
	public static final String BURDEOS = Colores.BURDEOS + CUADRADO + Colores.RESET;
	public static final String VERDE = Colores.VERDE + CUADRADO + Colores.RESET;
	public static final String AMARILLO = Colores.AMARILLO + CUADRADO + Colores.RESET;
	public static final String MARRON = Colores.MARRON + CUADRADO + Colores.RESET;
	public static final String AZUL = Colores.AZUL + CUADRADO + Colores.RESET;
	public static final String MORADO = Colores.MORADO + CUADRADO + Colores.RESET;
	public static final String CELESTE = Colores.CELESTE + CUADRADO + Colores.RESET;
	public static final String TURQUESA = Colores.TURQUESA + CUADRADO + Colores.RESET;
	public static final String LIMA = Colores.LIMA + CUADRADO + Colores.RESET;

	static final int TOTAL_FORMAS = 3;
	static final int NUMEROS_MAX = 100;
	static final int ULTIMADIMENSION = 2;
	static final int UN_DIGITO = 1;
	static final int DOS_DIGITOS = 2;

}
