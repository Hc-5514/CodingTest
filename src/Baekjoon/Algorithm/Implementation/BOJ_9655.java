/**
 * 문제 : 돌 게임
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9655 {

	// 돌을 1개 or 3개 가져가면서 마지막 돌 가져가는 사람이 승리
	// 게임 시작: 상근
	// 상근 승: SK, 창영 승: CY 출력

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		String result = (n % 2 == 1) ? "SK" : "CY";

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
