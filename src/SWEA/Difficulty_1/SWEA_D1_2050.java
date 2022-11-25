/**
 * 문제 : 알파벳을 숫자로 변환
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D1_2050 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) - 64 + " ");
		}
	}

}
