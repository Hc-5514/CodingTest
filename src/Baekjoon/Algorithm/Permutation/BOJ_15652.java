/**
 * 문제 : N과 M (4)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15652 {
	private static StringBuilder sb;
	private static int N, M;
	private static int[] selectedNum;

	private static void permutation(int depth, int start) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selectedNum[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			selectedNum[depth] = i;
			permutation(depth + 1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		selectedNum = new int[M];
		permutation(0, 1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
