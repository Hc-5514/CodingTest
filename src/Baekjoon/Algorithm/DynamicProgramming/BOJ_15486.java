/**
 * 문제 : 퇴사 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15486 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 상담 기간, 금액 입력 받기
		int N = Integer.parseInt(br.readLine().trim());
		int[] T = new int[N + 1]; // 상담 소요 기간
		int[] P = new int[N + 1]; // 상담 금액
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// 해당 일의 최고 수령 금액을 저장
		int[] d = new int[N + 1];
		int maxPay = 0;
		for (int i = 0; i <= N; i++) {
			maxPay = Math.max(maxPay, d[i]);
			// 상담 금액 수령일
			int day = i + T[i];
			// 회사에 N일까지 근무한다.
			if (day > N) {
				continue;
			}
			d[day] = Math.max(d[day], maxPay + P[i]);
		}

		bw.write(d[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
