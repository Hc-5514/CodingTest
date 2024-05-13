/**
 * 문제 : 후보 추천하기
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
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim()); // 사진틀 개수 (1 ≤ N ≤ 20)
		int M = Integer.parseInt(br.readLine().trim()); // 총 추천 횟수 (M <= 1,000)
		st = new StringTokenizer(br.readLine());

		// 시간 제한 2초
		List<Student> students = new ArrayList<>();
		f1:
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 현재 사진이 게시된 학생이라면, 추천 횟수 증가
			for (int j = 0; j < students.size(); j++) {
				// 정렬 (1. 추천 횟수, 2. 최신 순)
				students.sort((o1, o2) -> {
					if (o1.cnt == o2.cnt) {
						return o1.order - o2.order;
					}
					return o1.cnt - o2.cnt;
				});

				if (students.get(j).num == num) {
					students.get(j).cnt++;
					continue f1;
				}
			}
			// 추천 횟수가 가장 적은 학생 사진 삭제 후 게시
			// 추천 횟수가 가장 적은 학생이 여러명이라면, 오래된 사진 삭제
			if (students.size() >= N) {
				students.remove(0);
			}

			students.add(new Student(num, i, 1));
		}

		// 학생 번호 수 정렬
		students.sort((o1, o2) -> o1.num - o2.num);

		for (int i = 0; i < students.size(); i++) {
			bw.write(students.get(i).num + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Student {
		int num;
		int order;
		int cnt;

		public Student(int num, int order, int cnt) {
			this.num = num;
			this.order = order;
			this.cnt = cnt;
		}
	}
}
