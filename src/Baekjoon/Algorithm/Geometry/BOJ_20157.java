/**
 * 문제 : 화살을 쏘자!
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Map<Double, Integer> map1 = new HashMap<>(); // 1,2 사분면
		Map<Double, Integer> map2 = new HashMap<>(); // 3,4 사분면
		int cnt1 = 0; // x == 0, y > 0
		int cnt2 = 0; // x == 0, y < 0
		int cnt3 = 0; // y == 0, x < 0
		int cnt4 = 0; // y == 0, x < 0

		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			double gradient = y / x;

			if (x == 0) {
				if (y > 0) {
					cnt1++;
				} else {
					cnt2++;
				}
				continue;
			}

			if (y == 0) {
				if (x > 0) {
					cnt3++;
				} else {
					cnt4++;
				}
				continue;
			}

			if (y > 0 && x != 0) { // 1,2 사분면
				if (map1.containsKey(gradient)) {
					map1.put(gradient, map1.get(gradient) + 1);
				} else {
					map1.put(gradient, 1);
				}
			}

			if (y < 0 && x != 0) { // 3,4 사분면
				if (map2.containsKey(gradient)) {
					map2.put(gradient, map2.get(gradient) + 1);
				} else {
					map2.put(gradient, 1);
				}
			}
		}

		int maxScore = 0;
		for (int cnt : map1.values()) {
			maxScore = Math.max(maxScore, cnt);
		}

		for (int cnt : map2.values()) {
			maxScore = Math.max(maxScore, cnt);
		}

		maxScore = Math.max(maxScore, cnt1);
		maxScore = Math.max(maxScore, cnt2);
		maxScore = Math.max(maxScore, cnt3);
		maxScore = Math.max(maxScore, cnt4);

		bw.write(maxScore + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
