/**
 * 문제 : 달이 차오른다, 가자.
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {

    static int N, M;
    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][][] visit;

    private static int bfs(int sR, int sC) {
        Queue<int[]> pq = new ArrayDeque<>();

        pq.offer(new int[]{sR, sC, 0, 0}); // r, c, key, cnt

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (board[tmp[0]][tmp[1]] == '1') {
                return tmp[3];
            }
            for (int k = 0; k < 4; k++) {
                int r = tmp[0] + dRow[k];
                int c = tmp[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (board[r][c] == '#') continue;
                if (visit[tmp[2]][r][c]) continue;
                // A,B,C,D,E,F 문 열쇠 여부
                if (board[r][c] >= 'A' && board[r][c] <= 'F') {
                    if ((tmp[2] & 1 << board[r][c] - 'A') == (int) Math.pow(2, board[r][c] - 'A')) {
                        visit[tmp[2]][r][c] = true;
                        pq.offer(new int[]{r, c, tmp[2], tmp[3] + 1});
                    }
                }
                // 열쇠 획득
                else if (board[r][c] >= 'a' && board[r][c] <= 'f') {
                    int next_key = tmp[2] | (1 << board[r][c] - 'a');
                    visit[next_key][r][c] = true;
                    pq.offer(new int[]{r, c, next_key, tmp[3] + 1});
                }
                // 빈 칸일 때
                else {
                    visit[tmp[2]][r][c] = true;
                    pq.offer(new int[]{r, c, tmp[2], tmp[3] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new boolean[64][N][M];

        int r = 0, c = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == '0') {
                    r = i;
                    c = j;
                }
            }
        }

        bw.write(bfs(r, c) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}