/**
 * 문제 : 치킨 배달
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {

	static int M, minDist = Integer.MAX_VALUE;
	static int[] selected;
	static List<int[]> houseList;
	static List<int[]> chickenList;

	private static void combination(int depth, int start) {
		if (depth == M) {
			getDist();
			return;
		}

		for (int i = start; i < chickenList.size(); i++) {
			selected[depth] = i;
			combination(depth + 1, i + 1);
		}
	}

	private static void getDist() {
		int total = 0;
		for (int i = 0; i < houseList.size(); i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int r = Math.abs(houseList.get(i)[0] - chickenList.get(selected[j])[0]);
				int c = Math.abs(houseList.get(i)[1] - chickenList.get(selected[j])[1]);
				dist = Math.min(dist, r + c);
			}
			total += dist;
			if (total >= minDist) {
				return;
			}
		}
		minDist = total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 1: 집, 2: 치킨집
				if (num == 1) {
					houseList.add(new int[] {i, j});
				}
				if (num == 2) {
					chickenList.add(new int[] {i, j});
				}
			}
		}

		selected = new int[M];
		combination(0, 0);

		bw.write(minDist + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
