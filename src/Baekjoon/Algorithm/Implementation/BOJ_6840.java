/**
 * 문제 : Who is in the middle?
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

public class BOJ_6840 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(Integer.parseInt(br.readLine().trim()));
		}

		Collections.sort(list);

		bw.write(list.get(1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
