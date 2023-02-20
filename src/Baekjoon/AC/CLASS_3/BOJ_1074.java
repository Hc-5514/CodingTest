/**
 * 문제 : Z
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {

    static int n, r, c, cnt;

    private static void division(int startR, int startC, int size) {
        if (size == 2) {
            if (r == startR) {
                if (c == startC)
                    cnt += 1;
                else cnt += 2;
            } else {
                if (c == startC)
                    cnt += 3;
                else cnt += 4;
            }
            return;
        }

        // r,c의 위치 찾기
        int half = size / 2;
        if (r - startR < half && c - startC < half) {
            division(startR, startC, half);
        } else if (r - startR < half && c - startC >= half) {
            cnt += (half * half);
            division(startR, startC + half, half);
        } else if (r - startR >= half && c - startC < half) {
            cnt += (half * half * 2);
            division(startR + half, startC, half);
        } else {
            cnt += (half * half * 3);
            division(startR + half, startC + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        division(0, 0, size);

        System.out.println(cnt - 1);
        br.close();
    }
}
