/**
 * 문제: 파티가 끝나고 난 뒤
 * 난이도: 브론즈 4
 * 메모리: 11588KB, 시간: 64ms
 * 풀이: 구현
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int result = l * p;

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			bw.write((Integer.parseInt(st.nextToken()) - result) + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
