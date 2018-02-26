package women2018.problemA;

import java.util.*;
import java.io.*;

public class Main {

    static String readpath = "./ins/A-large-practice.in";
    static String outpath = "./outs/A-large-output.txt";

    public static void main(String[] args) throws IOException {

        // read file
        Scanner in = new Scanner(new FileReader(readpath));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));

        // get total number
        int T = in.nextInt();
        //System.out.println("T==========" + T);

        // new outputs
        String[] O = new String[T];

        // handle each task
        for(int i=0; i<T; i++){
            // get number of ingredients
            int K = in.nextInt();
            //System.out.println("K===========" + K);

            // store each optimal distance
            int[] D = new int[K];
            for(int j=0; j<K; j++){
                D[j] = in.nextInt();
            }

//            // find minimum possible error by full permutation
//            Permute permute = new Permute();
//            permute.perm(D, 0);
//            System.out.println("Case #" + (i + 1) + ": " + permute.min);
//            out.append("Case #" + (i + 1) + ": " + permute.min + '\n');

            // find minimum possible error by sorted lists
            Sort sort = new Sort();
            System.out.println("Case #" + (i + 1) + ": " + sort.calculate(D));
            out.append("Case #" + (i + 1) + ": " + sort.calculate(D) + '\n');

        }

        in.close();
        out.close();


    }

}
