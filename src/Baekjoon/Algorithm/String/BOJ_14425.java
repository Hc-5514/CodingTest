/**
 * 문제: 문자열 집합
 * 난이도: 실버 4
 * 메모리: 39016KB, 시간: 292ms
 * 풀이: 자료구조 Set
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> S = new HashSet<>();
		for (int i = 0; i < n; i++) {
			S.add(br.readLine());
		}

		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (S.contains(br.readLine())) {
				cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
