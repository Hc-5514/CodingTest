/**
 * 문제 : 치즈
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {

    static int N, M, time = 0;
    static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visit;
    static ArrayList<Cheeze> list = new ArrayList<>();

    static class Cheeze {

        int r;
        int c;
        int cnt; // 외부와 접촉하는 변의 수

        public Cheeze(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }
    }

    private static void bfs() {
        // 공기와 접촉된 치즈의 변 개수 체크
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int r = cur[0] + dRow[k];
                int c = cur[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (visit[r][c]) continue;
                if (board[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visit[r][c] = true;
                } else {
                    // 치즈의 변 개수++
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).r == r && list.get(i).c == c) {
                            list.get(i).cnt++;
                        }
                    }
                }
            }
        }
    }

    private static void removeCheeze() {
        // 공기와 접촉된 변이 2개 이상인 치즈 제거
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).cnt >= 2) {
                board[list.get(i).r][list.get(i).c] = 0;
                list.remove(i);
            }
        }
    }

    private static void setCntCheeze() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    list.add(new Cheeze(i, j));
            }
        }

        while (!list.isEmpty()) {
            visit = new boolean[N][M];
            bfs();
            removeCheeze();
            setCntCheeze();
            time++;
        }

        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}