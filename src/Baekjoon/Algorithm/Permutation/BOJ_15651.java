/**
 * 문제 : N과 M (3)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selectedNum = new int[7];

    public static void permutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selectedNum[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            selectedNum[depth] = i;
            permutation(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permutation(0);

        System.out.println(sb.toString());
        br.close();
    }
}
