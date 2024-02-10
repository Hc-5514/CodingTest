/**
 * 문제 : 풍선 터뜨리기
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

public class BOJ_2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());

		List<Balloon> balloons = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
		}

		// 1 ~ N 번 풍선 존재, N번 다음엔 1번 풍선
		// 인덱스 0 ~ N-1 번
		int cur = 0;
		while (N > 1) {
			// 현재 위치 풍선 터뜨린 후, 위치 갱신
			bw.write(balloons.get(cur).idx + " ");
			int num = balloons.get(cur).num;
			balloons.remove(cur);
			cur = num > 0 ? cur - 1 : cur;
			cur = (cur + num) % balloons.size();
			cur = cur < 0 ? cur + balloons.size() : cur;
			N--;
		}
		bw.write(balloons.get(0).idx + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Balloon {
		int idx;
		int num;

		public Balloon(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
}
