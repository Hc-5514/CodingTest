/**
 * 문제 : 몫과 나머지 출력하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2029 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int a, b;
		for (int test_case = 1; test_case <= T; test_case++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.printf("#%d %d %d\n", test_case, a / b, a % b);
		}

	}

}
