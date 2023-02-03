/**
 * 문제 : 숫자 카드 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] arr = new int[20000001];

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
		}

		System.out.println(sb);
	}

}
