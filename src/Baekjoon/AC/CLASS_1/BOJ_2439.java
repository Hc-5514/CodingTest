/**
 * 문제 : 별 찍기 - 1
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.*;

public class BOJ_2439 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        bf.close();

        // 1. System.out.print
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 2. BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                bw.write(' ');
            }
            for(int j=1; j<=i; j++){
                bw.write('*');
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
