/**
 * 문제 : 차이를 최대로
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {

    private static int n, max = Integer.MIN_VALUE;
    private static int[] numArr, selectNum;
    private static boolean[] isSelected;

    private static void getMax(int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(selectNum[i] - selectNum[i + 1]);
            }
            max = Math.max(max, sum);
        }

        for (int i = 0; i < n; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectNum[cnt] = numArr[i];
            getMax(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n개 수 입력
        n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        selectNum = new int[n];
        isSelected = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        getMax(0);

        System.out.println(max);

        br.close();
    }
}
