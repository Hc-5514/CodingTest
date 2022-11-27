/**
 * 문제 : 패턴 마디의 길이
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_2007 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String str = br.readLine();
			for (int i = 1; i <= str.length(); i++) {
				if (str.substring(0, i).equals(str.substring(i, i * 2))) {
					System.out.println("#" + test_case + " " + i);
					break;
				}
			}
		}
	}

}
