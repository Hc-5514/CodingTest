/**
 * 문제: 단어의 개수
 * 난이도: 브론즈 2
 * 메모리: 11604KB, 시간: 68ms
 * 풀이: 상수
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2908 {

	public static int convert(String numStr) {
		int result = 0;

		for (int i = numStr.length() - 1; i >= 0; i--) {
			result += Character.getNumericValue(numStr.charAt(i)) * (int)Math.pow(10, i);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String numStr1 = st.nextToken();
		String numStr2 = st.nextToken();

		int result = Math.max(convert(numStr1), convert(numStr2));

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
