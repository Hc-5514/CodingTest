/**
 * 문제: 임스와 함께하는 미니게임
 * 난이도: 실버 5
 * 메모리: 25892KB, 시간: 204ms
 * 풀이: HashSet
 */

package Baekjoon.DataStructure.Set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		char mode = st.nextToken().charAt(0);

		Set<String> userSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			userSet.add(br.readLine());
		}

		int cnt = userSet.size();
		int result = (mode == 'Y') ? (cnt) : (mode == 'F') ? (cnt / 2) : (cnt / 3);

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
