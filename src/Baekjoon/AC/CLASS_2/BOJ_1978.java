/**
 * 문제 : 소수 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 소수 개수
		int numPrime = 0;

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(st.nextToken());
			boolean isPrime = true;

			// 소수 여부 확인
			if (N==1) continue;

			for (int i = 2; i <= Math.sqrt(N); i++) {

				// 약수가 있다면, 소수x
				if (N % i == 0) {
					isPrime = false;
					continue;
				}
			}

			if (isPrime)
				numPrime++;
		}

		System.out.println(numPrime);
	}

}
