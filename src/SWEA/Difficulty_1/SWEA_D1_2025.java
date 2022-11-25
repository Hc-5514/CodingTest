/**
 * 문제 : N줄 덧셈
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2025 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int sum = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			sum += test_case;
		}

		System.out.println(sum);
	}

}
