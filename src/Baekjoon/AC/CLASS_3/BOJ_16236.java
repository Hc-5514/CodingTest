/**
 * 문제 : 아기 상어
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236 {

    static int N, sharkSize = 2, totalTime = 0, curR, curC, eatCnt = 0;

    static final int[] dRow = {-1, 0, 0, 1}, dCol = {0, -1, 1, 0};
    static int[][] map;
    static boolean[][] visit;

    private static void bfs() {
        // 먹을 수 있는 물고기로 이동
        // 0: r, 1: c, 2: time
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 1. 거리순, 2. row 0에 가까운 순, 3. col 0에 가까운 순
                if (o1[2] == o2[2]) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });

        visit = new boolean[N][N];

        pq.offer(new int[]{curR, curC, 0});
        visit[curR][curC] = true;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            // 해당 칸에 먹을 수 있는 물고기가 있는지 확인
            if (map[tmp[0]][tmp[1]] >= 1 && map[tmp[0]][tmp[1]] < sharkSize) {
                // 상어 위치 변경
                map[tmp[0]][tmp[1]] = 9;
                map[curR][curC] = 0;
                curR = tmp[0];
                curC = tmp[1];
                // 시간 증가
                totalTime += tmp[2];
                eatCnt++;
                // 물고기를 본인 크기만큼 먹었다면 크기 증가
                if (eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }
                // pq 초기화 및 현재 위치 삽입
                pq.clear();
                pq.offer(new int[]{curR, curC, 0});
                visit = new boolean[N][N];
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int r = tmp[0] + dRow[i];
                int c = tmp[1] + dCol[i];
                // 배열 범위 확인
                if (r < 0 || c < 0 || r >= N || c >= N) continue;
                // 방문 확인
                if (visit[r][c]) continue;
                // 지나갈 수 있는 칸인지 확인
                if (map[r][c] > sharkSize) continue;
                pq.offer(new int[]{r, c, tmp[2] + 1});
                visit[r][c] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 상어 초기값 저장
                if (map[i][j] == 9) {
                    curR = i;
                    curC = j;
                }
            }
        }

        bfs();

        bw.write(totalTime + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
