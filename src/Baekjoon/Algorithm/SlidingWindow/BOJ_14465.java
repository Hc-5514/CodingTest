/**
 * 문제 : 소가 길을 건너간 이유 5
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14465 {

	// 1~N번 까지의 횡단보도에 신호등이 있다.
	// 몇몇 신호등이 망가진 상태지만, 연속된 K개의 신호등이 존재하도록 수리하려고 한다.

	// 슬라이딩 윈도우, 누적합 풀이 가능
	// 슬라이딩 윈도우로 해결

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean[] info = new boolean[n];
		Arrays.fill(info, true);

		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(br.readLine().trim()) - 1;
			info[num] = false;
		}

		int minCnt = 0;
		for (int i = 0; i < k; i++) {
			if (!info[i]) {
				minCnt++;
			}
		}

		int cnt = minCnt;
		for (int i = 1; i <= n - k; i++) {
			cnt = info[i - 1] ? cnt : cnt - 1;
			cnt = info[i + k - 1] ? cnt : cnt + 1;
			minCnt = Math.min(minCnt, cnt);
		}

		bw.write(minCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
