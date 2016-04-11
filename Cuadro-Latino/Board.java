import java.util.Scanner;

public class Board{
	public int dimension;
	public int[][] board;
	Scanner scanner = new Scanner(System.in);

	public void clear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public Board(int value_Dimesion){
		dimension = value_Dimesion;
		board = new int[dimension][dimension];
		for(int row = 0; row < dimension; row++)
			for(int column = 0; column < dimension; column++)
				board[row][column] = 0;
	}

	public boolean evaluate_Column(int value, int column){ // Evaluates the row is not repeated
		boolean flag = true;
		for(int row = 0; row < dimension; row++){
			if (board[row][column] == value){
				flag = false;
				System.out.println(" Ya esta " + value + "en esa columna");
				break;
			}
		}
		return flag;
	}

	public boolean evaluate_Row(int value, int row){ // Evaluates the row is not repeated
		boolean flag = true;
		for(int column = 0; column < dimension; column++){
			if (board[row][column] == value){
				flag = false;
				System.out.println(" Ya esta " + value + " en esa fila");
				break;
			}
		}
		return flag;
	}

	public void assign_Value_Board(int value, int row, int column){
		int answer = 0;
		if(board[row][column] == value) System.out.println(" En [" + row +"," + column + "] esta " + value + " ya asignado!");
	  else if (evaluate_Row(value, row) && evaluate_Column(value, column)){
			if (board[row][column] != 0){
				System.out.println(" En [" + row +"," + column + "] esta " + board[row][column]);
				System.out.print(" Si desea reemplazarlo por " + value + " presione 1: ");
				answer = scanner.nextInt(); System.out.print("\n");
			}
			if (answer == 1 || board[row][column] == 0) {
				board[row][column] = value;
				System.out.println(" El valor " + value + " asignado en [" + row +"," + column + "]" + " con exito!");
			}
			else System.out.println(" El valor no ha sido reemplazado");
		}
	}

	public void print_Board(){
		System.out.print("\n");
		for(int row = 0; row < dimension; row++){
			System.out.print("                                   |");
			for(int column = 0; column < dimension; column++)
				System.out.print(board[row][column] + "|");
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public int scanner_Value_Row_Column(int answer){
		int give_Back = 0; boolean flag = true;
		while(flag == true){
			if (answer == 1) System.out.print(" Ingrese valor: ");
			else if (answer == 2) System.out.print(" Ingrese fila: ");
			else System.out.print(" Ingrese columna: ");
			give_Back = scanner.nextInt(); System.out.print("\n");
			if (answer == 1 && (give_Back <= dimension) && (give_Back > 0)) flag = false;
			else if (answer != 1 && (give_Back < dimension) && (give_Back >= 0)) flag = false;
			else System.out.print(" Valor incorrecto. \n");
		}
		return give_Back;
	}

	public void value_Row_Column(){
	    int value = 0, row = 0, column = 0;
			value = scanner_Value_Row_Column(1);
			row = scanner_Value_Row_Column(2);
			column = scanner_Value_Row_Column(3);
			assign_Value_Board(value, row, column);
		}

/*	public void scanner_Value_Row_Column(){
		boolean flag = true;
    int value = 0, row = 0, column = 0;
		while(flag == true){
			System.out.print(" Ingrese valor: ");
			value = scanner.nextInt(); System.out.print("\n");
			if ((value <= dimension) && (value > 0)) flag = false;
			else System.out.println(" Valor incorrecto");
		}
		while(flag == false){
			System.out.print(" Ingrese fila: ");
			row = scanner.nextInt(); System.out.print("\n");
			if ((row <= dimension) && (value > 0)) flag = true;
			else System.out.println(" Valor incorrecto");
		}

		while(flag == true){
			System.out.print(" Ingrese columna: ");
			column = scanner.nextInt(); System.out.print("\n");
			if ((column <= dimension) && (value > 0)) flag = false;
			else System.out.println(" Valor incorrecto");
		}
		assign_Value(value, row, column);
	} */
}
