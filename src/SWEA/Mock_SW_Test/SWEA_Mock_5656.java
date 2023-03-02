/**
 * 문제 : [모의 SW 역량테스트] 벽돌 깨기
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Mock_5656 {

    static int N, W, H, minCnt;
    static int[][] board, copyBoard;
    static final int[] dRow = {1, -1, 0, 0}, dCol = {0, 0, 1, -1};
    static int[] topIdx, selectNum;

    private static void combination(int cnt) {
        if (cnt == N) {
            // 배열 복사
            copyBoard = new int[H][W];
            for (int i = 0; i < H; i++) {
                copyBoard[i] = Arrays.copyOf(board[i], W);
            }
            dfs();
            return;
        }

        // 중복 순열
        for (int i = 0; i < W; i++) {
            selectNum[cnt] = i;
            combination(cnt + 1);
        }
    }

    private static void dfs() {
        for (int i = 0; i < N; i++) {
            int topIdx = getTopIdx(selectNum[i]);
            breakWall(topIdx, selectNum[i]);
            renewalBoard();
        }
        getBoardMinCnt();
    }

    private static int getTopIdx(int c) {
        int idx = 0;
        while (copyBoard[idx][c] == 0) {
            idx++;
            if (idx == H) break;
        }
        return idx;
    }

    private static void breakWall(int r, int c) {
        // r,c가 배열 범위 밖이면 return
        if (r == H) return;
        int size = copyBoard[r][c];
        // 1. 해당 벽돌 0으로 변경
        copyBoard[r][c] = 0;
        // 2. 해당 벽돌의 숫자 -1 만큼 상하좌우 범위의 추가 실행
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < size; j++) {
                int tmpR = r + dRow[i] * j;
                int tmpC = c + dCol[i] * j;
                if (tmpR < 0 || tmpC < 0 || tmpR >= H || tmpC >= W) continue;
                if(copyBoard[tmpR][tmpC] == 0) continue;
                breakWall(tmpR, tmpC);
            }
        }
    }

    private static void renewalBoard() {
        // 빈 공간이 있을 경우 벽돌 아래로 내리기
        Queue<Integer> q;
        for (int i = 0; i < W; i++) {
            q = new ArrayDeque<>();
            for (int j = H - 1; j >= 0; j--) {
                if (copyBoard[j][i] != 0) {
                    q.add(copyBoard[j][i]);
                    copyBoard[j][i] = 0;
                }
            }
            int x = H - 1;
            while (!q.isEmpty()) {
                copyBoard[x--][i] = q.poll();
            }
        }
    }

    private static void getBoardMinCnt() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copyBoard[i][j] != 0) cnt++;
            }
        }
        if (cnt < minCnt) minCnt = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            // 벽돌 정보 입력
            board = new int[H][W];
            topIdx = new int[W];
            selectNum = new int[N];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minCnt = Integer.MAX_VALUE;
            combination(0);
            sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
