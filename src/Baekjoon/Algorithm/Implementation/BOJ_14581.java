/**
 * 문제 : 팬들에게 둘러싸인 홍준
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String name = br.readLine();

		String fan = ":fan:";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					bw.write(":" + name + ":");
				} else {
					bw.write(fan);
				}
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
