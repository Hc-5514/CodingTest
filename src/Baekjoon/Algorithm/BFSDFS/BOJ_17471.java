/**
 * 문제 : 게리맨더링
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {

    static int N, minSum = Integer.MAX_VALUE;
    static int[] peopleCnt;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    static boolean[] visit, visit2;
    static boolean isSuccess;

    private static void combinationList(int N) {
        for (int i = 1; i <= N / 2; i++) {
            combination(0, 0, i);
            if (isSuccess) break;
        }
    }

    private static void combination(int cnt, int start, int goal) {
        if (cnt == goal) {
            list1.clear();
            list2.clear();
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    list1.add(i + 1);
                } else list2.add(i + 1);
            }
            if (checkConnect(list1) && checkConnect(list2)) {
                // 차이 구하기
                int sum1 = 0, sum2 = 0;
                for (int i = 0; i < list1.size(); i++) {
                    sum1 += peopleCnt[list1.get(i) - 1];
                }
                for (int i = 0; i < list2.size(); i++) {
                    sum2 += peopleCnt[list2.get(i) - 1];
                }
                minSum = Math.min(minSum, Math.abs(sum1 - sum2));
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            combination(cnt + 1, i + 1, goal);
            visit[i] = false;
        }
    }

    private static boolean checkConnect(ArrayList<Integer> tmpList) {
        Arrays.fill(visit2, false);
        Queue<Integer> q = new ArrayDeque<>();
        int n = tmpList.get(0);
        q.offer(n);
        visit2[n - 1] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                int num = list[tmp].get(i);
                if (tmpList.contains(num) && visit2[num - 1] == false) {
                    q.offer(list[tmp].get(i));
                    visit2[num - 1] = true;
                }
            }
        }
        for (int i = 0; i < tmpList.size(); i++) {
            if (!visit2[tmpList.get(i) - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        peopleCnt = new int[N];
        visit = new boolean[N];
        visit2 = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            peopleCnt[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int n = Integer.parseInt(st.nextToken());
                list[i].add(n);
            }
        }

        combinationList(N);

        if (minSum == Integer.MAX_VALUE) {
            minSum = -1;
        }
        System.out.println(minSum);
        br.close();
    }
}
