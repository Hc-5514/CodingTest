/**
 * 문제 : 최댓값과 최솟값
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.*;
public class 최댓값과_최솟값 {

    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);

        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int a = list.get(0);
        int b = list.get(list.size()-1);
        String answer = a + " " + b;
        return answer;
    }
}
