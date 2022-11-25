/**
 * 문제 : 자릿수 더하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2058 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int sum = 0, tmp;
		while (T > 10) {
			tmp = T;
			sum += T % 10;
			T = tmp / 10;
		}
		sum += T;
		System.out.println(sum);
	}

}
