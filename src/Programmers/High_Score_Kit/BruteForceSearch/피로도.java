/**
 * 문제 : 피로도
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BruteForceSearch;

public class 피로도 {

    int n, max;
    boolean[] visit;

    public void func(int depth, int life, int[][] dungeons) {
        max = Math.max(max, depth);
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            if (life < dungeons[i][0]) continue;
            visit[i] = true;
            func(depth + 1, life - dungeons[i][1], dungeons);
            visit[i] = false;
        }
    }

    public int solution(int k, int[][] dungeons) {
        // 피로도 >= 0
        // 최소 피로도, 소모 피로도

        // 시작 피로도: 1 <= k <= 5000
        // 던전 개수: 1 <= n <= 8 : 8!

        n = dungeons.length;
        visit = new boolean[n];
        func(0, k, dungeons);

        return max;
    }
}
