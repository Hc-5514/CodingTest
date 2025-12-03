/**
 * 문제: 괄호
 * 난이도: 실버 4
 * 메모리: 11744KB, 시간: 72ms
 * 풀이: 자료구조 Stack
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			Stack<Character> st = new Stack<>();
			boolean isVPS = true;

			String inputString = br.readLine();
			for (int i = 0; i < inputString.length(); i++) {
				char c = inputString.charAt(i);
				if (c == '(') {
					st.push(c);
				} else if (st.isEmpty()) {
					isVPS = false;
					break;
				} else {
					st.pop();
				}
			}
			if (st.isEmpty() && isVPS) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
