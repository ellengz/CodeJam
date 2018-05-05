package y2018.round1.c.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t ++) {
            int N = in.nextInt();
            int L = in.nextInt();
            // store each word
            String[] words = new String[N];
            for (int i = 0; i < N; i ++) {
                words[i] = in.next();
            }
            // store each column
            String[] columns = new String[L];
            String[] unique = new String[L]; // only unique letters
            for (int i = 0; i < L; i ++) {
                String temp = "";
                for (int j = 0; j < N; j ++) {
                    temp += words[j].charAt(i);
                }
                columns[i] = temp;
                unique[i] = uniqueCol(columns[i]);
            }
            int combinations = 1; // all possible combinations
            for (int i = 0; i < L; i ++) {
                combinations *= unique[i].length();
            }
            if (N == combinations) {
                System.out.println("Case #" + t + ": " + "-");
            } else {
                boolean found = false;
                while (!found) {
                    String candidate = "";
                    for (int i = 0; i < L; i ++) {
                        candidate += unique[i].charAt(random.nextInt(unique[i].length()));
                    }
                    if (!Arrays.asList(words).contains(candidate)) {
                        System.out.println("Case #" + t + ": " + candidate);
                        break;
                    }
                }
            }


        }
    }

    private static String uniqueCol(String str) {
        String temp="";
        for (int i = 0; i < str.length(); i++) {
            if(temp.indexOf(str.charAt(i)) == -1 ){
                temp = temp + str.charAt(i);
            }
        }
        return temp;
    }
}
