/**
 * 문제 : [모의 SW 역량테스트] 벌꿀채취
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_Mock_2115 {

    static int N, M, C, maxValue, value1, value2;

    static int[][] board;

    static boolean[] subSetSelect;
    static int[][] selectNum = new int[2][2]; // 조합
    static boolean[][] select; // 조합

    private static void combination(int cnt, int startI) {
        // 1. 두 일꾼이 서로 안 겹치게 채취하는 영역 구하기: 조합 (좀 이상함)
        if (cnt == 2) {
            getHoney();
            return;
        }

        for (int i = startI; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                if (select[i][j] || select[i][j + M - 1]) continue;
                selectNum[cnt][0] = i;
                selectNum[cnt][1] = j;
                for (int k = 0; k < M; k++) {
                    select[i][j + k] = true;
                }
                combination(cnt + 1, i);
                for (int k = 0; k < M; k++) {
                    select[i][j + k] = false;
                }
            }
        }
    }

    private static void getHoney() {
        // 2. 해당 영역 내에서 최대값 구하기
        subSetSelect = new boolean[M];
        value1 = value2 = 0;
        for (int i = 1; i <= M; i++) {
            // 1. 가능한 부분집합 구하기
            subSet(0, i, 0, 0, 0);
            subSet(0, i, 0, 0, 1);
        }

        // 3. 전체 값 계산 후 최댓값 갱신
        if (value1 + value2 > maxValue) maxValue = value1 + value2;
    }

    private static void subSet(int cnt, int goal, int start, int total, int cmd) {
        if (cnt == goal) {
            int value = 0;
            for (int i = 0; i < subSetSelect.length; i++) {
                if (subSetSelect[i]) {
                    int r = selectNum[cmd][0];
                    int c = selectNum[cmd][1] + i;
                    value += board[r][c] * board[r][c];
                }
            }
            if (cmd == 0) {
                if (value > value1) value1 = value;
            } else {
                if (value > value2) value2 = value;
            }
        }

        for (int i = start; i < M; i++) {
            if (subSetSelect[i]) continue;
            int r = selectNum[cmd][0];
            int c = selectNum[cmd][1] + i;
            if (total + board[r][c] > C) continue;
            subSetSelect[i] = true;
            subSet(cnt + 1, goal, i + 1, total + board[r][c], cmd);
            subSetSelect[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            select = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxValue = 0;
            combination(0, 0);

            sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
