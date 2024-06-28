/**
 * 문제 : 정보 상인 호석
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int Q = Integer.parseInt(br.readLine().trim());
		Map<String, PriorityQueue<Integer>> infoMap = new HashMap<>();

		long totalValue = 0;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken()); // 1 or 2
			String name = st.nextToken(); // name
			int nCnt;
			switch (cmd) {
				case 1:
					nCnt = (Integer.parseInt(st.nextToken()));
					if (!infoMap.containsKey(name)) {
						PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
						infoMap.put(name, pq);
					}
					for (int j = 0; j < nCnt; j++) {
						infoMap.get(name).offer(Integer.parseInt(st.nextToken()));
					}
					break;
				case 2:
					nCnt = Integer.parseInt(st.nextToken());
					if (infoMap.containsKey(name)) {
						while (!infoMap.get(name).isEmpty() && nCnt > 0) {
							totalValue += infoMap.get(name).poll();
							nCnt--;
						}
					}
					break;
			}
		}

		bw.write(totalValue + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
