/**
 * 문제 : 랭킹전 대기열
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20006 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Player>> players = new ArrayList<>();

		f1:
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
			for (int j = 0; j < players.size(); j++) {
				// 입장 정원 확인
				if (players.get(j).size() >= m) {
					continue;
				}
				// 레벨 차이 확인
				if (players.get(j).get(0).level < player.level - 10
					|| players.get(j).get(0).level > player.level + 10) {
					continue;
				}
				// 입장
				players.get(j).add(player);
				continue f1;
			}
			players.add(new ArrayList<>());
			players.get(players.size() - 1).add(player);
		}

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).size() == m) {
				bw.write("Started!\n");
			} else {
				bw.write("Waiting!\n");
			}

			Collections.sort(players.get(i), Comparator.comparing(o -> o.name));

			for (Player player : players.get(i)) {
				bw.write(player.level + " " + player.name + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Player {
		int level;
		String name;

		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}
}
