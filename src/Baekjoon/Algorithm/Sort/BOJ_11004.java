/**
 * 문제 : K번째 수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Sort;

import java.io.*;
import java.util.*;

public class BOJ_11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        bw.write(list.get(K - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}