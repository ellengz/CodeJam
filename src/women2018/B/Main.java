package women2018.B;

import java.io.*;
import java.util.Scanner;

public class Main {

    static String readpath = "./ins/B-small-practice.in";
    static String outpath = "./outs/B-small-output.txt";

    public static void main(String[] args) throws IOException {
        // read file
        Scanner in = new Scanner(new FileReader(readpath));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));

        // get total number of cases
        int T = in.nextInt();

        // handle each case
        for(int i=0; i<T; i++) {

            // number of levels
            int n = in.nextInt();

            // store # of employees and level
            int[][] D = new int[n][2];
            for (int j=0; j<n; j++){
                D[j][0] = in.nextInt();
                D[j][1] = in.nextInt();
            }

            System.out.println("Case #" + (i + 1) + ": " + findCEO(D));
            out.append("Case #" + (i + 1) + ": " +  findCEO(D) + '\n');

        }

        in.close();
        out.close();
    }

    public static int findCEO(int[][] D){

        int need = 0;

        if (D.length > 1){
            for (int i=0; i<D.length - 1; i++){

                // gap in this round
                int gap = D[i+1][1] * D[i+1][0] - D[i][0];

                // check if there's need in last round
                // if so
                if (need < 0){
                    need += gap;
                    // if gap is enough to cover need, reset need to 0
                    // else, keep the need
                    need = (need >= 0 ? 0 : need);
                    // if not, only care the need for this round
                }else{
                    need = (gap >= 0 ? 0 : gap);
                }
            }
        }

        // search from 1 level higher
        int l = D[D.length - 1][1] + 1;
        while (l < 1000){
            if (l < D[D.length - 1][0] - need){
                l++;
            }else{
                break;
            }
        }

        return l;
    }

}



