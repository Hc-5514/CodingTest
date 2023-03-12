/**
 * 문제 : 낚시왕
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17143 {

    static int R, C;
    static int[][] board;
    static ArrayList<Shark> sharkList = new ArrayList<>();

    static class Shark {
        int r;
        int c;
        int s; // 속력
        int d; // 방향 (0: 상, 1: 하, 2: 우, 3: 좌)
        int z; // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    private static void setBoard() {
        // 배열 초기화
        for (int i = 0; i < R; i++) {
            Arrays.fill(board[i], 0);
        }
        // 배열 세팅
        for (int i = sharkList.size() - 1; i >= 0; i--) {
            int r = sharkList.get(i).r;
            int c = sharkList.get(i).c;
            int z = sharkList.get(i).z;
            if (board[r][c] == 0) {
                board[r][c] = z;
            } else { // 이미 상어가 있다면, 큰 상어가 잡아 먹는다.
                // 기존 상어 정보 가져오기
                int idx = -1;
                for (int j = 0; j < sharkList.size(); j++) {
                    if (board[r][c] == sharkList.get(j).z) {
                        idx = j;
                        break;
                    }
                }
                if (board[r][c] < z) { // 새로운 상어가 더 크다면
                    sharkList.remove(idx);
                    board[r][c] = z;
                } else { // 기존 상어가 더 크다면
                    sharkList.remove(i);
                }
            }
        }
    }

    private static void moveShark(int idx) {
        int r = sharkList.get(idx).r;
        int c = sharkList.get(idx).c;
        int s = sharkList.get(idx).s;
        int d = sharkList.get(idx).d;

        // 1. 상어 좌표 변경 - 미구현
        while (s > 0) {
            if (d == 0) {
                if (s >= r) {
                    d = 1;
                    s -= r;
                    r -= r;
                } else {
                    r -= s;
                    s = 0;
                }
            } else if (d == 1) {
                if (s >= R - 1 - r) {
                    d = 0;
                    s -= (R - 1 - r);
                    r += (R - 1 - r);
                } else {
                    r += s;
                    s = 0;
                }
            } else if (d == 2) {
                if (s >= C - 1 - c) {
                    d = 3;
                    s -= (C - 1 - c);
                    c += (C - 1 - c);
                } else {
                    c += s;
                    s = 0;
                }
            } else {
                if (s >= c) {
                    d = 2;
                    s -= c;
                    c -= c;
                } else {
                    c -= s;
                    s = 0;
                }
            }
        }

        // 2. 리스트 정보 수정
        sharkList.get(idx).r = r;
        sharkList.get(idx).c = c;
        sharkList.get(idx).d = d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 상어 마릿 수
        board = new int[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 상어가 한 바퀴 돌아서 제자리 오기까지 2(C,R -1)
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (d == 1 || d == 2) { // 상하 이동
                s = s % (2 * (R - 1));
            } else { // 좌우 이동
                s = s % (2 * (C - 1));
            }
            int z = Integer.parseInt(st.nextToken());
            sharkList.add(new Shark(r - 1, c - 1, s, d - 1, z));
        }

        // 낚시왕의 이동이 끝날 때까지
        int idx = 0, totalCnt = 0;
        while (idx < C) {
            setBoard();
            // 1. 해당 열(idx)의 0행에 가장 가까운 상어 잡는다.
            f1:
            for (int i = 0; i < R; i++) {
                if (board[i][idx] != 0) {
                    // 1) totalCnt 증가
                    totalCnt += board[i][idx];
                    // 2) 상어 제거
                    for (int j = 0; j < sharkList.size(); j++) {
                        if (board[i][idx] == sharkList.get(j).z) {
                            sharkList.remove(j);
                            break f1;
                        }
                    }
                    // 3) board 0으로 변경
                    board[i][idx] = 0;
                }
            }
            // 2. 상어 이동 - list 값만 변경해주면 됨
            for (int i = 0; i < sharkList.size(); i++) {
                moveShark(i);
            }
            idx++;
        }

        bw.write(totalCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}