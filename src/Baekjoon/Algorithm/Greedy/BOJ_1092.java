/**
 * 문제 : 배
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim()); // (1 <= N <= 50)
		Integer[] crane = new Integer[N]; // (1<= // (1<= box[i] <= 1,000,000)[i] <= 1,000,000)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine().trim()); // (1 <= M <= 10,000)
		Integer[] box = new Integer[M]; // (1<= box[i] <= 1,000,000)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		// 내림차순 정렬
		Arrays.sort(crane, Collections.reverseOrder());
		Arrays.sort(box, Collections.reverseOrder());

		// 가장 무거운 박스 무게 > 크레인 무게 제한
		if (box[0] > crane[0]) {
			bw.write("-1\n");
		} else {
			int[] craneCnt = new int[N];
			int time = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// 마지막 크레인
					if (j == N - 1) {
						craneCnt[j]++;
						time = Math.max(time, craneCnt[j]);
						break;
					}
					// 옮긴 횟수가 가정 적은 크레인 선택
					if (crane[j + 1] >= box[i] && craneCnt[j] >= craneCnt[j + 1]) {
						continue;
					}
					craneCnt[j]++;
					time = Math.max(time, craneCnt[j]);
					break;
				}
			}
			bw.write(time + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
