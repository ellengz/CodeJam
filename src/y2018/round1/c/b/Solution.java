package y2018.round1.c.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); // N customers
            if (N == -1) {
                return;
            } else {
                int[] stock = new int[N];
                for (int i = 0; i < N; i ++) {
                    int D = in.nextInt(); // D prefer flavours
                    if (D == 0) {
                        System.out.println(-1);
                    } else {
                        int prefs[] = new int[D]; // each flavour ID in strictly increasing order
                        for (int j = 0; j < D; j ++) {
                            prefs[j] = in.nextInt();
                        }
                        boolean found = false;
                        for (int j = 0; j < D; j ++) {
                            if (stock[prefs[j]] == 0) { // find one in stock
                                stock[prefs[j]] --; // update stock
                                System.out.println(prefs[j]);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println(-1);
                        }
                    }

                }
            }
        }

    }

}
