/**
 * 문제 : 연속합
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            if (numArr[i] > max) max = numArr[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numArr[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}