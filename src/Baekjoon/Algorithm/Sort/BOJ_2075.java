/**
 * 문제 : N번째 큰 수
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
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		List<Integer> list = new ArrayList<>(N * N);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(list, Collections.reverseOrder());

		bw.write(list.get(N - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
