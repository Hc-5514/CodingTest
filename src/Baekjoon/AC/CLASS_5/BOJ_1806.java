/**
 * 문제 : 부분합
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 잘 읽기 !!!!!!!!!!
 */

public class BOJ_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10 <= N < 100,000 (N의 크기는 10,000 이하)
		int S = Integer.parseInt(st.nextToken()); // 0 < S <= 100,000,000

		int[] numArr = new int[N]; // 수열 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 연속된 수들의 부분 합이 S "이상"이 되는것 중, 가장 짧은 길이 구하기
		// 투 포인터: 합이 S보다 크다면 left 이동, 작다면 right 이동
		int minLen = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;

		for (int right = 0; right < N; right++) {
			sum += numArr[right];

			while (left < right && S <= sum - numArr[left]) {
				sum -= numArr[left++];
			}

			if (S <= sum) {
				minLen = Math.min(minLen, right - left + 1);
			}
		}

		if (minLen == Integer.MAX_VALUE) {
			minLen = 0;
		}

		bw.write(minLen + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
	*** 반례 ***

	1) 답: 1
	5 10
	1 1 1 8 10

	2) 답: 10
	10 10
	1 1 1 1 1 1 1 1 1 1
 */