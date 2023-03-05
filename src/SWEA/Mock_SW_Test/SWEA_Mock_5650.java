/**
 * 문제 : [모의 SW 역량테스트] 핀볼 게임
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_Mock_5650 {

    static int N, maxScore;

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;

    static ArrayList<int[]>[] holeList; // 웜홀 저장, 5개, 쌍으로 r,c좌표

    private static void startGame(int startR, int startC, int startD) {
        int score = 0;
        int d = startD; // 현재 진행 방향
        int r = startR, c = startC;
        // 게임 종료 조건: (r,c)로 돌아오거나 board[r][c] == -1
        while (true) {
            // 이동
            r += dRow[d];
            c += dCol[d];

            // 1. 벽에 부딪힐 때: +1점, 방향 반대로 전환
            if (r < 0 || c < 0 || r >= N || c >= N) {
                // 점수 증가
                score++;
                // 방향 전환
                if (d == 0) d = 1;
                else if (d == 1) d = 0;
                else if (d == 2) d = 3;
                else d = 2;
                continue;
            }

            // 출발 지점으로 돌아오면 종료
            if (board[r][c] == -1 || startR == r && startC == c) break;

            // 2. 블록에 부딪힐 때: +1점, 블록 면 따라 다름
            if (board[r][c] >= 1 & board[r][c] <= 5) {
                // 점수 증가
                score++;
                // 방향 전환
                switch (board[r][c]) {
                    case 1:
                        if (d == 0) {
                            d = 1;
                        } else if (d == 3) {
                            d = 2;
                        } else if (d == 1) {
                            d = 3;
                        } else {
                            d = 0;
                        }
                        break;
                    case 2:
                        if (d == 1) {
                            d = 0;
                        } else if (d == 3) {
                            d = 2;
                        } else if (d == 0) {
                            d = 3;
                        } else {
                            d = 1;
                        }
                        break;
                    case 3:
                        if (d == 1) {
                            d = 0;
                        } else if (d == 2) {
                            d = 3;
                        } else if (d == 0) {
                            d = 2;
                        } else {
                            d = 1;
                        }
                        break;
                    case 4:
                        if (d == 0) {
                            d = 1;
                        } else if (d == 2) {
                            d = 3;
                        } else if (d == 1) {
                            d = 2;
                        } else {
                            d = 0;
                        }
                        break;
                    case 5:
                        if (d == 0) d = 1;
                        else if (d == 1) d = 0;
                        else if (d == 2) d = 3;
                        else d = 2;
                        break;
                }
                continue;
            }
            // 3. 웜홀로 이동했을 때: 웜홀(6~10): 반대 웜홀로 이동, 진행방향 유지
            if (board[r][c] >= 6 && board[r][c] <= 10) {
                // 반대 웜홀 좌표 구하기
                // 웜홀 첫 번째 좌표가 현재 좌표와 같다면 두 번째 좌표 가져옴
                int tmpR, tmpC;
                if (holeList[board[r][c] - 6].get(0)[0] == r && holeList[board[r][c] - 6].get(0)[1] == c) {
                    tmpR = holeList[board[r][c] - 6].get(1)[0];
                    tmpC = holeList[board[r][c] - 6].get(1)[1];
                } else {
                    tmpR = holeList[board[r][c] - 6].get(0)[0];
                    tmpC = holeList[board[r][c] - 6].get(0)[1];
                }
                r = tmpR;
                c = tmpC;
            }
        }
        // 최대 점수 갱신
        if (score > maxScore) maxScore = score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            holeList = new ArrayList[5];
            for (int i = 0; i < 5; i++) {
                holeList[i] = new ArrayList<>();
            }

            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    // 웜홀일 경우, 웜홀 좌표 저장
                    if (board[i][j] >= 6 && board[i][j] <= 10) {
                        holeList[board[i][j] - 6].add(new int[]{i, j});
                    }
                }
            }

            maxScore = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        for (int k = 0; k < 4; k++) {
                            startGame(i, j, k);
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
