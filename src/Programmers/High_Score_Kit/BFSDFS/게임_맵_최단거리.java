/**
 * 문제 : 게임 맵 최단거리
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임_맵_최단거리 {

    final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visit = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                answer = cur[2];
                break;
            }
            for (int k = 0; k < 4; k++) {
                int r = cur[0] + dRow[k];
                int c = cur[1] + dCol[k];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (maps[r][c] == 0) continue;
                if (visit[r][c]) continue;
                q.offer(new int[]{r, c, cur[2] + 1});
                visit[r][c] = true;
            }
        }
        return answer;
    }
}
