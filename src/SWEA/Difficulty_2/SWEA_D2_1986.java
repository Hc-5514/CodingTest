/**
 * 문제 : 지그재그 숫자
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1986 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int N, sum;
		for (int tc = 1; tc <= T; tc++) {

			sum = 0;
			N = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {

				if (i % 2 == 0) // i가 짝수일 때, - 연산
					sum -= i;
				else // i가 홀수일 때, + 연산
					sum += i;
			}

			System.out.println("#" + tc + " " + sum);
		}
	}

}
