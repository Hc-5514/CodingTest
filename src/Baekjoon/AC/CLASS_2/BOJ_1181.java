/**
 * 문제 : 단어 정렬
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1181 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        // 단어 입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        // 단어 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 단어의 길이가 같을 경우
                if (o1.length() == o2.length()) {
                    // 사전 순 정렬
                    return o1.compareTo(o2);
                } else {
                    // 단어 길이 순 정렬
                    return o1.length() - o2.length();
                }
            }
        });

        // 출력
        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append("\n");

        for (int i = 1; i < N; i++) {
            // 중복 아닌 단어 출력
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);

        br.close();
    }
}
