/**
 * 문제 : [S/W 문제해결 기본] 3일차 - 회문1
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D3_1215 {

	public static boolean isPalindrome(StringBuilder sb) {

		String str1 = sb.toString();
		String str2 = sb.reverse().toString();
		sb.reverse();

		return str1.equals(str2);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[][] arr;
		String str;

		for (int tc = 1; tc <= 10; tc++) {

			// N: 회문의 길이
			int N = Integer.parseInt(br.readLine());

			// 8 x 8 글자판 입력 받기
			arr = new char[8][8];

			for (int i = 0; i < 8; i++) {
				str = br.readLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int count = 0;

			// 회문 찾기 - 가로 탐색
			for (int i = 0; i < 8; i++) {

				sb.setLength(0);
				for (int j = 0; j < 8; j++) {
					sb.append(arr[i][j]);
					// 저장된 문자열의 길이가 N보다 크면, 맨 앞 문자열 삭제
					if (sb.length() > N)
						sb.deleteCharAt(0);
					// 기존 문자열과 뒤집은 문자열 비교
					if (isPalindrome(sb) && sb.length() == N) {
						count++;
					}
				}
			}

			// 회문 찾기 - 세로 탐색
			for (int i = 0; i < 8; i++) {

				sb.setLength(0);
				for (int j = 0; j < 8; j++) {
					sb.append(arr[j][i]);
					// 저장된 문자열의 길이가 N보다 크면, 맨 앞 문자열 삭제
					if (sb.length() > N)
						sb.deleteCharAt(0);
					// 기존 문자열과 뒤집은 문자열 비교
					if (isPalindrome(sb) && sb.length() == N) {
						count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}

}
