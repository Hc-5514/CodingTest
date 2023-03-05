/**
 * 문제 : [모의 SW 역량테스트] 등산로 조성
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_Mock_1949 {

    static int N, K, top, maxLen;

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visit;

    static ArrayList<int[]> topList = new ArrayList<>();

    private static void dfs(int startR, int startC, int h, int len, boolean flag) {
        for (int k = 0; k < 4; k++) {
            int r = startR + dRow[k];
            int c = startC + dCol[k];
            if (r < 0 || c < 0 || r >= N || c >= N) continue;
            if (visit[r][c]) continue;
            if (board[r][c] >= h) {
                if (!flag) continue;
                // 공사 가능 여부 확인
                if (board[r][c] - K >= h) continue;
                // 1. 공사 진행
                int cnt = 1;
                while (true) {
                    if (board[r][c] - cnt < h) {
                        visit[r][c] = true;
                        dfs(r, c, board[r][c] - cnt, len + 1, false);
                        visit[r][c] = false;
                        break;
                    }
                    cnt++;
                }
            } else {
                visit[r][c] = true;
                dfs(r, c, board[r][c], len + 1, flag);
                visit[r][c] = false;
            }
        }
        if (len > maxLen) maxLen = len;
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
            K = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            top = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    // 가장 높은 봉우리 갱신
                    if (board[i][j] > top) {
                        top = board[i][j];
                        topList.clear();
                        topList.add(new int[]{i, j});
                    } else if (board[i][j] == top) {
                        topList.add(new int[]{i, j});
                    }
                }
            }
            maxLen = 0;
            for (int i = 0; i < topList.size(); i++) {
                // 시작 (r,c), 현재 등산로 길이, 공사 가능 여부
                visit = new boolean[N][N];
                int r = topList.get(i)[0];
                int c = topList.get(i)[1];
                visit[r][c] = true;
                dfs(r, c, top, 1, true);
            }
            sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
