/**
 * 문제 : 빗물
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] map = new int[w];
		for (int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<>();
		int cnt = 0;
		int first = 0;

		for (int i = 0; i < w; i++) {
			if (s.isEmpty()) {
				if (map[i] != 0) {
					first = map[i];
					s.push(first);
				}
				continue;
			}
			if (first > map[i]) {
				s.push(map[i]);
			} else {
				while (!s.isEmpty()) {
					cnt += (first - s.pop());
				}
				first = map[i];
				s.push(first);
			}
		}

		int last = s.pop();
		while (!s.isEmpty()) {
			int cur = s.pop();
			if (last >= cur) {
				cnt += (last - cur);
			} else {
				last = cur;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
