package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;

public class 표현_가능한_이진트리 {

    static int ans = 0;

    private static void binarySearch(String binaryStr, int s, int e, boolean flag) {
        if (s > e) return;
        int m = (s + e) >> 1;
        if (binaryStr.charAt(m) == '1') {
            if (!flag) {
                ans = 0;
                return;
            }
            binarySearch(binaryStr, s, m - 1, true);
            binarySearch(binaryStr, m + 1, e, true);
        } else {
            binarySearch(binaryStr, s, m - 1, false);
            binarySearch(binaryStr, m + 1, e, false);
        }
    }

    public static int[] solution(long[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.setLength(0);
            sb.append(Long.toBinaryString(numbers[i]));

            int len = 0;
            for (int j = 1; j <= 15; j++) {
                if (sb.length() <= Math.pow(2, j) - 1) {
                    len = (int) Math.pow(2, j) - 1;
                    break;
                }
            }

            while (sb.length() < len) {
                sb.insert(0, 0);
            }

            ans = 1;
            binarySearch(sb.toString(), 0, sb.length() - 1, true);

            list.add(ans);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] result1 = solution(new long[]{7, 42, 5});
        int[] result2 = solution(new long[]{63, 111, 95});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
