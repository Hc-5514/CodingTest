/**
 * 문제 : 원재의 메모리 복구하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_1289 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String memory = br.readLine();
			char last = '0';
			int cnt = 0;
			for (int i = 0; i < memory.length(); i++) {
				if (memory.charAt(i) != last) {
					cnt++;
					last = memory.charAt(i);
				}
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

}
