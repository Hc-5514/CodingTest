/**
 * 문제 : 임시 반장 정하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1268 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[][] students = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int num = 0;
		for (int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < N; k++) {
					if (i == k) {
						continue;
					}
					if (students[i][j] == students[k][j]) {
						set.add(k);
					}
				}
			}
			if (set.size() > max) {
				max = set.size();
				num = i;
			}
		}

		bw.write((num + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
