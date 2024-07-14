/**
 * 문제 : Cow Pizza
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1887 {

	// N개의 테스트 케이스, T개 중 Z개의 토핑을 제외하여 만들 수 있는 피자의 종류 개수 구하기

	// 비트마스킹

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 토핑 번호 T (1 ~ T)
		int N = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수 (1 <= N <= 52)

		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int Z = Integer.parseInt(st.nextToken()); // 제외 토핑 개수 (1 <= Z <= T)
			int sum = 0;
			for (int j = 0; j < Z; j++) {
				sum += (int)Math.pow(2, Integer.parseInt(st.nextToken()) - 1);
			}
			nums[i] = sum;
		}

		int result = 0;
		int size = (int)Math.pow(2, T);
		for (int i = 0; i < size; i++) {
			result++;
			for (int j = 0; j < N; j++) {
				if ((i & nums[j]) == nums[j]) {
					result--;
					break;
				}
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
