/**
 * 문제 : 이건 꼭 풀어야 해!
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17390 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] ori = new int[N];
		int[] prefixSum = new int[N + 1];

		// 배열 입력 받은 후 오름차순(비내림차순) 정렬
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ori[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ori);

		// 누적합 구하기
		for (int i = 0; i < N; i++) {
			prefixSum[i + 1] = prefixSum[i] + ori[i];
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			bw.write(prefixSum[to] - prefixSum[from - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}