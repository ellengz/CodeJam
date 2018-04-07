package y2018.women.B;

import java.io.*;
import java.util.Scanner;

public class Big {

    static String readpath = "./ins/B-large-practice.in";
    static String outpath = "./outs/B-large-output.txt";

    public static void main(String[] args) throws IOException{

        // read file
        Scanner in = new Scanner(new FileReader(readpath));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));

        // get total number of cases
        long T = in.nextLong();
        for(int i=0; i<T; i++) {

            // number of levels
            int n = in.nextInt();

            // store # of employees and level
            Long[][] D = new Long[n][2];
            for (int j=0; j<n; j++){
                D[j][0] = in.nextLong();
                D[j][1] = in.nextLong();
            }

//            for (int j=0; j<n; j++) {
//                System.out.println( D[j][0] + "==============" + D[j][1]);
//            }
            Long level = findCEO(D);
            System.out.println("Case #" + (i + 1) + ": " + level);
            out.append("Case #" + (i + 1) + ": " +  level + '\n');

        }

        in.close();
        out.close();

    }
    public static Long findCEO(Long[][] D){

        Long need = Long.valueOf(0);

        if (D.length > 1){
            for (int i=0; i<D.length - 1; i++){

                // gap in this round
                Long gap = D[i+1][1] * D[i+1][0] - D[i][0];

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

        need -= D[D.length - 1][0];
        System.out.println("~~~~~~~~~~~~~" + need);

        return (D[D.length - 1][1] + 1) >= (- need) ? (D[D.length - 1][1] + 1): (- need);
    }
    
}
