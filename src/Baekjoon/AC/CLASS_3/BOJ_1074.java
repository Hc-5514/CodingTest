/**
 * 문제: Z
 * 난이도: 골드 5
 * 메모리: 11628KB, 시간: 60ms
 * 풀이: 분할 정복
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1074 {

	private static int r, c;

	private static int getOrder(int sR, int sC, int order, int len) {
		if (r == sR && c == sC) {
			return order;
		}

		int nxtlen = len / 2;
		int hR = sR + nxtlen; // 행 절반 시작 위치
		int hC = sC + nxtlen; // 열 절반 시작 위치

		int result = -1;
		int area = (nxtlen) * (nxtlen);

		if (r < hR && c < hC) {
			result = getOrder(sR, sC, order, nxtlen);
		} else if (r < hR && c >= hC) {
			result = getOrder(sR, hC, order + area, nxtlen);
		} else if (r >= hR && c < hC) {
			result = getOrder(hR, sC, order + area * 2, nxtlen);
		} else {
			result = getOrder(hR, hC, order + area * 3, nxtlen);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열 4등분 횟수, 1 <= N <= 15
		r = Integer.parseInt(st.nextToken()); // 행, 0 <= r <= 2^15
		c = Integer.parseInt(st.nextToken()); // 열, 0 <= c <= 2^15

		int len = (int)Math.pow(2, N);
		int result = getOrder(0, 0, 0, len);

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
