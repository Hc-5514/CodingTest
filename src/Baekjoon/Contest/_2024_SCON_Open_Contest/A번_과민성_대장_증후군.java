/**
 * 문제 : A번 - 과민성 대장 증후군
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2024_SCON_Open_Contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A번_과민성_대장_증후군 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int pre = 0;
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pre += Integer.parseInt(st.nextToken());
			pre = pre < 0 ? 0 : pre;
			cnt = pre >= M ? cnt + 1 : cnt;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
