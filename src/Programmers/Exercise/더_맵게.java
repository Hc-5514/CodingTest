package Programmers.Exercise;

import java.util.PriorityQueue;

public class 더_맵게 {

	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n : scoville) {
			pq.offer(n);
		}

		while (pq.peek() < K && pq.size() >= 2) {
			int f1 = pq.poll();
			int f2 = pq.poll();
			int nf = f1 + f2 * 2;
			pq.offer(nf);
			answer++;
		}

		answer = (pq.peek() < K) ? -1 : answer;

		return answer;
	}
}
