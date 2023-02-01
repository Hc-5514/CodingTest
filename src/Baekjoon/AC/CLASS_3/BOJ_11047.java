/**
 * 문제 : 동전 0
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// arr[]: 동전의 가치, cnt: 동전 개수
		int cnt = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// arr 인덱스가 0이 될 때까지
//		while (N > 0) {
//			N--;
//			if (K >= arr[N]) {
//				cnt += (K / arr[N]);
//				K %= arr[N];
//			}
//		}

		// K가 0이 될 때까지
		while (K > 0) {
			N--;
			if (N == -1)
				break;
			if (K >= arr[N]) {
				cnt += (K / arr[N]);
				K %= arr[N];
			}
		}

		System.out.println(cnt);
	}

}
