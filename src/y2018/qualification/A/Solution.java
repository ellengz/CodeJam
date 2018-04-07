package y2018.qualification.A;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int i=1; i<=T; i++){
            int D = in.nextInt();
            String P = in.next();

            // record string P
            int[] array = new int[P.length()];
            int count = 0;
            int times = 0;
            int sum = 0;
            for (int j=0; j<P.length(); j++){
                if(P.charAt(j) == 'C'){
                    array[times] += count;
                    sum += Math.pow(2,times) * count;
                    times ++;
                    count = 0;
                }else{
                    count ++;
                }
            }
            if (times < P.length()) {
                sum += Math.pow(2,times) * count;
                array[times] += count;
            }

            // compare
            if (sum <= D){
                System.out.println("Case #" + i + ": " + 0);
            }else if (P.length() - times > D){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }else {
                int point = P.length() - 1;
                int round = 0;
                while (point > 0) {
                    while (array[point] > 0) {
                        sum = (int) (sum - Math.pow(2, point) + Math.pow(2, point - 1));
                        array[point] --;
                        array[point - 1] ++;
                        round ++;
                        if (sum <= D) { break; }
                    }
                    if (sum <= D) { break; }
                    point --;
                }
                System.out.println("Case #" + i + ": " + round);
            }
        }

        in.close();
    }
}
