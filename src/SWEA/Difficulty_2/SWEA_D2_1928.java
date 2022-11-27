/**
 * 문제 : Base64 Decoder
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class SWEA_D2_1928 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String encodedStr = br.readLine();
//			System.out.println("str.getBytes: " + str.getBytes());
//			String encodedStr = Base64.getEncoder().encodeToString(str.getBytes());
//			System.out.println("encodedStr: " + encodedStr);
//			String decodedStr = new String(Base64.getDecoder().decode(encodedStr));
//			System.out.println("decodedStr: " + decodedStr);

            String decodedStr = new String(Base64.getDecoder().decode(encodedStr));
            System.out.println("#" + tc + " " + decodedStr);
        }

    }

}
