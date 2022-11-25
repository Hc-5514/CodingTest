/**
 * 문제 : 큰 놈, 작은 놈, 같은 놈
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2070 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			char ch = a > b ? '>' : (a < b ? '<' : '=');
			System.out.println("#" + test_case + " " + ch);
		}
	}

}
