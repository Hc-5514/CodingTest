/**
 * 문제 : 다이어트
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BOJ_19942 {

	// n개의 식재료 중 m개를 선택하여 영양분 기준치를 넘겨야 한다.
	// 만족하는 재료 집합의 최솟값 구하기, 없으면 -1 출력

	private static int n, minPrice;
	private static List<Integer> list;
	private static int[] standard;
	private static int[][] material;

	/*
	 total: 단백질, 지방, 탄수화물, 비타민, 비용
	 selected: 선택된 재료 번호
	 */
	private static void permutation(int start, int[] total, List<Integer> selected) {
		// 가지치기
		if (minPrice <= total[4]) {
			return;
		}

		// 최솟값 갱신
		if (standard[0] <= total[0] && standard[1] <= total[1] && standard[2] <= total[2] && standard[3] <= total[3]) {
			minPrice = total[4];
			list = selected;
			return;
		}

		for (int i = start; i < n; i++) {
			int[] newTotal = new int[5];
			for (int j = 0; j < 5; j++) {
				newTotal[j] = total[j] + material[i][j];
			}
			List<Integer> newSelected = new ArrayList<>(selected);
			newSelected.add(i);
			permutation(i + 1, newTotal, newSelected);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		init();
		permutation(0, new int[] {0, 0, 0, 0, 0}, new ArrayList<>());

		// 출력
		minPrice = (minPrice == Integer.MAX_VALUE) ? -1 : minPrice;
		bw.write(minPrice + "\n");
		if (minPrice != -1) {
			for (int n : list) {
				bw.write((n + 1) + " ");
			}
		}

		bw.flush();
		bw.close();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		minPrice = Integer.MAX_VALUE;
		list = new ArrayList<>();

		n = Integer.parseInt(br.readLine().trim());
		standard = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		material = new int[n][];
		for (int i = 0; i < n; i++) {
			material[i] = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		br.close();
	}
}
