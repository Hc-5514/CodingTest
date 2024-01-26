/**
 * 문제 : 코드마스터 2023
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_28235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		if ("SONGDO".equals(str)) {
			bw.write("HIGHSCHOOL\n");
		} else if ("CODE".equals(str)) {
			bw.write("MASTER\n");
		} else if ("2023".equals(str)) {
			bw.write("0611\n");
		} else {
			bw.write("CONTEST\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
