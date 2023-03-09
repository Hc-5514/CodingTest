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

        int size = numbers.length;
        String[] strNumbers = new String[size];
        for (int i = 0; i < size; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (int i = 0; i < strNumbers.length; i++) {
            answer += strNumbers[i];
        }

        if (answer.charAt(0) == '0') return "0";
        else return answer;
    }
}
