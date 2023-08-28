/**
 * 문제 : 정수 삼각형
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 정수_삼각형 {

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}
