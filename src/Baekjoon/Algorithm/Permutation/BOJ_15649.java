/**
 * 문제 : N과 M (1)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static int[] selectNum;
    static boolean[] isSelected;

    private static void permutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selectNum[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectNum[depth] = i;
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectNum = new int[M];
        isSelected = new boolean[N + 1];
        permutation(0);

        System.out.println(sb.toString());
        br.close();
    }
}
