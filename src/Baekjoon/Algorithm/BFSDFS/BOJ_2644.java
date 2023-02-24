/**
 * 문제 : 촌수계산
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {

    static int n, m, p1, p2, degree;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static boolean flag = false;

    private static void dfs(int n, int cnt) {
        for (int i = 0; i < list[n].size(); i++) {
            visit[n] = true;
            int num = list[n].get(i);
            if (!visit[num]) {
                if (num == p2) {
                    degree = cnt;
                    flag = true;
                }
                dfs(num, cnt + 1);
            }
        }
        if (!flag) degree = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // (기준: 나) 아버지: 1촌, 할아버지: 2촌, 아버지 형제: 3촌
        n = Integer.parseInt(br.readLine()); // 전체 사람 수
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken()); // 관계를 구해야 할 사람 p1, p2
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine()); // 부모 자식 관계의 개수
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(p1, 1);

        System.out.println(degree);
        br.close();
    }
}
