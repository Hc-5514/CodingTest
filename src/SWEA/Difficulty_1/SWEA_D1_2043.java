/**
 * 문제 : 서랍의 비밀번호
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2043 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int K = sc.nextInt();

		if (P >= K)
			System.out.println(P - K + 1);
		else
			System.out.println(999 - K + P + 2);

	}

}
