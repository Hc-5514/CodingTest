/**
 * 문제 : 벽 부수고 이동하기 4
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.*;

public class BOJ_16946 {

    private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N * M 입력 받기 (1 <= N <= 1000, 1 <= M <= 1000)
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        Map<Integer, Integer> cntMap = new HashMap<>();
        int idx = 2;

        // bfs: board[i][j] == 0 인 곳 탐색, 그룹화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 벽
                if (board[i][j] == 1) {
                    continue;
                }
                // 이미 탐색한 영역
                if (board[i][j] != 0) {
                    continue;
                }
                // bfs 시작
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i, j});
                board[i][j] = idx;
                int cnt = 1;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int r = cur[0] + dRow[k];
                        int c = cur[1] + dCol[k];
                        // 배열 범위 확인
                        if (r < 0 || c < 0 || r >= N || c >= M) {
                            continue;
                        }
                        if (board[r][c] == 0) {
                            q.offer(new int[]{r, c});
                            board[r][c] = idx;
                            cnt++;
                        }
                    }
                }

                cntMap.put(idx, cnt);
                idx++;
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1) {
                    bw.write("0");
                    continue;
                }
                // 4 방향 탐색 후, 이동 가능한 칸의 cnt 총합 구하기
                Set<Integer> hs = new HashSet<>();
                int sum = 1;
                for (int k = 0; k < 4; k++) {
                    int r = i + dRow[k];
                    int c = j + dCol[k];
                    // 배열 범위 확인
                    if (r < 0 || c < 0 || r >= N || c >= M) {
                        continue;
                    }
                    // 벽 확인
                    if (board[r][c] == 1) {
                        continue;
                    }
                    hs.add(board[r][c]);
                }

                // 이동 가능한 칸 개수 저장
                for (int cnt : hs) {
                    sum += cntMap.get(cnt);
                }
                bw.write(String.valueOf(sum % 10));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}