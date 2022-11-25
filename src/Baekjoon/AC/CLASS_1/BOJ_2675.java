/**
 * 문제 : 문자열 반복
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String str;
        for(int i=0; i<T; i++){
            str = br.readLine();
            StringTokenizer token = new StringTokenizer(str, " ");
            int R = Integer.parseInt(token.nextToken());
            str = token.nextToken();
            for(int j=0; j<str.length(); j++){
                for(int k=0; k<R; k++){
                    System.out.print(str.charAt(j));
                }
            }

            bw.newLine();
            bw.flush();
        }
    }
}
