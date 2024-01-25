/**
 * 문제 : 오늘의 날짜는?
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;

public class BOJ_16170 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(LocalDateTime.now().getYear() + "\n");
		bw.write(LocalDateTime.now().getMonthValue() + "\n");
		bw.write(LocalDateTime.now().getDayOfMonth() + "\n");
		bw.flush();
		bw.close();
	}
}