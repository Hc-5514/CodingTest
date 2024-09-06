/**
 * 문제 : 가희와 키워드
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_22233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> stringSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			stringSet.add(br.readLine().trim());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (stringSet.contains(str)) {
					stringSet.remove(str);
				}
			}
			bw.write(stringSet.size() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
