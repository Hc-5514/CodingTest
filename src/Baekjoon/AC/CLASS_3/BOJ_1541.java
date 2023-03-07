/**
 * 문제 : 잃어버린 괄호
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        // 1. -로 끊어서 끊어진 것들끼리 모두 더함
        ArrayList<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            st = new StringTokenizer(list.get(i), "+");
            int tmp = 0;
            while (st.hasMoreTokens()) {
                tmp += Integer.parseInt(st.nextToken());
            }
            if (i == 0) ans += tmp;
            else ans -= tmp;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
