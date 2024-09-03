/**
 * 문제 : 올림픽
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

public class BOJ_8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 국가 수
		int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

		List<Country> countries = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken()); // 국가 번호
			int gold = Integer.parseInt(st.nextToken()); // 금
			int silver = Integer.parseInt(st.nextToken()); // 은
			int bronze = Integer.parseInt(st.nextToken()); // 동
			countries.add(new Country(no, gold, silver, bronze));
		}

		Collections.sort(countries, (o1, o2) -> {
			if (o1.gold == o2.gold) {
				if (o1.silver == o2.silver) {
					return o2.bronze - o1.bronze;
				}
				return o2.silver - o1.silver;
			}
			return o2.gold - o1.gold;
		});

		int rank = 0;
		if (countries.get(0).no != k) {
			for (int i = 1; i < countries.size(); i++) {
				Country cur = countries.get(i);
				if (!cur.equals(countries.get(i - 1))) {
					rank = i;
				}
				if (cur.no == k) {
					break;
				}
			}
		}

		bw.write((rank + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Country {
		int no;
		int gold;
		int silver;
		int bronze;

		public Country(int no, int gold, int silver, int bronze) {
			this.no = no;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		public boolean equals(Country c) {
			return this.gold == c.gold && this.silver == c.silver && this.bronze == c.bronze;
		}
	}
}
