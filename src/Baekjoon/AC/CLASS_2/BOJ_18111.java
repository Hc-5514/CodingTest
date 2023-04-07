/**
 * 문제 : 마인크래프트
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE, max = 0;
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        int high = 0, minTime = Integer.MAX_VALUE;
        for (int h = min; h <= max; h++) {
            int cnt = B;
            int time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] > h) {
                        cnt += (board[i][j] - h);
                        time += ((board[i][j] - h) * 2);
                    }
                    if (board[i][j] < h) {
                        cnt -= (h - board[i][j]);
                        time += (h - board[i][j]);
                    }
                }
            }

            if (cnt < 0) break;
            if (time <= minTime) {
                minTime = time;
                high = h;
            }
        }

        bw.write(minTime + " " + high + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}