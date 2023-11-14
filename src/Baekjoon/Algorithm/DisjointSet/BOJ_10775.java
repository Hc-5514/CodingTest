/**
 * 문제 : 공항
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DisjointSet;

import java.io.*;

public class BOJ_10775 {

    private static int[] gate;

    private static int find(int n) {
        if (gate[n] == n) {
            return n;
        }
        return gate[n] = find(gate[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine().trim()); // 1 <= G <= 100,000
        int P = Integer.parseInt(br.readLine().trim()); // 1 <= P <= 100,000

        gate = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            gate[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            gate[n] = find(n);

            if (gate[n] == 0) {
                break;
            }

            gate[gate[n]] = find(gate[gate[n] - 1]);
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}