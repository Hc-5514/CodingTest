/**
 * 문제 : 아름이의 돌 던지기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1285 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {

			// N 명이 던진 돌의 위치 받기
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			String str = br.readLine();
			st = new StringTokenizer(str);

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 최소 거리 및 인원 수 구하기
			int min = 100000, count = 0;
			for (int i = 0; i < N; i++) {

				// 양수 변환
				if (arr[i] < 0)
					arr[i] = -arr[i];

				if (arr[i] < min) {
					min = arr[i];
					count = 1;
				} else if (arr[i] == min) {
					count++;
				}
			}

			System.out.printf("#%d %d %d", tc, min, count);
		}
	}

}
