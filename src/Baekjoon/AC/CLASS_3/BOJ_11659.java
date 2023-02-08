/**
 * 문제 : 구간 합 구하기 4
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// N, M 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// N개의 수 입력 받기
		st = new StringTokenizer(br.readLine());
		int[] arrN = new int[N];
		int[] arrSum = new int[N];
		arrSum[0] = arrN[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
			arrSum[i] = arrSum[i - 1] + arrN[i];
		}

		// M번 구간 합 구하기
		for (int tc = 1; tc <= M; tc++) {
			// 구간 입력 받기
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 구간 합 구하기
			if (start == 1)
				sb.append(arrSum[end - 1]).append("\n");
			else
				sb.append(arrSum[end - 1] - arrSum[start - 2]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

}
