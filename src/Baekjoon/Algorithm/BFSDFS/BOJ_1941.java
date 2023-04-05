/**
 * 문제 : 소문난 칠공주
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1941 {
    static int cnt = 0;

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    static int[] selectedNum = new int[7];

    static char[][] board = new char[5][5];

    private static void combination(int depth, int start, int select) {
        if (select >= 4) {
            return;
        }

        if (depth == 7) {
            if (bfs() == 7) cnt++;
            return;
        }

        for (int i = start; i < 25; i++) {
            selectedNum[depth] = i;
            if (board[i / 5][i % 5] == 'S') {
                combination(depth + 1, i + 1, select);
            } else {
                combination(depth + 1, i + 1, select + 1);
            }
        }
    }

    private static int bfs() {
        int sum = 0;
        boolean[] visit2 = new boolean[7];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(selectedNum[0]);
        visit2[0] = true;
        sum++;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            int tR = tmp / 5;
            int tC = tmp % 5;
            for (int i = 0; i < 7; i++) {
                int r = selectedNum[i] / 5;
                int c = selectedNum[i] % 5;
                if (visit2[i]) continue;
                for (int k = 0; k < 4; k++) {
                    if (tR + dRow[k] == r && tC + dCol[k] == c) {
                        q.offer(selectedNum[i]);
                        visit2[i] = true;
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        combination(0, 0, 0);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}