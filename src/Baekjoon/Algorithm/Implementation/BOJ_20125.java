/**
 * 문제: 쿠키의 신체 측정
 * 난이도: 실버 4
 * 메모리: 20288KB, 시간: 184ms
 * 풀이: 구현
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20125 {

	private static int n;
	private static char[][] board;

	private static int getLeftArmLength(int r, int c) {
		int len = 0;
		while (c >= 0 && board[r][c--] == '*') {
			len++;
		}
		return len;
	}

	private static int getRightArmLength(int r, int c) {
		int len = 0;
		while (c < n && board[r][c++] == '*') {
			len++;
		}
		return len;
	}

	private static int getOtherLength(int r, int c) {
		int len = 0;
		while (r < n && board[r++][c] == '*') {
			len++;
		}
		return len;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		board = new char[n][n];

		int heartX = 0;
		int heartY = 0;
		boolean findHeart = false;

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = line.charAt(j);
				// 심장 위치 관리
				if (!findHeart && board[i][j] == '*') {
					findHeart = true;
					heartX = i + 1;
					heartY = j;
				}
			}
		}

		// 신체 길이 구하기
		int leftArmLen = getLeftArmLength(heartX, heartY - 1);
		int rightArmLen = getRightArmLength(heartX, heartY + 1);
		int waistLen = getOtherLength(heartX + 1, heartY);
		int leftLegLen = getOtherLength(heartX + waistLen + 1, heartY - 1);
		int rightLegLen = getOtherLength(heartX + waistLen + 1, heartY + 1);

		bw.write((heartX + 1) + " " + (heartY + 1) + "\n");
		bw.write(leftArmLen + " " + rightArmLen + " " + waistLen + " " + leftLegLen + " " + rightLegLen + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
