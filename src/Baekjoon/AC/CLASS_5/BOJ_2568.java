/**
 * 문제 : 전깃줄 - 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.*;

public class BOJ_2568 {

    static int N, dpLastIdx = 0, maxIdx = 0;
    static int[] dp;
    static ArrayList<Line> lineList = new ArrayList<>();
    static ArrayList<Integer> lisList = new ArrayList<>();

    private static int lowerBound(int target) {
        int s = 0, e = lisList.size() - 1;
        while (s < e) {
            int m = (s + e) >> 1;
            if (lisList.get(m) >= target) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lineList.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.from - o2.from;
            }
        });

        lisList.add(lineList.get(0).to);
        dp[0] = dpLastIdx++;
        for (int i = 1; i < N; i++) {
            // list 마지막 값보다 크다면 삽입
            if (lisList.get(lisList.size() - 1) < lineList.get(i).to) {
                lisList.add(lineList.get(i).to);
                dp[dpLastIdx] = dp[maxIdx] + 1;
                maxIdx = dpLastIdx++;
            } else {
                // lower_bound 를 이용하여 이분탐색 진행
                int idx = lowerBound(lineList.get(i).to);
                // 해당 인덱스 자리에 값 교체
                lisList.set(idx, lineList.get(i).to);
                dp[dpLastIdx++] = idx;
            }
        }

        int size = dp[maxIdx];
        bw.write((N - size - 1) + "\n");
        Stack<Integer> s = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] != size) {
                s.push(lineList.get(i).from);
            } else size--;
        }

        while (!s.isEmpty()) {
            bw.write(s.pop() + "\n");
        }

        bw.write("");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Line {
        int from;
        int to;

        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}