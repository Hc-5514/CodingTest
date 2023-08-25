/**
 * 문제 : 가장 큰 정사각형 찾기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 가장_큰_정사각형_찾기 {

    // dp 와 누적합
    public static int solution(int[][] board) {
        // 1. dp
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
        return (int) Math.pow(max, 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }
}
