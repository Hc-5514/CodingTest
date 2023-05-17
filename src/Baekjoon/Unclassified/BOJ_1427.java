/**
 * 문제 : 소트인사이드
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numStr = br.readLine();
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(numStr.charAt(i));
        }

        Arrays.sort(arr);

        for (int i = arr.length-1; i >= 0; i--) {
            bw.write(arr[i]+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}