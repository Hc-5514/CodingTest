/**
 * 문제 : 하노이 탑 이동 순서
 * 
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {

	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void hanoi(int high, int from, int temp, int to) {

		if (high == 0)
			return;

		hanoi(high - 1, from, to, temp);
		sb.append(from + " " + to + "\n");
		cnt++;
		hanoi(high - 1, temp, from, to);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int high = Integer.parseInt(br.readLine());
		hanoi(high, 1, 2, 3);
		
		System.out.println(cnt + "\n" + sb.toString());
	}

}
