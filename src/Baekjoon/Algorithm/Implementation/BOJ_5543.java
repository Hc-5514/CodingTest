/**
 * 문제 : 상근날드
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] bugers = new int[3];
		int[] drinks = new int[2];

		for (int i = 0; i < 3; i++) {
			bugers[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int i = 0; i < 2; i++) {
			drinks[i] = Integer.parseInt(br.readLine().trim());
		}

		int minSetPrice = 4000;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				minSetPrice = Math.min(minSetPrice, bugers[i] + drinks[j]);
			}
		}

		bw.write((minSetPrice - 50) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
