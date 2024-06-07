/**
 * 문제 : 체크포인트 달리기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_29891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> lists1 = new ArrayList<>();
		List<Integer> lists2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			if (n < 0) {
				lists1.add(n);
			} else {
				lists2.add(n);
			}
		}

		Collections.sort(lists1);
		Collections.sort(lists2, Collections.reverseOrder());

		long distance = 0; // -1,000,000,000 <= n < 1,000,000,000

		for (int i = 0; i < lists1.size(); i++) {
			if (i % K == 0) {
				distance += lists1.get(i) * 2 * -1;
			}
		}

		for (int i = 0; i < lists2.size(); i++) {
			if (i % K == 0) {
				distance += lists2.get(i) * 2;
			}
		}

		bw.write(distance + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
