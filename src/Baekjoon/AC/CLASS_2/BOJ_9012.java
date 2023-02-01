/**
 * 문제 : 괄호
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			Stack<Character> stack = new Stack<>();
			boolean isVPS = true;

			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				} else {
					if (!stack.empty())
						stack.pop();
					else {
						isVPS = false;
						break;
					}

				}

			}

			if (isVPS) {
				if (stack.empty()) {
					System.out.println("YES");
				} else
					System.out.println("NO");
			} else
				System.out.println("NO");

		}
	}

}
