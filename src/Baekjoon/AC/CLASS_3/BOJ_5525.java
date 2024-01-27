/**
 * 문제 : IOIOI
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim()); // (1 ≤ N ≤ 1,000,000)
		int M = Integer.parseInt(br.readLine().trim()); // (2N+1 ≤ M ≤ 1,000,000)
		String S = br.readLine();

		int answer = 0;
		int idx = 0;
		while (idx < S.length()) {
			if (S.charAt(idx) == 'O') {
				idx++;
				continue;
			}
			// 현재 문자가 'I'일 때, 뒤의 문자 탐색
			int flag = 1; // 1: 'O', -1: 'I' 이 와야 됨.
			int cnt = 0;
			idx++;
			while (idx < S.length()) {
				if (flag == 1) {
					if (S.charAt(idx) == 'I') {
						break;
					}
					cnt++;
				} else {
					if (S.charAt(idx) == 'O') {
						break;
					}
					cnt++;
					if (cnt / 2 >= N) {
						answer++;
					}
				}
				idx++;
				flag *= -1;
			}
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
