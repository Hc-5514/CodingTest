/**
 * 문제 : 수 정렬하기 3
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 N개 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 오름차순 정렬하기
        Arrays.sort(arr);

        for(int n : arr){
            sb.append(n).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
