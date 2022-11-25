/**
 * 문제 : 신문 헤드라인
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D1_2047 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				sb.append(Character.toUpperCase(str.charAt(i)));
			} else
				sb.append(str.charAt(i));
		}

		System.out.println(sb);
	}

}
