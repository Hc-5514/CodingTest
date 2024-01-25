/**
 * 문제 : Hook
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_10189 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("#  # #### #### #  #\n"
			+ "#### #  # #  # # #\n"
			+ "#### #  # #  # # #\n"
			+ "#  # #### #### #  #");
		bw.flush();
		bw.close();
	}
}
