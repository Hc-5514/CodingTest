/**
 * 문제 : 리모컨
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        boolean[] brokenNum = new boolean[10];

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brokenNum[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = 999999;

        // case 1) 100번 에서 +- 이동
        min = Math.min(min, Math.abs(100 - N));

        // case 2) 숫자 입력 후, +- 로 이동
        f1:
        for (int i = 0; i < 999999; i++) {
            String strNum = String.valueOf(i);
            for (int j = 0; j < strNum.length(); j++) {
                if (brokenNum[Character.getNumericValue(strNum.charAt(j))]) {
                    continue f1;
                }
            }
            int cnt = Math.abs(i - N) + String.valueOf(i).length();
            min = Math.min(min, cnt);
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}