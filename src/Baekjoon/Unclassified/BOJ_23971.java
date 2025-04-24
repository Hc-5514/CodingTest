/**
 * 문제: ZOAC 4
 * 난이도: 브론즈 3
 * 메모리: 18716KB, 시간: 184ms
 * 풀이: 수학
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class BOJ_23971 {

	// 거리두기 수칙: 세로로 N칸, 가로로 M칸 비우고 앉아야 함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] info = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int result = (1 + (info[0] - 1) / (info[2] + 1)) * (1 + (info[1] - 1) / (info[3] + 1));

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
