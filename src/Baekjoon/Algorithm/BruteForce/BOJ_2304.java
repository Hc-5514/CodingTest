/**
 * 문제 : 창고 다각형
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2304 {

	// 기둥 높이 H를 기준으로 내림차순 정렬
	// 현재 기둥에서 이전 기둥 옆까지 현재 기둥의 높이 채운다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim()); // 기둥 개수

		// 기둥을 높이 기준으로 내림차순 정렬
		PriorityQueue<Pillar> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			pq.offer(new Pillar(l, h));
		}

		int[] high = new int[1001];

		Pillar p = pq.poll();
		int prev = p.l;
		high[prev] = p.h;

		while (!pq.isEmpty()) {
			Pillar cur = pq.poll();
			if (high[cur.l] != 0) {
				continue;
			}
			int l = cur.l;
			if (l > prev) {
				while (high[l] == 0 && l > prev) {
					high[l--] = cur.h;
				}
			} else {
				while (high[l] == 0 && l < prev) {
					high[l++] = cur.h;
				}
			}
			prev = cur.l;
		}

		int result = 0;
		for (int i = 0; i < 1001; i++) {
			result += high[i];
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Pillar implements Comparable<Pillar> {
		int l;
		int h;

		public Pillar(int l, int h) {
			this.l = l;
			this.h = h;
		}

		public int compareTo(Pillar p) {
			return p.h - this.h;
		}
	}
}
