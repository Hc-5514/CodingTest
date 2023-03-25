/**
 * 문제 : 공항
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DisjointSet;

import java.io.*;

public class BOJ_10775 {

    static int[] airport;

    private static int find(int n) {
        if (airport[n] == n) return n;
        return airport[n] = find(airport[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine().trim());
        int P = Integer.parseInt(br.readLine().trim());

        int[] plain = new int[P];
        for (int i = 0; i < P; i++) {
            plain[i] = Integer.parseInt(br.readLine().trim());
        }

        airport = new int[G + 1];
        for (int i = 1; i < G + 1; i++) {
            airport[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            airport[plain[i]] = find(plain[i]);
            if (airport[plain[i]] == 0) break;
            cnt++;
            airport[airport[plain[i]]] = find(airport[airport[plain[i]] - 1]);
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}