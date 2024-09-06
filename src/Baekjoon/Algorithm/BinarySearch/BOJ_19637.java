/**
 * 문제 : IF문 좀 대신 써줘
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19637 {
	private static int n;

	private static int[] powers;

	private static int binarySearch(int power) {
		int s = 0;
		int e = n;

		while (s < e) {
			int m = (s + e) >> 1;
			if (power <= powers[m]) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 칭호의 개수
		int m = Integer.parseInt(st.nextToken()); // 캐릭터 개수

		String[] names = new String[n];
		powers = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			powers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int power = Integer.parseInt(br.readLine().trim());
			bw.write(names[binarySearch(power)] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
