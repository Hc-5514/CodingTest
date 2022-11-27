/**
 * 문제 : 초심자의 회문 검사
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1989 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String str = br.readLine();

			// 회문 확인
			int count = 0;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) == str.charAt(str.length() - 1 - i))
					count++;
			}

			if (count == str.length() / 2)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);
		}
	}

}
