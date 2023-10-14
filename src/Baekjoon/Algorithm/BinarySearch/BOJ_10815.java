/**
 * 문제 : 숫자 카드
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {

	private static int N;
	private static int[] numCard, numArr;

	private static boolean binarySearch(int findNum) {
		int s = 0;
		int e = N - 1;

		while (s <= e) {
			int m = (s + e) >> 1;
			if (findNum < numCard[m]) {
				e = m - 1;
			} else if (findNum > numCard[m]) {
				s = m + 1;
			} else { // 일치
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 상근이가 가지고 있는 N개의 숫자 카드 입력 받기
		N = Integer.parseInt(br.readLine().trim());
		numCard = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numCard[i] = Integer.parseInt(st.nextToken());
		}

		// 숫자 M개 입력 받기
		int M = Integer.parseInt(br.readLine().trim());
		numArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numCard);

		// 이분 탐색
		for (int i = 0; i < M; i++) {
			int findNum = numArr[i];

			// numCard 목록에 찾으려는 숫자가 있으면 1
			if (binarySearch(findNum)) {
				bw.write(1 + " ");
			} else {
				bw.write(0 + " ");
			}
		}

		bw.write("");
		bw.flush();
		bw.close();
		br.close();
	}
}