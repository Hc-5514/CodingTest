/**
 * 문제 : 덩치
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// N명 덩치 입력 받기 { 몸무게, 키 }
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = 1;
		}

		// 완전 탐색
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				// 본인 제외 다른 사람만 비교
				if (i == j)
					continue;
				// 몸무게가 작을 때
				if (arr[i][0] < arr[j][0]) {
					// 키도 작다면
					if (arr[i][1] < arr[j][1]) {
						cnt++;
					}
				}
			}
			arr[i][2] = cnt;
		}

		for (int i = 0; i < N; i++) {
			sb.append(arr[i][2] + " ");
		}

		System.out.println(sb);
		br.close();
	}
}
