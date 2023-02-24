/**
 * 문제 : 영역 구하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, areaCnt;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[][] visit;
    static int[][] infoRect;
    static final int[] dRow = {1, -1, 0, 0}, dCol = {0, 0, 1, -1};

    private static void setMap() {
        for (int k = 0; k < K; k++) {
            for (int i = infoRect[k][0]; i < infoRect[k][2]; i++) {
                for (int j = infoRect[k][1]; j < infoRect[k][3]; j++) {
                    visit[i][j] = true;
                }
            }
        }
    }

    private static void dfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                areaCnt = 0;
                if (!visit[i][j]) {
                    dfsImpl(i, j);
                    list.add(areaCnt);
                }
            }
        }
    }

    private static void dfsImpl(int i, int j) {
        areaCnt++;
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int r = i + dRow[k];
            int c = j + dCol[k];
            if (r < 0 || c < 0 || r >= N || c >= M) continue;
            if (!visit[r][c]) {
                dfsImpl(r, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        infoRect = new int[K][4];

        // 직사각형 꼭짓점 정보 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                infoRect[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setMap();
        dfs();

        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
