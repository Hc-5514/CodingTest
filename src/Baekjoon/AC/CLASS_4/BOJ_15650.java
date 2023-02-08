/**
 * 문제 : N과 M (2)
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

	// 1 <= M <= N <= 8
	static int[] selectedNum;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	// cnt: 현재 인덱스, start: 중복이 안되므로 다음 숫자부터 시작
	public static void combination(int cnt, int start) {

		// 기저 조건: cnt가 M이 되면 종료
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selectedNum[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			selectedNum[cnt] = i;
			// 중복이 안되므로, 현재 수의 다음 수부터 시작
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selectedNum = new int[M];

		combination(0, 1);
		System.out.println(sb.toString());
	}

}
