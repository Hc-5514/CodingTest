/**
 * 문제 : [S/W 문제해결 기본] 3일차 - String
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D3_1213 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String search;
		String str;

		for (int tc = 1; tc <= 10; tc++) {

			int T = Integer.parseInt(br.readLine());
			search = br.readLine();
			str = br.readLine();

			int count = 0;
			for (int i = 0; i < str.length() - search.length() + 1; i++) {

				if (search.equals(str.substring(i, i + search.length())))
					count++;
			}

			System.out.println("#" + tc + " " + count);
		}

	}

}
