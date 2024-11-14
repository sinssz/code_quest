import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int round = scanner.nextInt();
		scanner.nextLine();
		String[] a = scanner.nextLine().split(" ");
		String[] b = scanner.nextLine().split(" ");

		solutions(round, a, b);

	}


	public static void solutions(int round, String[] a, String[] b) {
		for(int i = 0; i < round; i++ ){
			String winner =  getWinner(Integer.valueOf(a[i]), Integer.valueOf(b[i]));
			System.out.println(winner);
		}

	}

	public static String getWinner(int a, int b) {

		// a == 1
		if(a == 1) {
			switch (b) {
				case 1:
					return "D";
				case 2:
					return "B";
				case 3:
					return "A";
			}
		}
		// a == 2
		if(a == 2) {
			switch (b) {
				case 1:
					return "A";
				case 2:
					return "D";
				case 3:
					return "B";
			}
		}

		// a == 3
		if(a == 3) {
			switch (b) {
				case 1:
					return "B";
				case 2:
					return "A";
				case 3:
					return "D";
			}
		}
		throw new RuntimeException();
	}
}