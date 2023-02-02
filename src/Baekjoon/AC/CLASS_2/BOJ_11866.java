/**
 * 문제 : 요세푸스 문제 0
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int idx = K - 1;

        // list에 N명(인덱스) 추가
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // N명이 모두 제거 될 때까지 반복
        sb.append("<");
        while (N > 1) {
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
            idx = (idx + K - 1) % (--N);
        }
        sb.append(list.get(idx)).append(">");
        System.out.println(sb);
    }
}
