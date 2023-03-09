/**
 * 문제 : 소수 찾기
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BruteForceSearch;

import java.util.ArrayList;

public class 소수_찾기 {

    int[] numArr, selectedNum;
    boolean[] isSelected;
    ArrayList<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;

        numArr = new int[numbers.length()];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = numbers.charAt(i) - '0';
        }
        for (int i = 1; i <= numbers.length(); i++) {
            selectedNum = new int[i];
            isSelected = new boolean[numbers.length()];
            permutation(0, i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) answer++;
        }

        return answer;
    }

    private void permutation(int depth, int goal) {
        if (depth == goal) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selectedNum.length; i++) {
                sb.append(selectedNum[i]);
            }
            int n = Integer.parseInt(sb.toString());
            if (!list.contains(n)) list.add(n);
            return;
        }

        for (int i = 0; i < numArr.length; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectedNum[depth] = numArr[i];
            permutation(depth + 1, goal);
            isSelected[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
