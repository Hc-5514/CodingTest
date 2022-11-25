/**
 * 문제 : 홀수만 더하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2072 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int sum = 0, num;
			for (int i = 0; i < 10; i++) {
				num = sc.nextInt();
				if (num % 2 == 1)
					sum += num;
			}
			System.out.printf("#%d %d\n", test_case, sum);

		}
	}

}
