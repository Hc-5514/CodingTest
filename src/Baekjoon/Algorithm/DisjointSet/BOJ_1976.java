/**
 * 문제 : 여행 가자
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DisjointSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1976 {

	static int[] parent;

	private static int find(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = find(parent[n]);
	}

	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim()); // 1 <= N <= 200
		int M = Integer.parseInt(br.readLine().trim()); // 1 <= M <= 1,000

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					union(i, j);
				}
			}
		}

		boolean flag = true;
		st = new StringTokenizer(br.readLine());
		int p = find(Integer.parseInt(st.nextToken()) - 1);
		for (int i = 1; i < M; i++) {
			if (p != find(Integer.parseInt(st.nextToken()) - 1)) {
				flag = false;
				break;
			}
		}

		if (flag) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
