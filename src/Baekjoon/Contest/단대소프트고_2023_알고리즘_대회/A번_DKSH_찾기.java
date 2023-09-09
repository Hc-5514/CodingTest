/**
 * 문제 : A번 - DKSH 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.Contest.단대소프트고_2023_알고리즘_대회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A번_DKSH_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String ori = br.readLine();
		String find = "DKSH";
		int cnt = 0;
		for (int i = 0; i <= ori.length() - find.length(); i++) {
			if (ori.substring(i, i + 4).equals(find)) {
				cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
