/**
 * 문제 : 안전 영역
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {

    static int N, height = 0, maxAreaCnt = 1;
    static int[][] map;
    static boolean[][] visit;
    static final int[] dRow = {1, -1, 0, 0}, dCol = {0, 0, 1, -1};

    private static void bfs() {
        // (높이 1 ~ 최고 높이-1) 만큼 잠겼을 때 안전 영역 최대 개수 구하기
        Queue<int[]> q = new ArrayDeque<>();
        for (int h = 1; h < height; h++) {
            int areaCnt = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visit[i][j]) {
                        q.offer(new int[]{i, j});
                        visit[i][j] = true;
                        areaCnt++;
                        while (!q.isEmpty()) {
                            int[] tmp = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int r = tmp[0] + dRow[k];
                                int c = tmp[1] + dCol[k];
                                if (r < 0 || c < 0 || r >= N || c >= N) continue;
                                if (map[r][c] > h && !visit[r][c]) {
                                    q.offer(new int[]{r, c});
                                    visit[r][c] = true;
                                }
                            }
                        }
                    }
                }
            }
            maxAreaCnt = Math.max(maxAreaCnt, areaCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N x N 지도
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        bfs();

        System.out.println(maxAreaCnt);
        br.close();
    }
}
