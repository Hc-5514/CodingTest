/**
 * 문제 : 타겟 넘버
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BFSDFS;

public class 타겟_넘버 {

	int answer = 0;

	public void dfs(int[] numbers, int depth, int target, int cur) {
		if (depth == numbers.length) {
			if (cur == target) {
				answer++;
			}
			return;
		}
		dfs(numbers, depth + 1, target, cur + numbers[depth]);
		dfs(numbers, depth + 1, target, cur + (numbers[depth] * -1));
	}

	public int solution(int[] numbers, int target) {
		dfs(numbers, 0, target, 0);
		return answer;
	}
}
