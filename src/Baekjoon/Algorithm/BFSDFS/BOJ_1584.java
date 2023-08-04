/**
 * 문제 : 게임
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1584 {

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;

    public static void fillBoard(int x1, int x2, int y1, int y2, int n) {
        if (x1 <= x2) {
            for (int j = x1; j <= x2; j++) {
                if (y1 <= y2) {
                    for (int k = y1; k <= y2; k++) {
                        board[j][k] = n;
                    }
                } else {
                    for (int k = y2; k <= y1; k++) {
                        board[j][k] = n;
                    }
                }
            }
        } else {
            for (int j = x2; j <= x1; j++) {
                if (y1 <= y2) {
                    for (int k = y1; k <= y2; k++) {
                        board[j][k] = n;
                    }
                } else {
                    for (int k = y2; k <= y1; k++) {
                        board[j][k] = n;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        board = new int[501][501];

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken().trim());
            int y1 = Integer.parseInt(st.nextToken().trim());
            int x2 = Integer.parseInt(st.nextToken().trim());
            int y2 = Integer.parseInt(st.nextToken().trim());
            fillBoard(x1, x2, y1, y2, 1);
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken().trim());
            int y1 = Integer.parseInt(st.nextToken().trim());
            int x2 = Integer.parseInt(st.nextToken().trim());
            int y2 = Integer.parseInt(st.nextToken().trim());
            fillBoard(x1, x2, y1, y2, 2);
        }

        int[][] visit = new int[501][501];

        for (int i = 0; i < 501; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = 0;

        int life = Integer.MAX_VALUE;

        if (board[500][500] == 2) {
            life = -1;
        } else {
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == 500 && cur[1] == 500) {
                    life = visit[500][500];
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int r = cur[0] + dRow[k];
                    int c = cur[1] + dCol[k];
                    if (r < 0 || c < 0 || r >= 501 || c >= 501) continue;
                    if (board[r][c] == 2) continue;
                    if (board[r][c] == 0) {
                        if (visit[cur[0]][cur[1]] < visit[r][c]) {
                            q.offer(new int[]{r, c});
                            visit[r][c] = visit[cur[0]][cur[1]];
                        }
                    } else {
                        if (visit[cur[0]][cur[1]] + 1 < visit[r][c]) {
                            q.offer(new int[]{r, c});
                            visit[r][c] = visit[cur[0]][cur[1]] + 1;
                        }
                    }
                }
            }
        }

        if (life == Integer.MAX_VALUE) {
            life = -1;
        }

//        for (int i = 0; i < 501; i++) {
//            for (int j = 0; j < 501; j++) {
//                System.out.print(visit[i][j] + " ");
//            }
//            System.out.println();
//        }

        bw.write(life + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}