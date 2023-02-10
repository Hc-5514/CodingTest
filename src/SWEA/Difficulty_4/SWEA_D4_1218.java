/**
 * 문제 : [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_D4_1218 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			Stack<Character> s = new Stack<>();
			int isPair = 1;

			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < len; i++) {
				// 추가: ( [ { <
				// 제거: ) ] } >
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					s.add(str.charAt(i));
				} else {
					char ch = s.pop();
					if (str.charAt(i) == ')') {
						if (ch != '(') {
							isPair = 0;
							break;
						}
					} else if (str.charAt(i) == ']') {
						if (ch != '[') {
							isPair = 0;
							break;
						}
					} else if (str.charAt(i) == '}') {
						if (ch != '{') {
							isPair = 0;
							break;
						}
					} else {
						if (ch != '<') {
							isPair = 0;
							break;
						}
					}
				}

			}

			sb.append(String.format("#%d %d\n", tc, isPair));
		}

		System.out.println(sb);
		br.close();
	}

}
