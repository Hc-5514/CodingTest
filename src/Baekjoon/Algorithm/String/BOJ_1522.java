/**
 * 문제 : 문자열 교환
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1522 {

	// 모든 부분 문자열이 a가 되어야 한다.
	// 슬라이딩 윈도우를 이용해 b의 개수가 가장 적은 부분 문자열을 찾는다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		int aCnt = 0; // 입력 문자열의 a 개수

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'a') {
				aCnt++;
			}
		}

		int bCnt = 0; // 부분 문자열의 b 개수
		for (int i = 0; i < aCnt; i++) {
			if (line.charAt(i) == 'b') {
				bCnt++;
			}
		}

		int answer = bCnt; // 부분 문자열의 b 최소 개수

		// 슬라이딩 윈도우
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'b') {
				bCnt--;
			}
			if (line.charAt((i + aCnt) % line.length()) == 'b') {
				bCnt++;
			}
			answer = Math.min(answer, bCnt);
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
