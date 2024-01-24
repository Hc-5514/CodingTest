/**
 * 문제 : 킹, 퀸, 룩, 비숍, 나이트, 폰
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[] arr = {1, 1, 2, 2, 2, 8};

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			bw.write(arr[i] - Integer.parseInt(st.nextToken()) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
