/**
 * 문제 : DNA 비밀번호
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {

	static int S, P, subsetCnt = 0;
	static int[] ascii = { 'A' - 65, 'C' - 65, 'G' - 65, 'T' - 65 };
	static int[] minNum = new int[26];

	private static void slideWindow(String arrS) {

		// 초기 값
		String tmpStr = arrS.substring(0, P);
		int[] cntNum = new int[26];

		// 슬라이딩 윈도우
		for (int i = 0; i < S - P + 1; i++) {

			if (i == 0) {
				for (int j = 0; j < P; j++) {
					cntNum[tmpStr.charAt(j) - 65]++;
				}
			} else {
				cntNum[arrS.charAt(i - 1) - 65]--;
				cntNum[arrS.charAt(i + P - 1) - 65]++;
			}

			// 조건을 확인하는 문자열인지 확인
			if (cntNum[ascii[0]] >= minNum[ascii[0]] && cntNum[ascii[1]] >= minNum[ascii[1]]
					&& cntNum[ascii[2]] >= minNum[ascii[2]] && cntNum[ascii[3]] >= minNum[ascii[3]]) {
				subsetCnt++;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// S: 문자열 길이, P: 부문 문자열 길이
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		// 문자열 입력 받기
		String arrS = br.readLine();

		// 각 문자열의 최소 개수 입력 받기
		// 0: A, 1: C, 2: G, 3: T
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			minNum[ascii[i]] = Integer.parseInt(st.nextToken());
		}

		// 만족하는 부분 문자열 개수 구하기
		slideWindow(arrS);

		// 출력
		System.out.println(subsetCnt);
		br.close();
	}

}
