/**
 * 문제 : 나누기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int f = Integer.parseInt(br.readLine().trim());

		int answer = n / 100 * 100;
		while (answer % f != 0) {
			answer++;
		}
		answer %= 100;

		System.out.printf("%02d", answer);
		br.close();
	}
}
