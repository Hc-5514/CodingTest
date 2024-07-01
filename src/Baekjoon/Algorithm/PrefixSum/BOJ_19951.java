/**
 * 문제 : 태상이의 훈련소 생활
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] high = new int[N];
		for (int i = 0; i < N; i++) {
			high[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefixSum = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int k = Integer.parseInt(st.nextToken());
			prefixSum[a] += k;
			prefixSum[b + 1] -= k;
		}

		bw.write(high[0] + prefixSum[0] + " ");
		for (int i = 1; i < N; i++) {
			prefixSum[i] += prefixSum[i - 1];
			bw.write(high[i] + prefixSum[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
