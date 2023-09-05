/**
 * 문제 : 단어 변환
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BFSDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 단어_변환 {
	public int solution(String begin, String target, String[] words) {
		List<String> list = new ArrayList<>();
		boolean isContain = false;
		for (int i = 0; i < words.length; i++) {
			list.add(words[i]);
			if (words[i].equals(target)) {
				isContain = true;
			}
		}
		if (!isContain) {
			return 0;
		}
		Queue<String> q = new ArrayDeque<>();
		q.offer(begin);
		int answer = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				String cur = q.poll();
				if (cur.equals(target)) {
					return answer;
				}
				for (int i = list.size() - 1; i >= 0; i--) {
					int cnt = 0;
					for (int j = 0; j < cur.length(); j++) {
						if (cur.charAt(j) != list.get(i).charAt(j)) {
							cnt++;
						}
						if (cnt > 1)
							break;
					}
					if (cnt <= 1) {
						q.offer(list.get(i));
						list.remove(i);
					}
				}
			}
			answer++;
		}
		return 0;
	}
}
