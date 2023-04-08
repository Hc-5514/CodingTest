/**
 * 문제 : :danceplant:
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2023_가지컵;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class D번_danceplant {

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] coords = new int[]{N / 2 - 1, N / 2 - 1, N / 2, N / 2};

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(coords);
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int sR = tmp[0], sC = tmp[1], eR = tmp[2], eC = tmp[3];
            int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
            for (int k = 0; k < 4; k++) {
                // 상 탐색
                if (k == 0) {
                    if (sR - 1 < 0) continue;
                    for (int i = sC; i <= eC; i++) {
                        cnt1 += board[sR - 1][i];
                    }
                }
                // 하 탐색
                else if (k == 1) {
                    if (eR + 1 >= N) continue;
                    for (int i = sC; i <= eC; i++) {
                        cnt2 += board[eR + 1][i];
                    }
                }
                // 좌 탐색
                else if (k == 2) {
                    if (sC - 1 < 0) continue;
                    for (int i = sR; i <= eR; i++) {
                        cnt3 += board[i][sC - 1];
                    }
                }
                // 우 탐색
                else {
                    if (eC + 1 >= N) continue;
                    for (int i = sR; i <= eR; i++) {
                        cnt4 += board[i][eC + 1];
                    }
                }
            }
            // cnt1 ~ cnt4 방향 중 가장 큰 방향으로 이동
            // 가장 큰 방향이 0이하라면 이동x
            if (cnt1 > 0 && cnt1 >= cnt2 && cnt1 >= cnt3 && cnt1 >= cnt4) {
                cnt += cnt1;
                sb.append("U");
                q.offer(new int[]{sR - 1, sC, eR, eC});
            } else if (cnt2 > 0 && cnt2 >= cnt1 && cnt2 >= cnt3 && cnt2 >= cnt4) {
                cnt += cnt2;
                sb.append("D");
                q.offer(new int[]{sR, sC, eR + 1, eC});
            } else if (cnt3 > 0 && cnt3 >= cnt1 && cnt3 >= cnt2 && cnt3 >= cnt4) {
                cnt += cnt3;
                sb.append("L");
                q.offer(new int[]{sR, sC - 1, eR, eC});
            } else if (cnt4 > 0 && cnt4 >= cnt1 && cnt4 >= cnt2 && cnt4 >= cnt3) {
                cnt += cnt4;
                sb.append("R");
                q.offer(new int[]{sR, sC, eR, eC + 1});
            }
        }

        bw.write(cnt + "\n");
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}