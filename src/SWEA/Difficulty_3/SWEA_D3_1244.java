/**
 * 문제 : [S/W 문제해결 응용] 2일차 - 최대 상금
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D3_1244 {

	private static int maxNum;

	private static void dfs(String n, int goal, int cnt) {
		if (cnt == goal) {
			maxNum = Math.max(maxNum, Integer.parseInt(n));
			return;
		}

		// 완전 탐색
		for (int i = 0; i < n.length() - 1; i++) {
			for (int j = i + 1; j < n.length(); j++) {
				dfs(swap(n, i, j), goal, cnt + 1);
			}
		}
	}

	private static String swap(String n, int idx1, int idx2) {
		StringBuilder sb = new StringBuilder(n);
		char ch1 = n.charAt(idx1);
		char ch2 = n.charAt(idx2);
		sb.setCharAt(idx1, ch2);
		sb.setCharAt(idx2, ch1);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int goal = Integer.parseInt(st.nextToken());

			maxNum = 0;

			if (goal > n.length()) {
				goal = n.length();
			}

			dfs(n, goal, 0);

			bw.write("#" + tc + " " + maxNum + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
