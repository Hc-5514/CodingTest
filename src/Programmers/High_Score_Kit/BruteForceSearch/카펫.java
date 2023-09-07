/**
 * 문제 : 카펫
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BruteForceSearch;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        // (r >= c)
        // brown = (r+c) * 2 - 4;
        // yellow = (c-2) * (r-2)
        int sum = (brown + 4) / 2; // sum: r+c
        for (int c = 1; c <= sum / 2; c++) {
            int r = sum - c;
            if (yellow == (c - 2) * (r - 2)) {
                return new int[]{r, c};
            }
        }
        return new int[]{0, 0};
    }
}
