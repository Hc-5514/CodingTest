/**
 * 문제 : 럭비 클럽
 * 소요 시간 : 2분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2083 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if (name.equals("#")) {
				break;
			}
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			String grade = (age > 17 || weight >= 80) ? "Senior" : "Junior";
			bw.write(name + " " + grade + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
