/**
 * 문제 : 인간-컴퓨터 상호작용
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = br.readLine();
        int[][] preSum = new int[26][S.length() + 1];
        preSum[S.charAt(0) - 'a'][1] = 1;

        for (int i = 2; i <= S.length(); i++) {
            int cur = S.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                preSum[j][i] = (cur == j) ? preSum[j][i - 1] + 1 : preSum[j][i - 1];
            }
        }

        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken().trim());
            int r = Integer.parseInt(st.nextToken().trim());
            int cnt = preSum[ch - 'a'][r + 1] - preSum[ch - 'a'][l];
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
