/**
 * 문제 : 구슬 탈출 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {

    static int N, M, goalR, goalC;
    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    static char[][] board;

    static boolean[][][][] visit;

    static Marble red, blue;

    public static int bfs() {
        Queue<Marble> q = new ArrayDeque<>();
        q.offer(new Marble(red.rr, red.rc, blue.br, blue.bc, 1, -1));
        visit[red.rr][red.rc][blue.br][blue.bc] = true;

        while (!q.isEmpty()) {
            Marble cur = q.poll();
            if (cur.cnt > 10) return -1; // 이동 횟수는 10번 이하만 가능하다.

            for (int k = 0; k < 4; k++) {
                // 1. 이전 이동 방향과 같다면 continue
                if (cur.dir == k) continue;

                // 2. 구슬 이동
                int rr = cur.rr;
                int rc = cur.rc;
                int br = cur.br;
                int bc = cur.bc;
                boolean isRed = false;
                boolean isBlue = false;

                // 장애물 또는 벽을 만나기 전까지 구슬 이동
                while (board[rr + dRow[k]][rc + dCol[k]] != '#') {
                    rr += dRow[k];
                    rc += dCol[k];
                    // 빨간 구슬 탈출 확인
                    if (rr == goalR && rc == goalC) {
                        isRed = true;
                        break;
                    }
                }

                while (board[br + dRow[k]][bc + dCol[k]] != '#') {
                    br += dRow[k];
                    bc += dCol[k];
                    // 파란 구슬 탈출 확인
                    if (br == goalR && bc == goalC) {
                        isBlue = true;
                        break;
                    }
                }

                if (isBlue) continue; // 파란 구슬이 빠지면 실패
                if (isRed) return cur.cnt; // 빨간 구슬이 빠지면 성공

                // 두 구슬이 겹친다면, 이동 전 위치를 비교하여 위치 조정
                if (rr == br && rc == bc) {
                    if (k == 0) { // 상 이동
                        if (cur.rr < cur.br) {
                            br++;
                        } else {
                            rr++;
                        }
                    } else if (k == 1) { // 하 이동
                        if (cur.rr < cur.br) {
                            rr--;
                        } else {
                            br--;
                        }
                    } else if (k == 2) { // 좌 이동
                        if (cur.rc < cur.bc) {
                            bc++;
                        } else {
                            rc++;
                        }
                    } else { // 우 이동
                        if (cur.rc < cur.bc) {
                            rc--;
                        } else {
                            bc--;
                        }
                    }
                }

                if (visit[rr][rc][br][bc]) continue; // 방문 확인
                q.offer(new Marble(rr, rc, br, bc, cur.cnt + 1, k));
                visit[rr][rc][br][bc] = true;
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
        visit = new boolean[N][M][N][M]; // 두 구슬의 위치를 이용하여 방문 여부 확인

        // board 와 구슬 정보 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0, 0);
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0, 0);
                    board[i][j] = '.';
                }
                if (board[i][j] == 'O') {
                    goalR = i;
                    goalC = j;
                }
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Marble {
        int rr;
        int rc;
        int br;
        int bc;
        int cnt;
        int dir;

        public Marble(int rr, int rc, int br, int bc, int cnt, int dir) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
