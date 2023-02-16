/**
 * 문제 : 로또
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6603 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] isSelected;

    private static void combination(int cnt, int start, int[] arr) {
        if (cnt == 6) {
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                combination(cnt + 1, i + 1, arr);
                isSelected[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        List<int[]> list = new ArrayList<>();

        // 배열 입력 받기
        String str = br.readLine();
        while (!str.equals("0")) {
            st = new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int i = 0; i < k; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            list.add(arr);
            str = br.readLine();
        }

        // 배열 별 조합
        for (int i = 0; i < list.size(); i++) {
            isSelected = new boolean[list.get(i).length];
            combination(0, 0, list.get(i));
            sb.append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
