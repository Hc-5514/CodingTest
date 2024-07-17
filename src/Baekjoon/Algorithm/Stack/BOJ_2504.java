/**
 * 문제 : 괄호의 값
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2504 {

	// 괄호열 읽고 계산하여 출력하기
	// (): 2, []:3
	// 올바르지 않은 괄호열은 0 출력

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine(); // 1 <= line.length() <= 30

		Stack<Character> stack = new Stack<>();

		int result = 0;
		int value = 1;
		f1:
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			switch (ch) {
				case '(':
					stack.push('(');
					value *= 2; // ( : 2
					break;
				case '[':
					stack.push('[');
					value *= 3; // [ : 3
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						result = 0;
						break f1;
					} else {
						if (line.charAt(i - 1) == '(') {
							result += value;
						}
						stack.pop();
						value /= 2;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						result = 0;
						break f1;
					} else {
						if (line.charAt(i - 1) == '[') {
							result += value;
						}
						stack.pop();
						value /= 3;
					}
					break;
			}
		}

		result = stack.isEmpty() ? result : 0;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
