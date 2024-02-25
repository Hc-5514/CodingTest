/**
 * 문제 : 삼각형 외우기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10101 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] angles = new int[3];
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			angles[i] = Integer.parseInt(br.readLine().trim());
			sum += angles[i];
		}

		if (sum != 180) {
			bw.write("Error\n");
		} else {
			if (angles[0] == angles[1] && angles[0] == angles[2]) {
				bw.write("Equilateral\n");
			} else if (angles[0] == angles[1] || angles[1] == angles[2] || angles[0] == angles[2]) {
				bw.write("Isosceles\n");
			} else {
				bw.write("Scalene\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
