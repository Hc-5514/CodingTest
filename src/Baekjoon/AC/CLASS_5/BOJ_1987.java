/**
 * 문제 : 알파벳
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

    static int R, C, maxCnt = 0;
    static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static Coordinate coordinate = new Coordinate();

    static class Coordinate {
        int r;
        int c;

        public Coordinate() {
            r = 0;
            c = 0;
        }

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void dfs(Coordinate coordinate, int cnt) {
        visit[map[coordinate.r][coordinate.c] - 65] = true;
        for (int k = 0; k < 4; k++) { // 아래, 위, 오른쪽, 왼쪽
            int r = coordinate.r + dx[k];
            int c = coordinate.c + dy[k];
            if (r < 0 || c < 0 || r >= R || c >= C) continue;
            int idx = map[r][c] - 65;
            if (!visit[idx]) {
                visit[idx] = true;
                dfs(new Coordinate(r, c), cnt + 1);
                visit[idx] = false;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // R x C 배열
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(coordinate, 1);

        System.out.println(maxCnt);
        br.close();
    }
}
