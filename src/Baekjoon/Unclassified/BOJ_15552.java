/**
 * 문제 : 빠른 A+B
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15552 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            bw.write(String.valueOf(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken())));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
