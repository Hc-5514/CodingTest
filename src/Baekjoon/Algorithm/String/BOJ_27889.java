/**
 * 문제 : 특별한 학교 이름
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_27889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		if ("NLCS".equals(str)) {
			bw.write("North London Collegiate School\n");
		} else if ("BHA".equals(str)) {
			bw.write("Branksome Hall Asia\n");
		} else if ("KIS".equals(str)) {
			bw.write("Korea International School\n");
		} else {
			bw.write("St. Johnsbury Academy\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
