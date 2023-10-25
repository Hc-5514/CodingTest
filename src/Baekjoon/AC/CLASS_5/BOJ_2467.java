/**
 * 문제 : 용액
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2467 {

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

        int ans1 = 0;
        int ans2 = N - 1;
        int minSum = numArr[ans1] + numArr[ans2];

        int s = 0;
        int e = N - 1;
        while (s < e) {
            int sum = numArr[s] + numArr[e];
            // 갱신
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                ans1 = s;
                ans2 = e;
            }
            if (sum < 0) {
                s++;
            } else if (sum > 0) {
                e--;
            } else {
                break;
            }
        }


        bw.write(numArr[ans1] + " " + numArr[ans2] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
