/**
 * 문제 : 정보보호학부 동아리 소개
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_28691 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		switch (br.readLine().charAt(0)) {
			case 'M':
				bw.write("MatKor\n");
				break;
			case 'W':
				bw.write("WiCys\n");
				break;
			case 'C':
				bw.write("CyKor\n");
				break;
			case 'A':
				bw.write("AlKor\n");
				break;
			case '$':
				bw.write("$clear\n");
				break;
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
