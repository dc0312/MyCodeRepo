import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int area = scanner.nextInt();

		int perimeter = scanner.nextInt();

		int aFirstSide = scanner.nextInt();
		double semiPerimeter = perimeter / 2;

		int sumOfOtherSides = Math.abs(perimeter - aFirstSide);

		int bSecondSide = sumOfOtherSides - 1;
		int cThirdSide = 1;

		int count = 0;
		while (bSecondSide >= sumOfOtherSides / 2) {

			double aa = 2 * (semiPerimeter
					* ((semiPerimeter - aFirstSide) * (semiPerimeter - bSecondSide) * (semiPerimeter - cThirdSide)));

			double newArea = Math.sqrt(aa);
			if (newArea > area) {
				count++;
			}
			bSecondSide--;
			cThirdSide++;
		}

		System.out.println(count);
	}

}
