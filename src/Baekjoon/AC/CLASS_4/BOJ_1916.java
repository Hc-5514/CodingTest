/**
 * 문제 : 최소비용 구하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i < map[0].length; i++) {
            Arrays.fill(map[i], -1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (map[a][b] != -1) {
                if (w > map[a][b])
                    continue;
            }
            map[a][b] = w;
        }
        st = new StringTokenizer(br.readLine());
        int startN = Integer.parseInt(st.nextToken());
        int endN = Integer.parseInt(st.nextToken());

        // 다익스트라
        final int INF = Integer.MAX_VALUE;
        int[] distance = new int[N + 1];
        boolean[] visit = new boolean[N + 1];

        Arrays.fill(distance, INF);
        distance[startN] = 0;

        int min, current;
        for (int i = 1; i < N + 1; i++) {
            // step1: 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
            current = -1;
            min = INF;

            for (int j = 1; j < N + 1; j++) {
                if (!visit[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            if (current == -1) break;
            visit[current] = true;

            // 선택된 정점이 도착 정점이면 종료
            if (current == endN) break;

            // step2: 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 미방문 인접 정점과 비용 최솟값 갱신
            for (int j = 1; j < N + 1; j++) {
                if (!visit[j] && map[current][j] != -1 && distance[j] > min + map[current][j]) {
                    distance[j] = min + map[current][j];
                }
            }
        }
        bw.write(distance[endN] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

