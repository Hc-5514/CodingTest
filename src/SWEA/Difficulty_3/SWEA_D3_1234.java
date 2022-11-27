/**
 * 문제 : [S/W 문제해결 기본] 10일차 - 비밀번호
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D3_1234 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		ArrayList<Integer> al = new ArrayList<>();
		int n;
		String str;

		for (int tc = 1; tc <= 10; tc++) {

			al.clear();

			// 길이 n의 암호
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			str = st.nextToken();

			for (int i = 0; i < n; i++)
				al.add(Character.getNumericValue(str.charAt(i)));

			// 연속적인 값이 있다면 true
			boolean bl = true;

			loop: while (bl) {

				for (int i = 0; i < al.size() - 1; i++) {
					// 다음 숫자와 같다면
					if (al.get(i).equals(al.get(i + 1))) {
						al.remove(i);
						al.remove(i);
						continue loop;
					}
				}

				bl = false;
			}

			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < al.size(); i++)
				sb.append(al.get(i));
			sb.append('\n');
		}

		System.out.println(sb);
	}

}
