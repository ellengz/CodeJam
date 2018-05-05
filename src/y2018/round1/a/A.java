package y2018.round1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int H = in.nextInt();
            int V = in.nextInt();
            int [][] cells = new int[R][C];
            int total = 0;
            int[] sumRow = new int[R];
            int[] sumRows = new int[R]; // cumulative
            int[] sumCol = new int[C];
            int[] sumCols = new int[C]; // cumulative
            for (int i = 0; i < R; i ++) {
                String row = in.next();
                for (int j = 0; j < C; j ++) {
                    cells[i][j] = row.charAt(j) == '@' ? 1 : 0;
                    total += cells[i][j];
                    sumRow[i] += cells[i][j];
                    sumCol[j] += cells[i][j];
                }
                sumRows[i] += sumRow[i];
                if (i > 0) {
                    sumRows[i] += sumRows[i - 1];
                }
            }
            for (int j = 0; j < C; j ++) {
                int count = j;
                sumCols[j] += sumCol[j];
                while (count > 0) {
                    sumCols[j] += sumCol[count - 1];
                    count --;
                }
            }

            // # of chips < # of pieces or
            // # of pieces is not divisible by # of chips
            if (total < (H+1) * (V+1) || total % (H+1) * (V+1) != 0) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                // chips needed for each piece
                int chips = total / (H+1) * (V+1);
                // check horizontals

                // check verticals

                // check cell

                // System.out.println("Case #" + t + ": " + "POSSIBLE");

            }


        }
    }
}
