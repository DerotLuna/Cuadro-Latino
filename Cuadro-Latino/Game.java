import java.util.Scanner;

public class Game{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Iniciando Juego... \n");
		System.out.print(" Ingrese la dimension del tablero: ");
		int value_Dimesion = scanner.nextInt(); System.out.print("\n");
		Board game = new Board(value_Dimesion);
		game.clear();
		boolean flag = true;
		while (flag){
			int answer = 0; String clear = "";
			System.out.println(" (Para afirmar, presione 1. De lo contrario, presione cualquier numero)");
			game.print_Board();
			System.out.print(" Desea ingresar un valor en el tablero?: ");
			answer = scanner.nextInt(); System.out.print("\n");
			if (answer == 1) game.value_Row_Column();
			else flag = false;
			System.out.print("\n Ingrese un numero (cualquiera) y presione enter para limpiar pantalla: ");
			answer = scanner.nextInt(); System.out.print("\n");
			game.clear();
		}
		game.clear();
		System.out.println(" Tablero final:");
		game.print_Board();
	}
}
