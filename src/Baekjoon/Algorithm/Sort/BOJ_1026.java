/**
 * 문제 : 보물
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[] arrA = new int[N];
		int[] arrB = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA);
		Arrays.sort(arrB);

		int S = 0;
		for (int i = 0; i < N; i++) {
			S += arrA[i] * arrB[N - i - 1];
		}

		bw.write(S + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
