/**
 * 문제 : 신기한 소수
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {

	static int N;
	static int[] numFirst = { 2, 3, 5, 7 };
	static int[] numOther = { 1, 3, 7, 9 };
	static StringBuilder sb = new StringBuilder();

	// 소수 판별하기
	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// cnt: 현재 자리 수, num: 현재 수
	private static void getPrime(int cnt, int num) {

		// 1 ~ N-1 자리 수가 신기한 소수가 아니라면 return
		if (!isPrime(num))
			return;

		if (cnt == N) {
			sb.append(num).append("\n");
			return;
		}

		// N자리 수까지 다음 수 추가
		for (int i = 0; i < numOther.length; i++) {
			getPrime(cnt + 1, num * 10 + numOther[i]);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 자리 수
		N = Integer.parseInt(br.readLine());

		// N 자리 수 신기한 소수 구하기
		for (int i = 0; i < numFirst.length; i++) {
			getPrime(1, numFirst[i]);
		}

		// 출력
		System.out.println(sb.toString());
		br.close();
	}

}
