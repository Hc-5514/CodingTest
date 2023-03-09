/**
 * 문제 : 스타트링크
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 가중치가 없는 최단 경로 문제이므로 BFS 이용
 */

public class BOJ_5014 {

    static int F, S, G, U, D, cnt = 0;
    static boolean[] visit = new boolean[1000001];

    private static boolean bfs() {
        // U층 위, D층 아래에 해당 층이 없을 땐 이동 안 함
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        visit[S] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == G) return true;
                int n1 = cur + U;
                if (n1 <= F && !visit[n1]) {
                    q.offer(n1);
                    visit[n1] = true;
                }
                int n2 = cur - D;
                if (n2 >= 1 && !visit[n2]) {
                    q.offer(n2);
                    visit[n2] = true;
                }
            }
            cnt++;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // F: 전체 건물 높이 (1 ~ F층)
        S = Integer.parseInt(st.nextToken()); // S: 현재 위치
        G = Integer.parseInt(st.nextToken()); // G: 목적지
        U = Integer.parseInt(st.nextToken()); // U: 위로 U층 이동
        D = Integer.parseInt(st.nextToken()); // D: 아래로 D층 이동

        if (bfs()) {
            bw.write(cnt + "\n");
        } else bw.write("use the stairs");

        bw.flush();
        bw.close();
        br.close();
    }
}