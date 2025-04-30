/**
 * 문제: A + B - C
 * 난이도: 브론즈 4
 * 메모리: 11556KB, 시간: 68ms
 * 풀이: 구현
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_31403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String strA = br.readLine();
		String strB = br.readLine();
		String strC = br.readLine();

		int resultNum = Integer.parseInt(strA) + Integer.parseInt(strB) - Integer.parseInt(strC);
		int resultStr = Integer.parseInt(strA + strB) - Integer.parseInt(strC);

		bw.write(resultNum + "\n");
		bw.write(resultStr + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
