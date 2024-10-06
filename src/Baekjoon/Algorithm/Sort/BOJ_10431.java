/**
 * 문제 : 줄세우기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10431 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // tc와 동일
			int cnt = 0;
			List<Integer> lists = new ArrayList<>();
			lists.add(Integer.parseInt(st.nextToken()));
			for (int i = 1; i < 20; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (lists.get(lists.size() - 1) < n) {
					lists.add(n);
					continue;
				}
				for (int j = 0; j < lists.size(); j++) {
					if (n <= lists.get(j)) {
						cnt += (lists.size() - j);
						lists.add(j, n);
						break;
					}
				}
			}
			bw.write(tc + " " + cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
