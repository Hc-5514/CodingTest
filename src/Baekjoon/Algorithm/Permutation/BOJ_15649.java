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
    static int[] selectedNum = new int[9];
    static boolean[] isSelected = new boolean[9];

    public static void recursion(int N, int M, int depth) {

        if (depth == M) {
            for(int i=0; i<depth; i++)
                sb.append(selectedNum[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 이미 선택된 수는 x
            if (isSelected[i]) continue;
            // 선택된 수 저장
            selectedNum[depth] = i;
            isSelected[i] = true;
            recursion(N, M, depth + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursion(N, M, 0);

        System.out.println(sb.toString());
        br.close();
    }
}
