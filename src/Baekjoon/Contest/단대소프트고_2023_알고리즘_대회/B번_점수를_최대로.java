/**
 * 문제 : B번 - 점수를 최대로
 *
 * @author Hc-5514
 */

package Baekjoon.Contest.단대소프트고_2023_알고리즘_대회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B번_점수를_최대로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 누적합 구하기
		st = new StringTokenizer(br.readLine());
		long[] prefixSum = new long[N];
		prefixSum[0] = Long.parseLong(st.nextToken());
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + Long.parseLong(st.nextToken());
		}

		// 누적합 중 가장 큰 값을 K 개 찾아서 더하기
		Arrays.sort(prefixSum);
		long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += prefixSum[N - 1 - i];
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
