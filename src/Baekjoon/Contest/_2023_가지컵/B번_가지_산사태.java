/**
 * 문제 : 가지 산사태
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2023_가지컵;

import java.io.*;
import java.util.StringTokenizer;

public class B번_가지_산사태 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int totalCnt = 0;
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int high = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            totalCnt += cnt;
            if (totalCnt > K) {
                bw.write((i + 1) + " " + 1 + "\n");
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}