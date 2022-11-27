/**
 * 문제 : [S/W 문제해결 기본] 5일차 - GNS
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1221 {

	public static String[] strArray = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {

			// test_case: #테스트케이스 번호, N: 테스트케이스 길이
			st = new StringTokenizer(br.readLine());
			String test_case = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[10];

			// 문자열 입력 받기
			st = new StringTokenizer(br.readLine());

			// 해당 문자열 개수 세리기
			for (int i = 0; i < N; i++) {

				String str = st.nextToken();
				for (int j = 0; j < 10; j++) {

					if (str.equals(strArray[j])) {
						arr[j]++;
						break;
					}
				}
			}

			// 문자열 개수 만큼 저장
			sb.setLength(0);
			sb.append(test_case).append('\n');
			for (int i = 0; i < 10; i++) {

				for (int j = 0; j < arr[i]; j++) {
					sb.append(strArray[i]).append(' ');
				}
			}

			System.out.println(sb);
		}

	}

}
