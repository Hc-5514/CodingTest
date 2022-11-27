/**
 * 문제 : [S/W 문제해결 기본] 4일차 - 거듭 제곱
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1217 {

	public static int resultPow(int a, int b) {

		if (b == 0)
			return 1;
		else {
			return a * resultPow(a, b - 1);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;

		for (int tc = 1; tc <= 10; tc++) {

			br.readLine(); // 테케 번호 불필요
			str = br.readLine();
			st = new StringTokenizer(str, " ");

			// N: 숫자, M: 거듭제곱 횟수
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.println("#" + tc + " " + resultPow(N, M));
		}
	}

}
