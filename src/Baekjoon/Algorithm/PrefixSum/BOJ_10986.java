/**
 * 문제 : 나머지 합
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

public class BOJ_10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] restCnt = new int[M];
		int rest = 0; // 이전 수까지의 누적합을 M 으로 나눈 나머지

		// 나머지 별 개수 구하기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rest = (rest + Integer.parseInt(st.nextToken())) % M;
			restCnt[rest]++;
		}

		// M 으로 나눠떨어지는 구간 개수 구하기
		long answer = restCnt[0];
		for (int i = 0; i < M; i++) {
			answer += (long)restCnt[i] * (restCnt[i] - 1) / 2;
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}