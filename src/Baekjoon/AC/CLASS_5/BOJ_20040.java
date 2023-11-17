/**
 * 문제 : 사이클 게임
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20040 {

    private static int[] parent;

    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    private static boolean union(int n1, int n2) {
        int p1 = find(parent[n1]);
        int p2 = find(parent[n2]);

        if (p1 == p2) {
            return true;
        }

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 3 ≤ n ≤ 500,000
        int m = Integer.parseInt(st.nextToken()); // 3 ≤ m ≤ 1,000,000

        parent = new int[n]; // 사이클 생성 여부 확인, n 개의 점 (0 ~ n-1)
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        int round = 1; // 진행 라운드 수

        // 선분 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            // 사이클이 완성되면, 해당 round 출력
            if (union(n1, n2)) {
                break;
            }
            round++;
        }

        // 모든 라운드가 종료될 때까지 사이클이 없다면, 0 출력
        if (round > m) {
            round = 0;
        }

        bw.write(round + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


/*
입력
6 5
0 1
1 2
2 3
0 4
3 4

출력
5
 */