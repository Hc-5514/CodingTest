/**
 * 문제 : N과 M (5)
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] numArr, selectedNum;
    static boolean[] isSelected;

    private static void permutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selectedNum[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectedNum[depth] = numArr[i];
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        selectedNum = new int[M];
        isSelected = new boolean[N];

        Arrays.sort(numArr);

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}