/**
 * 문제 : N과 M (10)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15664 {

	// 1 <= M <= N <= 8
	static int N, M;
	static int[] selectedNum;
	static int[] arrN;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<>();

	public static void combination(int cnt, int start) {

		if (cnt == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int n : selectedNum) {
				sb2.append(n).append(" ");
			}
			sb2.append("\n");
			if (!hs.contains(sb2.toString())) {
				sb.append(sb2.toString());
				hs.add(sb2.toString());
			}
			return;
		}

		for (int i = start; i < N; i++) {

			selectedNum[cnt] = arrN[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N, M 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arrN = new int[N];
		selectedNum = new int[M];

		// N개의 숫자 값 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrN);
		combination(0, 0);

		System.out.println(sb.toString());
		br.close();
	}

}
