/**
 * 문제 : 통나무 옮기기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1938 {
    static int N;

    static char[][] board;

    static boolean[][][] visit;

    private static boolean command(char cmd, Wood wood) {

        // 가로
        if (wood.status == 0) {
            switch (cmd) {
                case 'U':
                    if (wood.r - 1 < 0 || wood.c - 1 < 0 || wood.c + 1 >= N) return false;
                    if (visit[wood.status][wood.r - 1][wood.c]) return false;
                    for (int i = -1; i <= 1; i++) {
                        if (board[wood.r - 1][wood.c + i] == '1') return false;
                    }
                    break;
                case 'D':
                    if (wood.r + 1 >= N || wood.c - 1 < 0 || wood.c + 1 >= N) return false;
                    if (visit[wood.status][wood.r + 1][wood.c]) return false;
                    for (int i = -1; i <= 1; i++) {
                        if (board[wood.r + 1][wood.c + i] == '1') return false;
                    }
                    break;
                case 'L':
                    if (wood.c - 2 < 0) return false;
                    if (visit[wood.status][wood.r][wood.c - 1]) return false;
                    if (board[wood.r][wood.c - 2] == '1') return false;
                    break;
                case 'R':
                    if (wood.c + 2 >= N) return false;
                    if (visit[wood.status][wood.r][wood.c + 1]) return false;
                    if (board[wood.r][wood.c + 2] == '1') return false;
                    break;
            }
        }
        // 세로
        else {
            switch (cmd) {
                case 'U':
                    if (wood.r - 2 < 0) return false;
                    if (visit[wood.status][wood.r - 1][wood.c]) return false;
                    if (board[wood.r - 2][wood.c] == '1') return false;
                    break;
                case 'D':
                    if (wood.r + 2 >= N) return false;
                    if (visit[wood.status][wood.r + 1][wood.c]) return false;
                    if (board[wood.r + 2][wood.c] == '1') return false;
                    break;
                case 'L':
                    if (wood.c - 1 < 0 || wood.r - 1 < 0 || wood.r + 1 >= N) return false;
                    if (visit[wood.status][wood.r][wood.c - 1]) return false;
                    for (int i = -1; i <= 1; i++) {
                        if (board[wood.r + i][wood.c - 1] == '1') return false;
                    }
                    break;
                case 'R':
                    if (wood.c + 1 >= N || wood.r - 1 < 0 || wood.r + 1 >= N) return false;
                    if (visit[wood.status][wood.r][wood.c + 1]) return false;
                    for (int i = -1; i <= 1; i++) {
                        if (board[wood.r + i][wood.c + 1] == '1') return false;
                    }
                    break;
            }
        }

        if (cmd == 'T') {
            if (wood.status == 0) {
                if (visit[1][wood.r][wood.c]) return false;
            } else {
                if (visit[0][wood.r][wood.c]) return false;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (wood.r + i < 0 || wood.r + i >= N || wood.c + j < 0 || wood.c + j >= N) return false;
                    if (board[wood.r + i][wood.c + j] == '1') return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().trim());
        board = new char[N][N];
        visit = new boolean[2][N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Queue<Wood> q = new ArrayDeque<>();

        // 시작 통나무 정보
        Wood sWood = new Wood(0, 0, 0, 0);
        f1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'B') {
                    // 가로 형태의 나무
                    if (j != N - 1 && board[i][j + 1] == 'B') {
                        sWood = new Wood(i, j + 1, 0, 0);
                        visit[0][i][j + 1] = true;
                    }
                    // 세로 형태의 나무
                    else {
                        sWood = new Wood(i + 1, j, 1, 0);
                        visit[1][i + 1][j] = true;
                    }
                    break f1;
                }
            }
        }

        // 목표 통나무 정보
        Wood gWood = new Wood(0, 0, 0, 0);
        f1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'E') {
                    // 가로 형태의 나무
                    if (j != N - 1 && board[i][j + 1] == 'E') {
                        gWood = new Wood(i, j + 1, 0, 0);
                    }
                    // 세로 형태의 나무
                    else {
                        gWood = new Wood(i + 1, j, 1, 0);
                    }
                    break f1;
                }
            }
        }


        boolean flag = false;
        int cnt = 0;

        q.offer(sWood);
        while (!q.isEmpty()) {
            Wood cur = q.poll();
//            System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", 실행 전");
            if (cur.r == gWood.r && cur.c == gWood.c && cur.status == gWood.status) {
                cnt = cur.cnt;
                flag = true;
                break;
            }

            if (command('U', cur)) {
//                System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", U 실행");
                q.offer(new Wood(cur.r - 1, cur.c, cur.status, cur.cnt + 1));
                visit[cur.status][cur.r - 1][cur.c] = true;
            }

            if (command('D', cur)) {
//                System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", D 실행");
                q.offer(new Wood(cur.r + 1, cur.c, cur.status, cur.cnt + 1));
                visit[cur.status][cur.r + 1][cur.c] = true;
            }

            if (command('L', cur)) {
//                System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", L 실행");
                q.offer(new Wood(cur.r, cur.c - 1, cur.status, cur.cnt + 1));
                visit[cur.status][cur.r][cur.c - 1] = true;
            }

            if (command('R', cur)) {
//                System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", R 실행");
                q.offer(new Wood(cur.r, cur.c + 1, cur.status, cur.cnt + 1));
                visit[cur.status][cur.r][cur.c + 1] = true;
            }

            if (command('T', cur)) {
                if (cur.status == 0) {
//                    System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", T 실행");
                    q.offer(new Wood(cur.r, cur.c, 1, cur.cnt + 1));
                    visit[1][cur.r][cur.c] = true;
                } else {
//                    System.out.println("[" + cur.r + ", " + cur.c + "] status: " + cur.status + ", T 실행");
                    q.offer(new Wood(cur.r, cur.c, 0, cur.cnt + 1));
                    visit[0][cur.r][cur.c] = true;
                }
            }
        }

        if (flag) {
            bw.write(cnt + "\n");
        } else {
            bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Wood {
        int r;
        int c;
        int status;
        int cnt;

        public Wood(int r, int c, int status, int cnt) {
            this.r = r;
            this.c = c;
            this.status = status;
            this.cnt = cnt;
        }
    }
}