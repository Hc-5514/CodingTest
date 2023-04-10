/**
 * 문제 : 봄버맨 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16919 {

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<int[]> coords1 = new ArrayList<>();
        ArrayList<int[]> coords2 = new ArrayList<>();

        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'O') {
                    coords1.add(new int[]{i, j});
                }
            }
        }

        // N == 1 일 때, 초기 상태
        if (N != 1) {
            // N % 2 == 0 일 때, 모두 폭탄으로 채워짐
            if (N % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    Arrays.fill(board[i], 'O');
                }
            } else {
                // N % 4 == 3 일 때, 초기 상태 폭탄의 폭발 상태
                for (int i = 0; i < R; i++) {
                    Arrays.fill(board[i], 'O');
                }
                for (int i = 0; i < coords1.size(); i++) {
                    int[] tmp = coords1.get(i);
                    board[tmp[0]][tmp[1]] = '.';
                    for (int k = 0; k < 4; k++) {
                        int r = tmp[0] + dRow[k];
                        int c = tmp[1] + dCol[k];
                        if (r < 0 || c < 0 || r >= R || c >= C) continue;
                        board[r][c] = '.';
                    }
                }
                // N % 4 == 1 일 때, 2초 상태 폭탄의 폭발 상태
                if (N % 4 == 1) {
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (board[i][j] == 'O') coords2.add(new int[]{i, j});
                        }
                    }

                    for (int i = 0; i < R; i++) {
                        Arrays.fill(board[i], 'O');
                    }
                    for (int i = 0; i < coords2.size(); i++) {
                        int[] tmp = coords2.get(i);
                        board[tmp[0]][tmp[1]] = '.';
                        for (int k = 0; k < 4; k++) {
                            int r = tmp[0] + dRow[k];
                            int c = tmp[1] + dCol[k];
                            if (r < 0 || c < 0 || r >= R || c >= C) continue;
                            board[r][c] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}