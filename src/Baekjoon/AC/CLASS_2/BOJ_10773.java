/**
 * 문제 : 제로
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		// 스택에 수 넣기
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				stack.pop();
			} else
				stack.add(n);
		}

		// 스택에 있는 요소 합 구하기
		int sum = 0;

		while (stack.size() > 0) {
			sum += stack.pop();
		}

		System.out.println(sum);
		br.close();
	}

}
