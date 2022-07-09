/**
 * 문제 : 음계
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        StringTokenizer token = new StringTokenizer(str, " ");
        // Case 1:
//        int num = Integer.parseInt(token.nextToken());
//        if(num == 1){
//            for(int i=2; i<=8; i++){
//                if(i!=Integer.parseInt(token.nextToken())){
//                    System.out.println("mixed");
//                    break;
//                }
//                if(i==8)
//                    System.out.println("ascending");
//            }
//        }
//        else if(num == 8){
//            for(int i=7; i>=1; i--) {
//                if (i != Integer.parseInt(token.nextToken())) {
//                    System.out.println("mixed");
//                    break;
//                }
//                if (i == 1)
//                    System.out.println("descending");
//            }
//        }
//        else
//            System.out.println("mixed");

        // Case 2:
        int num = 0;
        int count = 0;
        for(int i=0; i<8; i++){
            num = Integer.parseInt(token.nextToken());
            if(num == (i+1))
                count++;
            else if(num == (8-i))
                count--;
        }

        if (count == 8)
            System.out.println("ascending");
        else if(count == -8)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
