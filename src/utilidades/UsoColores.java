package utilidades;
import static utilidades.Colores.*;

public class UsoColores {

	public static void main(String[] args) {
		
		final String CELESTE_BLANCO = "\u001B[36;47m"; //Detrás del código del CELESTE(36) se pone ; y el código del fondo blanco(47)
		final String CELESTE_BLANCO_NEGRITA = "\u001B[1;36;47m"; //1 es el código del negrita
		final String CELESTE_BLANCO_SUBRAYADO = "\u001B[4;36;47m"; //4 es el código del subrayado
		final String ROJO_AMARILLO = "\u001B[33;41m";
		
		System.out.println(ROJO + "Este texto es de color rojo" + RESET);
		System.out.println(VERDE + "...y ahora es verde" + RESET);
		System.out.println(FONDO_MORADO + "Fondo morado" + RESET);
		System.out.println(CELESTE_BLANCO + "Fondo blanco con texto celeste" + RESET);
		System.out.println(CELESTE_BLANCO_NEGRITA + "Fondo blanco con texto celeste en negrita" + RESET);
		System.out.println(CELESTE_BLANCO_SUBRAYADO + "Fondo blanco con texto celeste subrayado" + RESET);
		System.out.printf("%s",ROJO_AMARILLO +(char)9733 + RESET);//Estrella
		
	}
}
