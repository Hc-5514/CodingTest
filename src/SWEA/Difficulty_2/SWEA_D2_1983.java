/**
 * 문제 : 조교의 성적 매기기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D2_1983 {

	public static String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		ArrayList<Double> al = new ArrayList<>();
		for (int tc = 1; tc <= T; tc++) {

			al.clear();

			int N = sc.nextInt(); // 학생 수
			int K = sc.nextInt(); // 학점을 알고 싶은 학생 K

			// 학생 점수 저장 및 내림차순 정렬
			double K_score = 0;
			for (int i = 1; i <= N; i++) {

				double score = sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2;
				al.add(score);

				if (i == K)
					K_score = score;
			}

			Collections.sort(al);
			Collections.reverse(al);

			// K 학생 순위 확인
			int idx = al.indexOf(K_score);
			idx = idx / (N / 10);

			System.out.println("#" + tc + " " + grade[idx]);
		}
	}

}
