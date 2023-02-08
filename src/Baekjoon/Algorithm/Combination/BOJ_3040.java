/**
 * 문제 : 백설 공주와 일곱 난쟁이
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040 {

    static int[] arrNum = new int[9];
    static int[] selectedNum = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void recursion(int cnt, int start) {

        if (cnt == 7) {
            int sum = 0;
            for (int n : selectedNum) {
                sum += n;
            }
            // 난쟁이 7명의 숫자 합이 100이면 정답
            if (sum == 100) {
                for (int n : selectedNum) {
                    sb.append(n).append("\n");
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selectedNum[cnt] = arrNum[i];
            recursion(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난쟁이 9명 숫자 정보 받기
        for (int i = 0; i < 9; i++) {
            arrNum[i] = Integer.parseInt(br.readLine());
        }

        recursion(0, 0);

        System.out.println(sb.toString());
        br.close();
    }
}
