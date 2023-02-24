/**
 * 문제 : ABCDE
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {

    static int N, M;

    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static boolean isExist = false;

    private static void dfs(int no, int cnt) {
        if (cnt == 5) {
            isExist = true;
        }

        if (isExist) return;

        for (int i = 0; i < list[no].size(); i++) {
            int num = list[no].get(i);
            if (!visit[num]) {
                visit[num] = true;
                dfs(num, cnt + 1);
                visit[num] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        if (isExist) System.out.println(1);
        else System.out.println(0);
        br.close();
    }
}
