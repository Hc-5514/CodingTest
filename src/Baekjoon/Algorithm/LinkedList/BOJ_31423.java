/**
 * 문제 : 신촌 통폐합 계획
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_31423 {

	private static void add(Universe oriUniv, Universe newUniv) {
		while (oriUniv.next != null) {
			oriUniv = oriUniv.next;
		}
		oriUniv.next = newUniv;
	}

	private static String getName(Universe univ) {
		StringBuilder sb = new StringBuilder();
		while (univ.next != null) {
			sb.append(univ.name);
			univ = univ.next;
		}
		sb.append(univ.name);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim()); // 대학교 개수
		Universe[] heads = new Universe[N + 1];
		Universe[] tails = new Universe[N + 1];

		for (int i = 1; i <= N; i++) {
			heads[i] = new Universe(i, br.readLine(), null);
			tails[i] = heads[i];
		}

		int headNo = 0;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			add(tails[a], heads[b]);
			tails[a] = tails[b];
			heads[b] = heads[a];
			headNo = a;
		}

		bw.write(getName(heads[headNo]));
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Universe {
		int no;
		String name;
		Universe next;

		public Universe(int no, String name, Universe next) {
			this.no = no;
			this.name = name;
			this.next = next;
		}
	}
}
