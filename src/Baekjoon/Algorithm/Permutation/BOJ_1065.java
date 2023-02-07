/**
 * 문제 : 한수
 * 
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		if (N < 100)
			result = N;
		else {
			result = 99;
			// 100 ~ N까지 탐색
			f1: for (int i = N; i >= 100; i--) {
				// 각 자릿수 저장하기
				String strNum = String.valueOf(i);
				int sub = Character.getNumericValue(strNum.charAt(0)) - Character.getNumericValue(strNum.charAt(1));
				for (int j = 1; j < strNum.length() - 1; j++) {
					if (sub != (Character.getNumericValue(strNum.charAt(j))
							- Character.getNumericValue(strNum.charAt(j + 1))))
						continue f1;
				}
				result++;
			}

		}

		System.out.println(result);
	}

}
