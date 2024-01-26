/**
 * 문제 : Счастье Мистера Бина
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

public class BOJ_29163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());

		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		if (cnt1 > cnt2) {
			bw.write("Happy");
		} else {
			bw.write("Sad");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
