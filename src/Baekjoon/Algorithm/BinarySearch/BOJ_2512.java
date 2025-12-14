/**
 * 문제: 예산
 * 난이도: 실버 2
 * 메모리: 13772KB, 시간: 108ms
 * 풀이: 매개변수 탐색
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2512 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 이분 탐색: 예산 배정
		int low = 0;
		int high = 0;

		// 입력
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputNums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputNums[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, inputNums[i]);
		}
		int m = Integer.parseInt(br.readLine().trim());

		while (low <= high) {
			int mid = (low + high) >> 1; // 상한액
			int total = 0; // 배정된 예산 총합
			for (int i = 0; i < n; i++) {
				total += Math.min(inputNums[i], mid);
			}
			// 상한액만큼 배정 후 예산이 남는다면
			if (total <= m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		bw.write(high + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
