/**
 * 문제 : 적록색약
 *
 * @author Hc-5514
 */
// 3시 13분 시작
package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

    static int N, cnt1 = 0, cnt2 = 0;
    static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visit1, visit2;

    private static void bfs1() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit1[i][j]) {
                    q.offer(new int[]{i, j});
                    visit1[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = tmp[0] + dx[k];
                            int y = tmp[1] + dy[k];
                            if (x < 0 || y < 0 || x >= N || y >= N) continue;
                            if (map[x][y] == map[tmp[0]][tmp[1]] && !visit1[x][y]) {
                                visit1[x][y] = true;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    cnt1++;
                }
            }
        }
    }

    private static void bfs2() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit2[i][j]) {
                    q.offer(new int[]{i, j});
                    visit2[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = tmp[0] + dx[k];
                            int y = tmp[1] + dy[k];
                            if (x < 0 || y < 0 || x >= N || y >= N) continue;
                            // 현재 그림이 R, G일 때
                            if (map[tmp[0]][tmp[1]] == 'R' || map[tmp[0]][tmp[1]] == 'G') {
                                // 다음 그림이 R 또는 G라면
                                if (map[x][y] == 'R' || map[x][y] == 'G') {
                                    if (!visit2[x][y]) {
                                        visit2[x][y] = true;
                                        q.offer(new int[]{x, y});
                                    }
                                }
                            }
                            // 현재 그림이 B일 때
                            else {
                                if (map[x][y] == 'B' && !visit2[x][y]) {
                                    visit2[x][y] = true;
                                    q.offer(new int[]{x, y});
                                }
                            }
                        }
                    }
                    cnt2++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        bfs1();
        bfs2();

        System.out.println(cnt1 + " " + cnt2);
        br.close();
    }
}
