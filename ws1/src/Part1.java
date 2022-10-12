import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		int rows = 0;
		int cols = 0;
		int[][] matrix;
		boolean valid = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter the number of rows: ");
				rows = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
		do {
			try {
				System.out.print("Enter the number of columns: ");
				cols = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
		matrix = new int[rows][cols];
		System.out.println("Enter the matrix: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				do {
					try {
						System.out.print("m[" + i + "][" + j + "]=");
						matrix[i][j] = sc.nextInt();
						valid = true;
					} catch (Exception e) {
						System.out.println("Invalid input");
						valid = false;
					}
				} while (!valid);
			}
		}
		System.out.println("Matrix inputted: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.format("%3d", matrix[i][j]);
			}
			System.out.print("\n");
		}
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + (float) sum / (rows * cols));
	}
}