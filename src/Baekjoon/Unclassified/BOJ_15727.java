/**
 * 문제 : 조별과제를 하려는데 조장이 사라졌다
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;

public class BOJ_15727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int t = 0;

        t = N / 5;

        if (N % 5 != 0)
            t++;

        bw.write(t + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}