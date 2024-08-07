/**
 * 문제 : 안테나 
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
import java.util.StringTokenizer;

public class BOJ_18310 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[] houses = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(houses);

		int answer = N % 2 == 0 ? N / 2 - 1 : N / 2;

		bw.write(houses[answer] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
