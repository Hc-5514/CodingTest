/**
 * 문제 : 末尾の文字 (Last Letter)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_27541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		String str = br.readLine();
		String result = str.charAt(n - 1) == 'G' ? str.substring(0, n - 1) : str + "G";

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
