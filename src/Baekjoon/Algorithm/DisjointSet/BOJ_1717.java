/**
 * 문제 : 집합의 표현
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] set;

    static private void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) set[bRoot] = aRoot;
    }

    static private int find(int a) {
        if (set[a] == a) return a;
        return set[a] = find(set[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());

        set = new int[n];
        for (int i = 0; i < set.length; i++)
            set[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            // cmd 0: 합집합
            if (cmd == 0) {
                union(n1, n2);
            }
            // cmd 1: 같은 집합 확인
            else {
                if (find(n1) == find(n2))
                    sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}