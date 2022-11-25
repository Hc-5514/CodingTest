/**
 * 문제 : 최대수 구하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2068 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int max = 0, num;
			for (int i = 0; i < 10; i++) {
				num = sc.nextInt();
				if (num > max)
					max = num;
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
