/**
 * 문제 : 1,2,3 더하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

    public static int[] arr;

    public static int dp(int num) {

        if (arr[num] != 0)
            return arr[num];
        else {
            if (arr[num - 3] != 0 && arr[num - 2] != 0 && arr[num - 1] != 0) {
                arr[num] = arr[num - 3] + arr[num - 2] + arr[num - 1];
                return arr[num];
            } else
                return dp(num - 3) + dp(num - 2) + dp(num - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());

            if (n < 4) {
                if (n == 3) {
                    sb.append(4).append("\n");
                } else {
                    sb.append(n).append("\n");
                }
                continue;
            } else {
                arr = new int[n + 1];
                arr[1] = 1;
                arr[2] = 2;
                arr[3] = 4;
            }

            sb.append(dp(n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
