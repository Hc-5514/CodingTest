/**
 * 문제: 단어의 개수
 * 난이도: 브론즈 2
 * 메모리: 19876KB, 시간: 168ms
 * 풀이: 문자열
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		bw.write(st.countTokens() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
