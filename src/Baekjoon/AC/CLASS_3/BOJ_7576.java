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

public class BOJ_7576 {

    static int M, N, cnt = 0;
    static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;
    static Queue<Coordinate> q = new LinkedList<>();

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = coordinate.x + dx[j];
                    int y = coordinate.y + dy[j];
                    if (x < 0 || y < 0 || x >= N || y >= M) continue;
                    if (map[x][y] == 0 && !visit[x][y]) {
                        q.offer(new Coordinate(x, y));
                        map[x][y] = 1;
                        visit[x][y] = true;
                    }
                }
            }
            cnt++;
        }
    }

    private static boolean checkMap() {
        for (int[] arr : map) {
            for (int n : arr) {
                if (n == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Coordinate(i, j));
                    visit[i][j] = true;
                }
            }
        }

        bfs();

        if (!checkMap()) cnt = -1;
        else {
            cnt--;
        }
        System.out.println(cnt);
        br.close();
    }
}
