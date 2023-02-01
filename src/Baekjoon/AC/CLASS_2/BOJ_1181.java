/**
 * 문제 : 단어 정렬
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_1181 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> list;

        // HashSet에 단어 저장 - 중복 단어 제거
        int N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            hs.add(br.readLine());
        }

        // HashSet -> List 변환 후 정렬
        list = new ArrayList<>(hs);
        Collections.sort(list);

        // 길이가 짧은 순서대로 출력 후 List에서 제거
        int wordLength = 1;
        while (!list.isEmpty()) {
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                if (list.get(i).length() == wordLength) {
                    System.out.println(list.get(i));
                    list.remove(i);
                    i--;
                    listSize--;
                }
            }
            wordLength++;
        }

        br.close();
    }
}
