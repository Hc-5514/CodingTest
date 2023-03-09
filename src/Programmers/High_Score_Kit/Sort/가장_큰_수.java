/**
 * 문제 : 가장 큰 수
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {
        String answer = "";

        boolean flag = false;
        int size = numbers.length;
        String[] strNumbers = new String[size];
        for (int i = 0; i < size; i++) {
            if (numbers[i] != 0) flag = true;
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });

        if (!flag) return "0";

        for (int i = 0; i < strNumbers.length; i++) {
            answer += strNumbers[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = solution(new int[]{3, 30, 34, 5, 9, 0});
//        String str = solution(new int[]{0, 0, 0, 0, 0, 0});
        System.out.println(str);
    }
}
