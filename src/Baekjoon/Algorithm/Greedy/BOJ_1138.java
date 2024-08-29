/**
 * 문제 : 한 줄로 서기
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
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_1138 {

	// 키가 더 큰 사람이 왼쪽에 몇 명 있는지 주어진다.

	// 키가 가장 큰 사람부터 차례대로 위치를 찾아간다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim()); // n명의 사람들
		int[] sizes = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		List<Integer> orders = new ArrayList<>();
		orders.add(n);
		f1:
		for (int i = n - 1; i > 0; i--) {
			int cnt = 0; // 현재 나보다 큰 사람 수
			for (int j = 0; j < orders.size(); j++) {
				if (sizes[i - 1] == cnt) {
					orders.add(j, i);
					continue f1;
				}
				if (orders.get(j) > i) {
					cnt++;
				}
			}
			orders.add(i);
		}

		for (int order : orders) {
			bw.write(order + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
