/**
 * 문제 : [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1240 {

	public static String[] password = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
			"0111011", "0110111", "0001011" };

	public static String str, str2;
	public static int[] codeNum = new int[8];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N, M, idx, correct, sum;

		for (int tc = 1; tc <= T; tc++) {

			// N x M
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			idx = -1;
			for (int i = 0; i < N; i++) {

				str = br.readLine();
				// 암호문 찾기
				if (idx == -1 && str.contains("1")) {
					idx = str.lastIndexOf("1"); // 1의 마지막 위치
					idx -= 55; // 암호문 시작 위치
					str2 = str.substring(idx, idx + 56); // 암호문
				}
			}

			// 암호문 숫자로 변환하기
			for (int i = 0; i < 8; i++) { // 암호 8개

				// 일치하는 암호 찾기
				for (int j = 0; j < 10; j++) {

					if (password[j].equals(str2.substring(0 + i * 7, 7 + i * 7))) {
						codeNum[i] = j;
					}
				}
			}

			// 검증코드 구하기
			correct = 0;
			for (int i = 0; i < 8; i++) {

				if (i % 2 == 0) { // 홀수일 때: x3
					correct += codeNum[i] * 3;
				} else { // 짝수일 때: 그대로
					correct += codeNum[i];
				}
			}

			sum = 0;
			sb.append('#').append(tc).append(' ');
			if (correct % 10 == 0) { // 올바른 암호코드라면
				for (int i = 0; i < 8; i++) {
					sum += codeNum[i];
				}
				sb.append(sum);
			} else { // 틀린 암호코드라면
				sb.append(0);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
