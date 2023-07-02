/**
 * 문제 : 가장 가까운 세 사람의 심리적 거리
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            N = N >= 33 ? 33 : N;   // 비둘기집 원리
            char[][] mbti = new char[N][4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken().toCharArray();
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int cnt = 0;
                        for (int l = 0; l < 4; l++) {
                            if (mbti[i][l] != mbti[j][l]) cnt++;
                            if (mbti[i][l] != mbti[k][l]) cnt++;
                            if (mbti[j][l] != mbti[k][l]) cnt++;
                            if (cnt >= min) break;
                        }
                        min = Math.min(min, cnt);
                    }
                }
            }
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}