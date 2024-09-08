/**
 * 문제 : 문자열 게임 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20437 {

	private static int minLen, maxLen;
	private static List<List<Integer>> alphas;

	private static void init() {
		minLen = 100_000;
		maxLen = 0;
		alphas = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			alphas.add(new ArrayList<>());
		}
	}

	private static void getLength(int cnt) {
		for (int i = 0; i < 26; i++) {
			int size = alphas.get(i).size();
			if (size < cnt) {
				continue;
			}
			for (int j = 0; j <= size - cnt; j++) {
				int start = alphas.get(i).get(j);
				int end = alphas.get(i).get(j + cnt - 1);
				int len = end - start + 1;
				minLen = Math.min(minLen, len);
				maxLen = Math.max(maxLen, len);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < t; tc++) {
			init();
			String line = br.readLine();
			int cnt = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < line.length(); i++) {
				alphas.get(line.charAt(i) - 97).add(i);
			}
			getLength(cnt);
			if (minLen == 100_000 && maxLen == 0) {
				bw.write(-1 + "\n");
			} else {
				bw.write(minLen + " " + maxLen + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
