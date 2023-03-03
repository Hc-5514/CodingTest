/**
 * 문제 : [S/W 문제해결 응용] 4일차 - 보급로
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_4;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_D4_1249 {

    static int N, minTime;
    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    private static void bfs() {
        // 출발(0,0) -> 도착(N-1,N-1) 경로 중 복구 시간이 가장 짧은 경로에 대한 총 복구 시간 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.add(new int[]{0, 0, 0});
        visit[0][0] = true;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();

            if (tmp[0] == N - 1 && tmp[1] == N - 1) {
                if (tmp[2] < minTime) minTime = tmp[2];
                return;
            }

            if (tmp[2] > minTime) return;

            for (int i = 0; i < 4; i++) {
                int r = tmp[0] + dRow[i];
                int c = tmp[1] + dCol[i];
                // 지도 범위 확인
                if (r < 0 || c < 0 || r >= N || c >= N) continue;
                if(visit[r][c]) continue;
                visit[r][c] = true;
                pq.add(new int[]{r, c, tmp[2] + map[r][c]});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            minTime = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bfs();

            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
