/**
 * 문제 : 구명보트
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.Greedy;

import java.util.*;

public class 구명보트 {

	public int solution(int[] people, int limit) {
		// 가장 큰 무게 max, (최대 - max무게)의 최대값? -> 5만명 전부 최대값이라면?
		// 최대 2명 제한이 있다.
		Arrays.sort(people);
		int answer = 0;
		int cnt = 0;
		for(int i=0; i<people.length-cnt; i++){
			if(people[people.length-1-i] + people[cnt] <= limit){
				answer++;
				cnt++;
			}else {
				answer++;
			}
		}

		return answer;
	}
}
