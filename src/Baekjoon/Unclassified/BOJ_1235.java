/**
 * 문제 : 학생 번호
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N명의 학생 번호 받기
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();

        // k 탐색 시작 값 구하기
        int k = 1;
        int tmpN = N;
        while (tmpN >= 10) {
            tmpN /= 10;
            k++;
        }

        HashSet<String> hs = new HashSet<>();
        w1:
        while (hs.size() != N) {
            hs.clear();
            for (int i = 0; i < N; i++) {
                int size = arr[0].length();
                String tmp = arr[i].substring(size - k, size);
                if (hs.contains(tmp)) {
                    k++;
                    continue w1;
                } else hs.add(tmp);
            }
        }
        System.out.println(k);
        br.close();
    }
}
