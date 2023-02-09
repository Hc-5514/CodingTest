/**
 * 문제 : 부분수열의 합
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SubSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

	static int N, S, totalCnt = 0;
	static int[] arrN;
	static boolean[] isSelected;

	public static void getSubsetSum(int cnt, int sum) {

		// N개를 전부 비교 했다면 return
		if (cnt == N) {
			if (sum == S) {
				totalCnt++;
			}
			return;
		}

		// 부분 집합에 포함
		isSelected[cnt] = true;
		getSubsetSum(cnt + 1, sum + arrN[cnt]);

		// 부분 집합에 미포함
		isSelected[cnt] = false;
		getSubsetSum(cnt + 1, sum);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N: 입력받을 정수의 개수, S: 목표 부분집합의 합
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		// 정수 N개 입력 받기
		arrN = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		// 부분 집합의 합 구하기 - 미구현
		getSubsetSum(0, 0);

		// 출력 - 공집합 개수 제거
		if (S == 0)
			totalCnt--;
		System.out.println(totalCnt);
		br.close();
	}

}
