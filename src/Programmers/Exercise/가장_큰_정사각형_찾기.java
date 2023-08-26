/**
 * 문제 : 가장 큰 정사각형 찾기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 가장_큰_정사각형_찾기 {

	// dp 풀이
	public static int solution1(int[][] board) {
		// 위, 왼쪽, 왼쪽위 3방향 탐색 후 최솟값 +1 저장
		int rowLen = board.length;
		int colLen = board[0].length;
		int[][] dp = new int[rowLen][colLen];
		int max = 0;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				// 0 으로 채워져 있다면, 정사각형이 될 수 없다.
				if (board[i][j] == 0) {
					dp[i][j] = 0;
					continue;
				}
				// 상, 좌, 상좌 탐색 후 최솟값 +1 저장
				int min = 0;
				// 배열 범위 확인
				if (i != 0 && j != 0) {
					min = Math.min(dp[i - 1][j], dp[i][j - 1]);
					min = Math.min(min, dp[i - 1][j - 1]);
				}
				dp[i][j] = min + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		return (int)Math.pow(max, 2);
	}

	// 누적합 풀이
	public int solution2(int[][] board) {
		int rowLen = board.length;
		int colLen = board[0].length;
		int minLen = Math.min(rowLen, colLen);
		int[][] prefixSum = new int[rowLen + 1][colLen + 1];

		// 누적 합 구하기
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				prefixSum[i + 1][j + 1] = board[i][j]
					+ prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
			}
		}

		// 가장 큰 정사각형 찾기
		int maxArea = 0;
		for (int i = 1; i < rowLen + 1; i++) {
			for (int j = 1; j < colLen + 1; j++) {
				int size = (int)Math.sqrt(maxArea);
				while (i + size < rowLen + 1 && j + size < colLen + 1) {
					int area = prefixSum[i + size][j + size] - prefixSum[i - 1][j + size]
						- prefixSum[i + size][j - 1] + prefixSum[i - 1][j - 1];
					if (area == (size + 1) * (size + 1)) {
						maxArea = area;
					}

					size++;
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(solution1(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
		System.out.println(solution1(new int[][] {{0, 0, 1, 1}, {1, 1, 1, 1}}));
	}
}
