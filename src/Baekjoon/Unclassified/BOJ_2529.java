/**
 * 문제 : 부등호
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {

    static int k;

    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static int[] selectedNum;
    static boolean[] isSelected;
    static char[] sign;

    private static void getNum(int cnt) {
        if (cnt == k + 1) {
            long sum = 0;
            for (int i = 0; i < k + 1; i++) {
                sum += selectedNum[i] * Math.pow(10, k - i);
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt == 0) {
                isSelected[i] = true;
                selectedNum[cnt] = i;
                getNum(cnt + 1);
                isSelected[i] = false;
                continue;
            }

            if (isSelected[i])
                continue;

            if (sign[cnt - 1] == '<') {
                if (selectedNum[cnt - 1] < i) {
                    isSelected[i] = true;
                    selectedNum[cnt] = i;
                    getNum(cnt + 1);
                    isSelected[i] = false;
                }
            } else {
                if (selectedNum[cnt - 1] > i) {
                    isSelected[i] = true;
                    selectedNum[cnt] = i;
                    getNum(cnt + 1);
                    isSelected[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        selectedNum = new int[k + 1];
        isSelected = new boolean[10];
        sign = new char[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        getNum(0);

        String strMax = String.valueOf(max);
        String strMin = String.valueOf(min);

        if(strMax.length() < k+1){
            sb.append(0);
        }
        sb.append(max).append("\n");

        if(strMin.length() < k+1){
            sb.append(0);
        }
        sb.append(min).append("\n");

        System.out.println(sb);
        br.close();
    }
}
