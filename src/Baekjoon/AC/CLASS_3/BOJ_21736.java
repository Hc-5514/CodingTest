/**
 * 문제 : 헌내기는 친구가 필요해
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736 {

    static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        char[][] board = new char[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'I') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cR = cur[0];
            int cC = cur[1];
            if (board[cR][cC] == 'P') {
                cnt++;
            }
            for (int k = 0; k < 4; k++) {
                int r = cR + dRow[k];
                int c = cC + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (board[r][c] == 'X') continue;
                if (visit[r][c]) continue;
                q.offer(new int[]{r, c});
                visit[r][c] = true;
            }
        }

        if (cnt == 0) {
            bw.write("TT" + "\n");
        } else {
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}