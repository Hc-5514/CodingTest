/**
 * 문제 : 토마토
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

    static int N, M, H, cnt = 0;
    static int[][][] map;
    static boolean[][][] visit;
    static final int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    private static void bfs() {
        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                for (int j = 0; j < 6; j++) {
                    int h = tmp[0] + dx[j];
                    int r = tmp[1] + dy[j];
                    int c = tmp[2] + dz[j];
                    if (h < 0 || r < 0 || c < 0 || h >= H || r >= N || c >= M) continue;
                    if (map[h][r][c] == 0 && !visit[h][r][c]) {
                        q.offer(new int[]{h, r, c});
                        map[h][r][c] = 1;
                        visit[h][r][c] = true;
                    }
                }
            }
            cnt++;
        }
    }

    private static boolean checkMap() {
        // 익지 않은 토마토가 있다면 false
        for (int[][] arr1 : map) {
            for (int[] arr2 : arr1) {
                for (int n : arr2) {
                    if (n == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N x M 필드, H 높이
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visit = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j][k] = num;
                    if (num == 1) {
                        q.offer(new int[]{i, j, k});
                        visit[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

        if (checkMap()) {
            cnt--;
        } else {
            cnt = -1;
        }

        System.out.println(cnt);
        br.close();
    }
}
