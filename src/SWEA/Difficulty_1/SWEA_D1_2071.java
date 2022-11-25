/**
 * 문제 : 평균값 구하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2071 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			double sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += sc.nextInt();
			}
			System.out.printf("#%d %d\n", test_case, Math.round(sum / 10));
		}

	}

}
