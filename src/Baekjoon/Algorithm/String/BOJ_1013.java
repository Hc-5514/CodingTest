/**
 * 문제: Contact
 * 난이도: 골드 5
 * 메모리: 15332KB, 시간: 124ms
 * 풀이: 정규 표현식
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1013 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// (100+1+ | 01)+ 패턴을 지닌 전파 구분
		String regex = "^(100+1+|01)+$";

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			String input = br.readLine();
			bw.write(input.matches(regex) ? "YES\n" : "NO\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
