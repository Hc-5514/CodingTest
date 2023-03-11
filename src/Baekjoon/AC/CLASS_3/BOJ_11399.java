/**
 * 문제 : ATM
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += numArr[j];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}