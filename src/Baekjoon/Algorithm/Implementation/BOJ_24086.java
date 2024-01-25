/**
 * 문제 : 身長 (Height)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_24086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine().trim());
		int B = Integer.parseInt(br.readLine().trim());

		bw.write((B - A) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
