/**
 * 문제 : Робинзон Крузо
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_27219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int a = n / 5;
		int b = n % 5;

		for (int i = 0; i < a; i++) {
			bw.write("V");
		}

		for (int i = 0; i < b; i++) {
			bw.write("I");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
