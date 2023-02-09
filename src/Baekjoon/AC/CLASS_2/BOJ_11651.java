/**
 * 문제 : 좌표 정렬하기 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// N개의 좌표 입력 받기
		int N = Integer.parseInt(br.readLine());
		int[][] arrCoordinate = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrCoordinate[i][0] = Integer.parseInt(st.nextToken());
			arrCoordinate[i][1] = Integer.parseInt(st.nextToken());
		}

		// 좌표 정렬하기 (1순위: x좌표, 2순위: y좌표)
		Arrays.sort(arrCoordinate, (s1, s2) -> {
			// x좌표가 같다면 y좌표 순 정렬
			if (s1[1] == s2[1]) {
				return s1[0] - s2[0];
			}
			// x좌표 순 정렬
			return s1[1] - s2[1];
		});

		// 출력
		for (int i = 0; i < arrCoordinate.length; i++) {
			sb.append(arrCoordinate[i][0]).append(" ").append(arrCoordinate[i][1]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
