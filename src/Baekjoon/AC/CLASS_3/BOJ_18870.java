/**
 * 문제 : 좌표 압축
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.*;

public class BOJ_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] ori = new int[N];
        int[] sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ori[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(sorted);

        // Map에 자신보다 작은 수의 개수를 저장
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], cnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(ori[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}