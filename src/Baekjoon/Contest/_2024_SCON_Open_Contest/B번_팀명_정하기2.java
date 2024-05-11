/**
 * 문제 : B번 - 팀명 정하기 2
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2024_SCON_Open_Contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B번_팀명_정하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if (name.length() > 10) {
				continue;
			}

			int lCnt = 0;
			int uCnt = 0;
			int hCnt = 0;
			for (int j = 0; j < name.length(); j++) {
				if (Character.isLowerCase(name.charAt(j))) {
					lCnt++;
				}
				if (Character.isUpperCase(name.charAt(j))) {
					uCnt++;
				}
				if (name.charAt(j) == 45) {
					hCnt++;
				}
			}

			if (lCnt + uCnt + hCnt <= 0) {
				continue;
			}

			if (lCnt < uCnt) {
				continue;
			}

			bw.write(name + "\n");
			break;
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
